package org.example.sprint1.service.seller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.sprint1.dto.*;
import org.example.sprint1.entity.Customer;
import org.example.sprint1.entity.Post;
import org.example.sprint1.entity.Seller;
import org.example.sprint1.exception.BadRequestException;
import org.example.sprint1.exception.NotFoundException;
import org.example.sprint1.repository.ICustomerRepository;
import org.example.sprint1.repository.ISellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SellerServiceImplementation implements ISellerService {
    @Autowired
    ISellerRepository sellerRepository;
    @Autowired
    ICustomerRepository customerRepository;

    private final static String ORDER_ASC = "date_asc";

    ObjectMapper mapper = new ObjectMapper();

    public SellerServiceImplementation() {
        mapper.registerModule(new JavaTimeModule());
    }

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

    public List<Seller> getSellers(){
        return sellerRepository.getSellersList();
    }

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

        // Ordenamos la lista según el query param
        if(ORDER_ASC.equals(order))
            listPostDto.sort(Comparator.comparing(PostDTO::getDate));
        else
            listPostDto.sort(Comparator.comparing(PostDTO::getDate).reversed());

        return new ResponsePostDTO(userId, listPostDto);
    }

    @Override
    public void createPromoPost(RequestPromoPostDTO promoPostDTO) {
        Seller seller = sellerRepository.getSellerById(promoPostDTO.getUserId());
        if(seller == null){
            throw new NotFoundException("No existe un vendedor con ese ID");
        }

        Post post = mapper.convertValue(promoPostDTO, Post.class);

        int uuid = Math.abs(UUID.randomUUID().hashCode());
        post.setPostId(uuid);
        if (sellerRepository.postIdExist(post.getPostId())){
            throw new BadRequestException("El ID de la publicacion ya existe");
        }

        seller.getPosts().add(post);
    }

    @Override
    public ResponsePromoCountDTO getPromoPostCount(int userId) {
        Seller seller = sellerRepository.getSellerById(userId);
        if(seller == null){
            throw new NotFoundException("No existe un vendedor con ese ID");
        }

        return new ResponsePromoCountDTO(userId, seller.getSellerName(), sellerRepository.getPromoPostCount(seller));
    }

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
}
