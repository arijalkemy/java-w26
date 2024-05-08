package com.api.socialmeli.service.impl;

import com.api.socialmeli.dto.PostDto;
import com.api.socialmeli.dto.PostsByFollowedDto;
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

    private static final String ORDER_DATE_ASC = "date_asc";
    private static final String ORDER_DATE_DESC = "date_desc";

    @Autowired
    private IBuyerService buyerService;
    @Autowired
    private IPostRepository postRepository;
    @Autowired
    private ISellerRepository sellerRepository;
    private int postId;

    @Override
    public Post getPostById(Integer id) {
        Post post = postRepository.getById(id);
        if (post == null) throw new NotFoundException("El post no existe o no se encuentra registrado.");
        return post;
    }

    /**
     *
     * @param postDto: Array de datos de entrada
     * @return retorna el array de datos que se almacenan
     */
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

    /**
     *
     * @param postDto: Array de datos de entrada
     * @return retorna el objeto al cual se le desea realizar el proceso
     */
    private Post convertToPost(PostDto postDto) {
        try {
            ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
            return mapper.convertValue(postDto, Post.class);
        } catch (Exception e) {
            throw new BadRequestException(e + "Reviewed data");
        }
    }

    /**
     *
     * @param userId: identificador del usuario comprador que sigue a los vendedores
     * @param order: nombre del tipo de orden que se le aplicara a la fecha de los post
     * @return retorna el listado de las publicaciones de los vendedores que sigue filtrados por fecha
     */
    @Override
    public PostsByFollowedDto getPostsByFollowed(Integer userId, String order) {
        //Se busca el comprador y se guarda en una instacia de buyer con el id del usuario recibido
        Buyer buyer = buyerService.getBuyerById(userId);

        //Se crea la instancia del DTO que se va a devolver al controlador y se coloca el id del comprador en el dto
        PostsByFollowedDto postByFollowedDto = new PostsByFollowedDto();
        postByFollowedDto.setUser_id(userId);

        /*Con ayuda de la funcion se obtiene las publicaciones de los vendedores a los que sigue
        filtrado por fecha*/
        List<Post> postsFollowed = getPostsByFollowedFilter(buyer);

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

    /**
     *
     * @param idUser: identificador del vendedor dueño del post
     * @param ids: identificadores de los vendedores que sigue el comprador
     * @return Determina si el post es del vendedor que esta siguiendo
     */
    private boolean findIdInPost(Integer idUser, List<Integer> ids) {
        return ids.stream().anyMatch(id -> id.equals(idUser));
    }

    /**
     *
     * @param posts: la lista de los post
     * @param order: el nombre del orden que se aplica a la fecha de los post
     * @return devuelve la lista de post ordenados por fecha segun el orden enviado por parametro
     */
    List<Post> orderPostByDate(List<Post> posts, String order) {
        if (order == null || order.equalsIgnoreCase(ORDER_DATE_DESC)) {
            return posts.stream().sorted(Comparator.comparing(Post::getDate).reversed()).toList();
        } else if (order.equalsIgnoreCase(ORDER_DATE_ASC)) {
            return posts.stream().sorted(Comparator.comparing(Post::getDate)).toList();
        } else {
            throw new BadRequestException("El orden pedido no es valido");
        }
    }

    /**
     *
     * @param buyer: el comprador
     * @return La funcion devuelve el listado de las publicaciones de los vendedores a los que sigue
     *     filtrados  por el criterio de fecha
     */
    private List<Post> getPostsByFollowedFilter(Buyer buyer){
        //Se obtine la lista de ids de los compradores que sigue el comprador
        List<Integer> ids = buyer.getFollowed().stream().map(Seller::getUser_id).toList();
        if (ids.isEmpty()) {
            //Si no esta siguiendo a nadie devuelve a la funcion
            return new ArrayList<>();
        }

        //Se crean las fechas minima y maxima para comprender el periodo de los ultimos 15 dias
        LocalDate minDate = LocalDate.now().minusDays(15);
        LocalDate maxDate = LocalDate.now().plusDays(1);

        /*Se obtien todos las publicaciones, se filtra por las que fueron creadas por los vendedores que sigue
        con ayuda de la funcion finIdInPost y tambien se filtra con con las fecha minDate y maxDate para obtener
        las de los ultimos quince dias
         */
        return postRepository.getAll().stream().
                filter(post -> findIdInPost(post.getUser_id(), ids) && post.getDate().isAfter(minDate)
                        && post.getDate().isBefore(maxDate)).toList();
    }
}
