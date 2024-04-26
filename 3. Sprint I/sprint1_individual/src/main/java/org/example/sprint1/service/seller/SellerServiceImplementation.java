package org.example.sprint1.service.seller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.sprint1.dto.*;
import org.example.sprint1.entity.Customer;
import org.example.sprint1.entity.Post;
import org.example.sprint1.entity.Product;
import org.example.sprint1.entity.Seller;
import org.example.sprint1.exception.BadRequestException;
import org.example.sprint1.exception.NotFoundException;
import org.example.sprint1.repository.ICustomerRepository;
import org.example.sprint1.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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
    public List<SellerPromoListDto> getProductPromotionsList(int id) {

        putBadRequestForInvalidIdSeller(id);
        /**
         * Obtener el vendedor mediante id cuanto validamos que si existe.
         */
        Seller seller = sellerRepository.getSellerById(id);
        List<Post> v = seller.getPosts().stream().filter(Post::isHasPromo).toList();
        seller.setPosts(v);

        return Collections.singletonList(mapper.convertValue(seller, SellerPromoListDto.class));
    }

    @Override
    public SellersProductsCountDto getProductPromotionsCount(int id) {


        putBadRequestForInvalidIdSeller(id);

        /**
         * En el caso de que si exista el seller lo mandamos a buscar al repository
         */
        Seller seller = sellerRepository.filterSellerById(id);

        return new SellersProductsCountDto(id,
                seller.getSellerName(),
                (int) seller.getPosts()
                        .stream().filter(Post::isHasPromo).count());
    }

    private void putBadRequestForInvalidIdSeller(int id){
        /**
         *
         * Verificar que el sellerId que se esta buscando exista en la lista de sellers.
         * En caso de que no se encuentre mandamos BADREQUEST Exception.
         */
        if (sellerRepository.getSellerById(id) == null)
            throw new BadRequestException("El id ingresado no corresponde a uno existente");
    }

    @Override
    public String postProductPromotion(PostDTO requestProductPromoDto) {

        putBadRequestForInvalidIdSeller(requestProductPromoDto.getSellerId());

        sellerRepository.postNewPoroductWithPromotion(requestProductPromoDto);
        return "Post Agregado con exito";
    }


    private List<PostDTO> mappingPostToPostDto(Map<Integer, List<Post>> posts) {
        List<PostDTO> listPostDto = new ArrayList<>();

        for (Map.Entry<Integer, List<Post>> entry : posts.entrySet()) {
            // Mapea Post -> PostDTO y se agrega a una list de PostDTO
            listPostDto.addAll(
                    entry.getValue().stream()
                            .map(v -> mapper.convertValue(v, PostDTO.class))
                            .toList()
            );

            // A cada elemento de la lista se le asigna el id del seller que hizo la publicación
            listPostDto.forEach(post -> post.setSellerId(entry.getKey()));
        }

        return listPostDto;
    }
}
