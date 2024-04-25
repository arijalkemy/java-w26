package bootcamp.sprint.grupo02.sprintI.service.implementations;

import bootcamp.sprint.grupo02.sprintI.dto.response.*;
import bootcamp.sprint.grupo02.sprintI.enums.DateOrder;
import bootcamp.sprint.grupo02.sprintI.exception.BadRequestException;
import bootcamp.sprint.grupo02.sprintI.model.Post;
import bootcamp.sprint.grupo02.sprintI.model.Seller;
import bootcamp.sprint.grupo02.sprintI.service.BuyerService;
import bootcamp.sprint.grupo02.sprintI.service.ProductService;
import bootcamp.sprint.grupo02.sprintI.dto.request.PostDTO;
import bootcamp.sprint.grupo02.sprintI.dto.request.ProductDTO;
import bootcamp.sprint.grupo02.sprintI.model.Product;
import bootcamp.sprint.grupo02.sprintI.repository.ProductRepository;
import bootcamp.sprint.grupo02.sprintI.service.SellerService;
import org.springframework.stereotype.Service;

import bootcamp.sprint.grupo02.sprintI.repository.PostRepository;
import bootcamp.sprint.grupo02.sprintI.service.PostService;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository repository;
    private final BuyerService buyerService;
    private final ProductService productService;
    private final SellerService sellerService;

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

            Post post = parsePostDtoToModel(dto);
            repository.add(post);
            productService.addProduct(dto.getProduct());
            return new MessageResponseDTO("Ok");
    }

    @Override
    public MessageResponseDTO createPromoPost(PostDTO postDTO) {
        Post post = parsePostDtoToModel(postDTO, postDTO.getDiscount(), postDTO.isHasPromo());
        productService.addProduct(postDTO.getProduct());
        repository.add(post);
        return new MessageResponseDTO("Promotion post created successfully.");
    }

    @Override
    public PromoProductsCountResponseDTO getPromoProductsQuantity(int userId) {
        Seller seller = obtainSeller(userId);
        List<Post> sellerPostsWithPromo = repository.findPromoPostBySellerId(userId);

        return new PromoProductsCountResponseDTO(
            userId,
            seller.getName(),
            sellerPostsWithPromo.size()
        );
    }

    @Override
    public PromoProductsResponseDTO getPromoProducts(int userId) {
        Seller seller = obtainSeller(userId);
        List<Post> sellerPostsWithPromo = repository.findPromoPostBySellerId(userId);

        return new PromoProductsResponseDTO(
                userId,
                seller.getName(),
                parsePostsModelsToDTOs(sellerPostsWithPromo)
        );
    }


    /////////////////////METODOS PRIVADOS/////////////////////
    private Post parsePostDtoToModel(PostDTO dto){
        return parsePostDtoToModel(dto, 1, false);
    }

    private Post parsePostDtoToModel(PostDTO dto, double discount, boolean hasPromo){
        ProductDTO proDto = dto.getProduct();

        Product product = new Product(proDto.getProductId(),proDto.getProductName(),proDto.getType(),proDto.getColor(),
                proDto.getNotes(),proDto.getBrand());

        Post post = new Post(
            repository.findAll().size() + 1,
            dto.getUserId(),
            dateFormater(dto.getDate()),
            dto.getCategory(),
            dto.getPrice(),
            product,
            discount,
            hasPromo
        );

        return post;
    }

    private PostDTO parsePostModelToDTO(Post post){
        Product product = post.getProduct();

        ProductDTO productDTO = new ProductDTO(
                product.getId(),
                product.getName(),
                product.getType(),
                product.getColor(),
                product.getNotes(),
                product.getBrand()
        );

        return new PostDTO(
                repository.findAll().size() + 1,
                post.getDate().toString(),
                productDTO,
                post.getCategory(),
                post.getPrice(),
                post.isHasPromo(),
                post.getDiscount()
        );
    }

    private List<PostDTO> parsePostsModelsToDTOs(List<Post> posts) {
        return posts
                .stream()
                .map(post -> parsePostModelToDTO(post))
                .collect(Collectors.toList());
    }

    private LocalDate dateFormater(String str){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(str, formatter);
        return date;
    }

    private Seller obtainSeller(int sellerId) {
        Seller seller = sellerService.findById(sellerId);
        if(seller == null) throw new BadRequestException(
                "Not found seller with Id: " + sellerId
        );
        return seller;
    }
}
