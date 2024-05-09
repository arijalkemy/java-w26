package org.example.SocialMeli2.service.seller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.SocialMeli2.dto.PostDTO;
import org.example.SocialMeli2.dto.RequestPostDTO;
import org.example.SocialMeli2.dto.ResponsePostDTO;
import org.example.SocialMeli2.entity.Customer;
import org.example.SocialMeli2.entity.Post;
import org.example.SocialMeli2.entity.Seller;
import org.example.SocialMeli2.exception.BadRequestException;
import org.example.SocialMeli2.exception.NotFoundException;
import org.example.SocialMeli2.repository.ICustomerRepository;
import org.example.SocialMeli2.repository.ISellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Implementación del servicio de vendedor.
 */
@Service
public class SellerServiceImplementation implements ISellerService {
    @Autowired
    ISellerRepository sellerRepository;
    @Autowired
    ICustomerRepository customerRepository;

    private final static String ORDER_ASC = "date_asc";
    private final static String ORDER_DESC = "date_desc";

    ObjectMapper mapper = new ObjectMapper();

    public SellerServiceImplementation() {
        mapper.registerModule(new JavaTimeModule());
    }

    /**
     * Agrega un nuevo post.
     *
     * @param postDTO El DTO del post a agregar.
     * @return El post agregado.
     * @throws NotFoundException si no existe un vendedor con el ID proporcionado.
     * @throws BadRequestException si el ID del producto ya existe o si el ID de la publicación ya existe.
     */
    @Override
    public Post addPost(RequestPostDTO postDTO) {

//        Revisar si existe el Usuario
        Seller seller = sellerRepository.getSellerById(postDTO.getUserId());
        if (seller == null) {
            throw new NotFoundException("No existe un Vendedor con ese ID");
        }
//        Crear objeto Post a partir de RequestPostDTO
        Post post = mapper.convertValue(postDTO,Post.class);

//        Revisar que el Id del producto no exista en ningun vendedor
        boolean idExists = sellerRepository.productIdExists(post.getProduct().getProductId());
        if(idExists){
            throw new BadRequestException("El ID del producto ya existe");
        }

//        Asignar un Post ID
        int uuid = Math.abs(UUID.randomUUID().hashCode());
        post.setPostId(uuid);
        if (sellerRepository.postIdExist(post.getPostId())){
            throw new BadRequestException("El ID de la publicacion ya existe");
        }

//        Agregar post al listado de sellers
        seller.getPosts().add(post);

        return post;
    }

    /**
     * Obtiene una lista de todos los vendedores.
     *
     * @return Una lista de vendedores.
     */
    public List<Seller> getSellers(){
        return sellerRepository.getSellersList();
    }

    /**
     * Obtiene los posts de los vendedores seguidos que tienen menos de dos semanas de antigüedad.
     *
     * @param userId El ID del usuario.
     * @param order El orden en el que se desea obtener los posts.
     * @return Un DTO con la respuesta de los posts.
     * @throws NotFoundException si no existe un cliente con el ID proporcionado.
     * @throws BadRequestException si el orden proporcionado no es válido.
     */
    @Override
    public ResponsePostDTO getPostsFromFollowingWithTwoWeeksOld(int userId, String order) {
        // Obtiene customer con userId
        Customer customer = customerRepository.findCustomerById(userId);
        if(customer == null){
            throw new NotFoundException("No existe un cliente con ese ID");
        }

        // Obtiene un map<idSeller, PostsDelSeller> de los usuarios que sigue el customer
        Map<Integer, List<Post>> postsByFollowing = sellerRepository.findPostsByFollowing(customer.getSellers());

        // Convierte el map en list de PostDto para poder generar un ResponsePostDTO
        List<PostDTO> listPostDto = mappingPostToPostDto(postsByFollowing);
        List<PostDTO> listOrderedPostDto = orderBy(order, listPostDto);

        return new ResponsePostDTO(userId, listOrderedPostDto);
    }

    /**
     * Convierte un Map de Posts en una lista de PostDTO.
     *
     * @param posts El Map de Posts a convertir.
     * @return Una lista de PostDTO.
     */
    private List<PostDTO> mappingPostToPostDto(Map<Integer, List<Post>> posts) {
        List<PostDTO> listPostDto = new ArrayList<>();

        for (Map.Entry<Integer, List<Post>> entry : posts.entrySet()) {
            // Mapea Post -> PostDTO y agrega un idSeller
            listPostDto.addAll(
                    entry.getValue().stream()
                            .map(v -> {
                                PostDTO postDTO = mapper.convertValue(v, PostDTO.class);
                                postDTO.setSellerId(entry.getKey());
                                return postDTO;
                            })
                            .toList()
            );
        }

        return listPostDto;
    }

    /**
     * Ordena una lista de PostDTO de acuerdo al orden especificado.
     *
     * @param order El orden en el que se desea ordenar los posts.
     * @param posts La lista de PostDTO a ordenar.
     * @return Una lista de PostDTO ordenada.
     * @throws BadRequestException si el orden proporcionado no es válido.
     */
    private List<PostDTO> orderBy(String order, List<PostDTO> posts) {
        if(order == null)
            return posts;

        switch (order) {
            case ORDER_ASC:
                posts.sort(Comparator.comparing(PostDTO::getDate));
                break;

            case ORDER_DESC:
                posts.sort(Comparator.comparing(PostDTO::getDate).reversed());
                break;

            default:
                throw new BadRequestException("Orden no encontrado");
        }

        return posts;
    }
}
