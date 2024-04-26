package bootcamp.sprint.grupo02.sprintI.service.implementations;

import bootcamp.sprint.grupo02.sprintI.dto.request.PostPromoDTO;
import bootcamp.sprint.grupo02.sprintI.dto.response.MessageResponseDTO;
import bootcamp.sprint.grupo02.sprintI.dto.response.PostListByBuyerResponseDTO;
import bootcamp.sprint.grupo02.sprintI.dto.response.PostPromoResponseDTO;
import bootcamp.sprint.grupo02.sprintI.dto.response.PostResponseDTO;
import bootcamp.sprint.grupo02.sprintI.enums.DateOrder;
import bootcamp.sprint.grupo02.sprintI.exception.BadRequestException;
import bootcamp.sprint.grupo02.sprintI.exception.NotFoundException;
import bootcamp.sprint.grupo02.sprintI.model.Post;
import bootcamp.sprint.grupo02.sprintI.model.Seller;
import bootcamp.sprint.grupo02.sprintI.repository.SellerRepository;
import bootcamp.sprint.grupo02.sprintI.service.BuyerService;
import bootcamp.sprint.grupo02.sprintI.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import bootcamp.sprint.grupo02.sprintI.dto.request.PostDTO;
import bootcamp.sprint.grupo02.sprintI.dto.request.ProductDTO;
import bootcamp.sprint.grupo02.sprintI.model.Product;
import org.springframework.stereotype.Service;

import bootcamp.sprint.grupo02.sprintI.repository.PostRepository;
import bootcamp.sprint.grupo02.sprintI.service.PostService;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    
    private final PostRepository repository;
    private final BuyerService buyerService;
    private final SellerRepository sellerRepository;
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






    @Override
    public MessageResponseDTO createPost(PostDTO dto) {
        Optional<Seller> sellerOptional = sellerRepository.findById(dto.getUserId());
        if(sellerOptional.isPresent()){
            Post post = parsePostDtoToModelWithOutDiscount(dto);
            repository.add(post);
            productService.addProduct(dto.getProduct());
            return new MessageResponseDTO("Ok");
        }
        else {
            throw new NotFoundException("There is no user with that id");
        }
    }

    @Override
    public MessageResponseDTO createPostWithDiscount(PostPromoDTO dto) {
        Optional<Seller> sellerOptional = sellerRepository.findById(dto.getUserId());
        if(sellerOptional.isPresent()){
            Post post = parsePostDtoToModelWithDiscount(dto);
            repository.add(post);
            productService.addProduct(dto.getProduct());
            return new MessageResponseDTO("OK");
        }
        else{
            throw new NotFoundException("There is no user with that id");
        }
    }

    @Override
    public int getAmountOfPostWithPromo(int userId) {
        List<Post> posts = repository.findAll();
        return posts.stream().filter(e-> e.getSellerId() == userId)
                .filter(Post::isHasPromo)
                .toList()
                .size();
    }



    /////////////////////PRIVATE METHODS/////////////////////


    private Post parsePostDtoToModelWithOutDiscount(PostDTO dto){
        Product product = parseProductDtoToModel(dto.getProduct());
        Post post = new Post(repository.findAll().size() + 1,dto.getUserId(),dateFormater(dto.getDate()),dto.getCategory(),dto.getPrice(),
                product, 1,false);
        return post;

    }
    private Post parsePostDtoToModelWithDiscount(PostPromoDTO dto){
        Product product = parseProductDtoToModel(dto.getProduct());
        Post post = new Post(repository.findAll().size() + 1,dto.getUserId(),dateFormater(dto.getDate()),dto.getCategory(),dto.getPrice(),
                product, dto.getDiscount(),dto.isHasPromo());
        return post;

    }

    private Product parseProductDtoToModel(ProductDTO dto){
        return new Product(dto.getProductId(),dto.getProductName(),dto.getType(),dto.getColor(),
                dto.getNotes(),dto.getBrand());
    }

    private LocalDate dateFormater(String str){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(str, formatter);
        return date;
    }
}
