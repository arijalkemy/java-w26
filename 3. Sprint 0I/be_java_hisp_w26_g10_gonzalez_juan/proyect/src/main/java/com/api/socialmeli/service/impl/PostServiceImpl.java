package com.api.socialmeli.service.impl;

import com.api.socialmeli.dto.*;
import com.api.socialmeli.entity.Buyer;
import com.api.socialmeli.entity.Post;
import com.api.socialmeli.entity.Product;
import com.api.socialmeli.entity.Seller;
import com.api.socialmeli.exception.BadRequestException;
import com.api.socialmeli.exception.NotFoundException;
import com.api.socialmeli.mapper.PostMapper;
import com.api.socialmeli.repository.IPostRepository;
import com.api.socialmeli.repository.ISellerRepository;
import com.api.socialmeli.service.IBuyerService;
import com.api.socialmeli.service.IPostService;
import com.api.socialmeli.utils.Dates;
import com.api.socialmeli.validators.PostDtoValidator;
import com.api.socialmeli.validators.ProductDtoValidator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

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
    private int postId;

    @Override
    public PostDto publishPost(PostDto postDto) {
        Integer userId = postDto.getUser_id();
        boolean found = sellerRepository.getAll().stream().anyMatch(seller -> seller.getUser_id() == userId);

        if (!found) {
            throw new BadRequestException("No hay vendedor con el id: " + userId);
        }

        // generacion de consecutivo 'post_id'
        generatePostId();
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

    // MCaldera - funcion de generacion de consecutivo de 'post_id'
    private int generatePostId() {
        if (posts.isEmpty()) {
            postId = this.postRepository.searchPostId();
        } else {
            postId = (posts.stream().mapToInt(Post::getPost_id).max().orElse(0) + 1);
        }
        return postId;
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

    /* US 0010 */
    @Override
    public PostPromoDto publishPostPromo(PostPromoDto postPromoDto) {
        /* Verify the dto */
        PostDtoValidator.validate(postPromoDto);
        ProductDtoValidator.validate(postPromoDto.getProduct());

        /* change format of the date from DD-MM-AAAA to AAAA-MM-DD */
        String reversedDate = Dates.reverseDate(postPromoDto.getDate());

        /* check if the promo already exits */
        Optional<Post> promoExists = postRepository.getAll()
                .stream()
                .filter(
                        post ->
                            /* verify the fields of the post */
                            post.getDate().equals(LocalDate.parse(reversedDate))
                            && post.getCategory().equals(postPromoDto.getCategory())
                            && post.getPrice().equals(postPromoDto.getPrice())
                            && post.getUser_id().equals(postPromoDto.getUser_id())

                            /* verify the field of the product id */
                            && post.getProduct().getProduct_id().equals(postPromoDto.getProduct().getProduct_id())
                )
                .findFirst();

        /* if the promo exist check the status */
        if(promoExists.isPresent()){
            if(promoExists.get().isHas_promo() == true && promoExists.get().getDiscount() == postPromoDto.getDiscount()){
                throw new BadRequestException("El promocion ya se encuentra activa");
            }else if(promoExists.get().isHas_promo() == true && promoExists.get().getDiscount() != postPromoDto.getDiscount()){
                throw new BadRequestException("La promocion ya se encuentra activa, pero con un descuento diferente");
            } else if(promoExists.get().isHas_promo() == false && promoExists.get().getDiscount() != postPromoDto.getDiscount()){
                throw new BadRequestException("La promocion ya se encuentra cargada, pero inactiva, del mismo modo el descuento es diferente");
            }
        }

        /* check if the user id exist */
        Seller seller = sellerRepository.getById(postPromoDto.getUser_id());
        if(seller == null){
            throw new NotFoundException("No se localizo al vendedor con el id: " + postPromoDto.getUser_id());
        }

        /* Convert to PostPromoDto to Post */
        Post post = PostMapper.postPromoDtoToEntity(postPromoDto);

        /* Generates a new id and saves in the repository */
        generatePostId();
        post.setPost_id(postId);
        post.setDate(LocalDate.parse(reversedDate));
        postRepository.savePost(post);

        /* Set the id for the dto and return */
        postPromoDto.setPost_id(postId);
        return postPromoDto;
    }

    /* US 0011 */
    @Override
    public PostPromoCountDto getCountOfProductsPromosBySellerId(Integer seller_id) {
        /* validations of the seller_id */
        if(seller_id <= 0){
            throw new BadRequestException("El id del seller id no puede ser menor o igual a cero");
        }

        /* Verify if the seller exists */
        Seller seller = sellerRepository.getById(seller_id);
        if(seller == null){
            throw new NotFoundException("No se localizo al vendedor con el id: " + seller_id);
        }

        /* return the post promo count by seller id */
        int productsWithPromoCount = postRepository.getPostPromoBySellerId(seller_id).size();
        return new PostPromoCountDto(
                seller.getUser_id(),
                seller.getUser_name(),
                productsWithPromoCount
        );
    }

    /* US 0012 */
    @Override
    public PostPromoListDto getPostPromosOfSellerById(Integer seller_id) {
        /* validations of the seller_id */
        if(seller_id <= 0){
            throw new BadRequestException("El id del seller id no puede ser menor o igual a cero");
        }

        /* Verify if the seller exists */
        Seller seller = sellerRepository.getById(seller_id);
        if(seller == null){
            throw new NotFoundException("No se localizo al vendedor con el id: " + seller_id);
        }

        /* return the post promo count by seller id */
        List<PostPromoDto> productsWithPromo = postRepository
                .getPostPromoBySellerId(seller_id)
                .stream()
                .map(
                        post -> PostMapper.entityToPostPromoDto(post)

                ).toList();

        return new PostPromoListDto(
                seller.getUser_id(),
                seller.getUser_name(),
                productsWithPromo
        );
    }


}
