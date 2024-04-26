package org.example.sprint1.service.seller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.sprint1.dto.*;
import org.example.sprint1.entity.Customer;
import org.example.sprint1.entity.Post;
import org.example.sprint1.entity.Seller;
import org.example.sprint1.exception.BadRequestException;
import org.example.sprint1.exception.NotFoundException;
import org.example.sprint1.repository.CustomerRepository;
import org.example.sprint1.repository.ICustomerRepository;
import org.example.sprint1.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SellerServiceImplementation implements ISellerService {
    @Autowired
    SellerRepository sellerRepository;
    @Autowired
    ICustomerRepository customerRepository;


    ObjectMapper mapper = new ObjectMapper();

    public SellerServiceImplementation() {
        mapper.registerModule(new JavaTimeModule());
    }

    @Override
    public Post addPost(RequestPostDTO postDTO) {

//        Revisar si existe el Usuario
        Seller seller = sellerRepository.filterSellerById(postDTO.getUserId());
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
    public ResponsePostDTO getPostsFromFollowingWithTwoWeeksOld(int userId, Optional<String> order) {
        // Obtiene customer con userId
        Customer customer = customerRepository.findCustomerById(userId);
        if(customer == null){
            throw new NotFoundException("No existe un cliente con ese ID");
        }

        // Obtiene un map<idSeller, PostsDelSeller> de los usuarios que sigue el customer
        Map<Integer, List<Post>> postsByFollowing = sellerRepository.findPostsByFollowing(customer.getSellers());

        // Convierte el map en list de PostDto para poder generar un ResponsePostDTO
        List<PostDTO> listPostDto = mappingPostToPostDto(postsByFollowing);

        // Ordenamos la lista según se pida
        if(order.isPresent() && order.get().equals("date_asc"))
            listPostDto.sort(Comparator.comparing(PostDTO::getDate));
        else
            listPostDto.sort(Comparator.comparing(PostDTO::getDate).reversed());

        return new ResponsePostDTO(userId, listPostDto);
    }

    @Override
    public ResponsePromoDTO getPostsWithPromo(int userId) {
        Seller seller = sellerRepository.filterSellerById(userId);
        if(seller == null) throw new NotFoundException("No existe un cendedor con ese ID");

        // Cuenta el total de publicaciones con promoción
        int numberOfPromos = seller.getPosts().stream()
                .filter(Post::isHasPromo)
                .toList()
                .size();

        return new ResponsePromoDTO(seller.getSellerId(), seller.getSellerName(), numberOfPromos);
    }

    private List<PostDTO> mappingPostToPostDto(Map<Integer, List<Post>> posts) {
        List<PostDTO> listPostDto = new ArrayList<>();

        for (Map.Entry<Integer, List<Post>> entry : posts.entrySet()) {
            // Mapea Post -> PostDTO y se agrega a una list de PostDTO
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
