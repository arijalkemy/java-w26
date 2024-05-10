package com.api.socialmeli.service.impl;

import com.api.socialmeli.dto.*;
import com.api.socialmeli.entity.Buyer;
import com.api.socialmeli.entity.Post;
import com.api.socialmeli.entity.Seller;
import com.api.socialmeli.exception.BadRequestException;
import com.api.socialmeli.exception.NotFoundException;
import com.api.socialmeli.repository.IPostRepository;
import com.api.socialmeli.repository.ISellerRepository;
import com.api.socialmeli.service.IBuyerService;
import com.api.socialmeli.service.IPostService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class PostServiceImpl implements IPostService {

    @Autowired
    private IBuyerService buyerService;
    @Autowired
    private IPostRepository postRepository;
    @Autowired
    private ISellerRepository sellerRepository;

    // MCaldera - Declaracion de array para almacenamiento de datos
    private final List<Post> posts = new ArrayList<>();
    private Integer postId;

    // MCaldera - Funcion encargada de retornar el dto almacenado en el array de posts
    @Override
    public PostDto publishPost(PostDto postDto) {
        Integer userId = postDto.getUser_id();
        boolean found = sellerRepository.getAll().stream().anyMatch(seller -> seller.getUser_id() == userId);

        if (!found) {
            throw new BadRequestException("No hay vendedor con el id: " + userId);
        }

        // generacion de consecutivo 'post_id'
        postId = this.postRepository.searchPostId();
        // seteo de consecutivo generado
        postDto.setPost_id(postId);
        // conversion de dto a objeto
        Post post = convertToPost(postDto);

        // se almacena el objeto en el array
        postRepository.savePost(post);
        //posts.add(post);
        // se retorna el dto generado para la respuesta
        return postDto;
    }

    // MCaldera - Funcion correspondiente a la publicacion de nuevos posts con promos
    @Override
    public PromoPostDto publishPromoPost(PromoPostDto promoPostDto) {
        // se inicializa el postDto
        PostDto promo = new PostDto(promoPostDto.getPost_id(), promoPostDto.getUser_id(), promoPostDto.getDate(), promoPostDto.getProduct(), promoPostDto.getCategory(), promoPostDto.getPrice(), promoPostDto.getHas_promo(), promoPostDto.getDiscount());
        // se realiza el llamado de postDto
        publishPost(promo);
        // seteo de valor 'post_id' para retorno de promoPostDto
        promoPostDto.setPost_id(promo.getPost_id());
        return promoPostDto;
    }

    // MCaldera - Se implementa funcion que retorna dto con la informacion de conteo por posts por seller
    @Override
    public PromoPostBySellerDto getPromoPosts(Integer user_id) {

        Seller promoPosts = this.sellerRepository.getById(user_id);
        int cnt = this.postRepository.getCountPromoPosts(user_id);
        PromoPostBySellerDto promoPostBySellerDto = new PromoPostBySellerDto(promoPosts.getUser_id(), promoPosts.getUser_name(), cnt);

        return promoPostBySellerDto;
    }

    // MCaldera - Se implementa funcion que retorna dto de posts por vendedor
    @Override
    public SellerPostsDto getPromoBySeller(Integer user_id) {
        Seller promoPosts = this.sellerRepository.getById(user_id);
        List<PromoPostDto> promoPostDtos = this.postRepository.getAllSellerById(user_id);

        SellerPostsDto sellerPostsDto = new SellerPostsDto(promoPosts.getUser_id(),promoPosts.getUser_name(), promoPostDtos);
        return sellerPostsDto;
    }

    // MCaldera - Metodo main para el retorno del objeto
    private Post convertToPost(PostDto postDto) {
        try {
            ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
            return mapper.convertValue(postDto, Post.class);
        } catch (Exception e) {
            throw new BadRequestException(e + "Reviewed data");
        }
    }

    @Override
    public PostsByFollowedDto getPostsByFollowed(Integer userId, String order) {
        //Se busca el comprador y se guarda en una instacia de buyer con el id del usuario recibido
        Buyer buyer = buyerService.getBuyerById(userId);

        if (buyer == null) {
            //Si no se encontro el comprador lanza la excepcion Not Found Exception
            throw new NotFoundException("No se encontro el usuario con id: " + userId);
        }

        //Se crea la instancia del DTO que se va a devolver al controlador y se coloca el id del comprador en el dto
        PostsByFollowedDto postByFollowedDto = new PostsByFollowedDto();
        postByFollowedDto.setUser_id(userId);

        //Se obtine la lista de ids de los compradores que sigue el comprador
        List<Integer> ids = buyer.getFollowed().stream().map(Seller::getUser_id).toList();
        if (ids.isEmpty()) {
            //Si no esta siguiendo a nadie devuelve en dto al controlador
            postByFollowedDto.setPosts(new ArrayList<>());
            return postByFollowedDto;
        }

        //Se crean las fechas minima y maxima para comprender el periodo de los ultimos 15 dias
        LocalDate minDate = LocalDate.now().minusDays(15);
        LocalDate maxDate = LocalDate.now().plusDays(1);

        /*Se obtien todos las publicaciones, se filtra por las que fueron creadas por los vendedores que sigue
        con ayuda de la funcion finIdInPost y tambien se filtra con con las fecha minDate y maxDate para obtener
        las de los ultimos quince dias
         */
        List<Post> postsFollowed = postRepository.getAll().stream().
                filter(post -> findIdInPost(post.getUser_id(), ids) && post.getDate().isAfter(minDate)
                        && post.getDate().isBefore(maxDate)).toList();

        if (postsFollowed.isEmpty()) {
            //Si los vendedores que sigue no tiene publicaciones devuelve el dto al controlador
            postByFollowedDto.setPosts(new ArrayList<>());
            return postByFollowedDto;
        }

        //Se llama a la funcion para ordenar las publicaciones segun los el parametro de order
        postsFollowed = orderPostByDate(postsFollowed, order);

        //Se crea el mapper para transformar las publicaciones a dto
        ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

        //Se colocan las lista de las publicaciones transformadas en el dto
        postByFollowedDto.setPosts(
                postsFollowed.stream().map(post -> mapper.convertValue(post, PostDto.class)).toList());

        return postByFollowedDto;
    }

    /*Determina si el post es del vendedor que esta siguiendo, con la lista de ids de los vendedores que sigue
      y el id del creador de la publicacion*/
    private boolean findIdInPost(Integer idUser, List<Integer> ids) {
        return ids.stream().anyMatch(id -> id.equals(idUser));
    }

    //Ordena la lista de post por fecha segun el orden enviado por parametro
    List<Post> orderPostByDate(List<Post> posts, String order) {
        if (order == null || order.equalsIgnoreCase("date_desc")) {
            return posts.stream().sorted(Comparator.comparing(Post::getDate).reversed()).toList();
        } else if (order.equalsIgnoreCase("date_asc")) {
            return posts.stream().sorted(Comparator.comparing(Post::getDate)).toList();
        } else {
            throw new BadRequestException("El orden pedido no es valido");
        }
    }
}
