package bootcamp.sprint.grupo02.sprintI.service.implementations;

import bootcamp.sprint.grupo02.sprintI.dto.response.MessageResponseDTO;
import bootcamp.sprint.grupo02.sprintI.dto.response.PostListByBuyerResponseDTO;
import bootcamp.sprint.grupo02.sprintI.dto.response.PostResponseDTO;
import bootcamp.sprint.grupo02.sprintI.enums.DateOrder;
import bootcamp.sprint.grupo02.sprintI.exception.BadRequestException;
import bootcamp.sprint.grupo02.sprintI.model.Post;
import bootcamp.sprint.grupo02.sprintI.model.Seller;
import bootcamp.sprint.grupo02.sprintI.service.BuyerService;
import bootcamp.sprint.grupo02.sprintI.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import bootcamp.sprint.grupo02.sprintI.dto.request.PostDTO;
import bootcamp.sprint.grupo02.sprintI.dto.request.ProductDTO;
import bootcamp.sprint.grupo02.sprintI.model.Product;
import bootcamp.sprint.grupo02.sprintI.repository.ProductRepository;
import org.springframework.stereotype.Service;

import bootcamp.sprint.grupo02.sprintI.repository.PostRepository;
import bootcamp.sprint.grupo02.sprintI.service.PostService;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    
    private final PostRepository repository;
    private final BuyerService buyerService;
    private final ProductService productService;
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<PostResponseDTO> getAllBySellerId(int seller, String order) {
        if(order.equals(DateOrder.DATE_ASC.toString().toLowerCase())) {
            return repository.findBySellerId(seller)
                    .stream()
                    .map(this::convertToPostResponseDTO)
                    .sorted(Comparator.comparing(PostResponseDTO::getDate))
                    .toList();
        } if(order.equals(DateOrder.DATE_DESC.toString().toLowerCase())) {
            return repository.findBySellerId(seller)
                    .stream()
                    .map(this::convertToPostResponseDTO)
                    .sorted(Comparator.comparing(PostResponseDTO::getDate).reversed())
                    .toList();
        }
        throw new BadRequestException("Invalid order");
    }

    @Override
    public List<PostResponseDTO> getBySellerIdLastTwoWeeks(int sellerId, String order) {
        return getAllBySellerId(sellerId, order)
                .stream()
                .filter(p -> p.getDate().isAfter(LocalDate.now().minusDays(14L)))
                .toList();
    }

    @Override
    public PostListByBuyerResponseDTO findPostsByBuyer(int id, String order) {
        List<Seller> sellers = buyerService.getAllSellers(id);
        PostListByBuyerResponseDTO postListByBuyerResponseDTO = new PostListByBuyerResponseDTO();
        postListByBuyerResponseDTO.setUserId(id);
        List<PostResponseDTO> postList = new ArrayList<>();
        for(Seller seller : sellers){
            postList.addAll(getBySellerIdLastTwoWeeks(seller.getId(), order));
            postListByBuyerResponseDTO.setPosts(postList);
        }
        return postListByBuyerResponseDTO;
    }

    private PostResponseDTO convertToPostResponseDTO(Post post){
        PostResponseDTO postResponseDTO = new PostResponseDTO();
        postResponseDTO.setCategory(post.getCategory());
        postResponseDTO.setDate(post.getDate());
        postResponseDTO.setProduct(productService.convertToProductDTO(post.getProduct()));
        postResponseDTO.setPrice(post.getPrice());
        postResponseDTO.setPostId(post.getId());
        postResponseDTO.setUserId(post.getSellerId());
        return postResponseDTO;
    }


    private final ProductRepository productRepository;



    @Override
    public MessageResponseDTO createPost(PostDTO dto) {

            Post post = parsePostDtoToModelWithOutDiscount(dto);
            repository.add(post);
            productService.addProduct(dto.getProduct());
            return new MessageResponseDTO("Ok");
    }


    /////////////////////METODOS PRIVADOS/////////////////////
    private Post parsePostDtoToModelWithOutDiscount(PostDTO dto){
        ProductDTO proDto = dto.getProduct();

        Product product = new Product(proDto.getProductId(),proDto.getProductName(),proDto.getType(),proDto.getColor(),
                proDto.getNotes(),proDto.getBrand());

        Post post = new Post(repository.findAll().size() + 1,dto.getUserId(),dateFormater(dto.getDate()),dto.getCategory(),dto.getPrice(),
                product, 1,false);

        return post;

    }
    private LocalDate dateFormater(String str){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(str, formatter);
        return date;
    }
}
