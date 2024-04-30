package bootcamp.sprint.grupo02.sprintI.service.implementations;

import bootcamp.sprint.grupo02.sprintI.dto.response.*;
import bootcamp.sprint.grupo02.sprintI.enums.DateOrder;
import bootcamp.sprint.grupo02.sprintI.exception.BadRequestException;
import bootcamp.sprint.grupo02.sprintI.exception.NotFoundException;
import bootcamp.sprint.grupo02.sprintI.model.Post;
import bootcamp.sprint.grupo02.sprintI.model.Seller;
import bootcamp.sprint.grupo02.sprintI.service.BuyerService;
import bootcamp.sprint.grupo02.sprintI.service.ProductService;
import bootcamp.sprint.grupo02.sprintI.service.SellerService;
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

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository repository;
    private final BuyerService buyerService;
    private final ProductService productService;
    private final SellerService sellerService;

    @Override
    public List<PostResponseDTO> getAllBySellerId(int seller, String order) {
        if (order.equals(DateOrder.DATE_ASC.toString().toLowerCase())) {
            return repository.findBySellerId(seller)
                    .stream()
                    .map(this::convertToPostResponseDTO)
                    .sorted(Comparator.comparing(PostResponseDTO::getDate))
                    .toList();
        }
        if (order.equals(DateOrder.DATE_DESC.toString().toLowerCase())) {
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
        for (Seller seller : sellers) {
            postList.addAll(getBySellerIdLastTwoWeeks(seller.getId(), order));
            postListByBuyerResponseDTO.setPosts(postList);
        }
        return postListByBuyerResponseDTO;
    }

    private PostResponseDTO convertToPostResponseDTO(Post post) {
        PostResponseDTO postResponseDTO = new PostResponseDTO();
        postResponseDTO.setCategory(post.getCategory());
        postResponseDTO.setDate(post.getDate());
        postResponseDTO.setProduct(productService.convertToProductDTO(post.getProduct()));
        postResponseDTO.setPrice(post.getPrice());
        postResponseDTO.setPostId(post.getId());
        postResponseDTO.setUserId(post.getSellerId());
        return postResponseDTO;
    }

    private LocalDate dateFormater(String str) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(str, formatter);
        return date;
    }

    @Override
    public MessageResponseDTO createPost(PostDTO dto) {
        Post post = parsePostDtoToModel(dto, false);
        repository.add(post);
        productService.addProduct(dto.getProduct());
        return new MessageResponseDTO("Ok");
    }

    //US 0010

    /**
     * Create a promotional post for a product and return a message.
     *
     * @param postDto containing information about the promotional post to be created.
     * @return A message response DTO indicating the success of the promotional post creation.
     * @throws BadRequestException If the product does not have a valid promotion or if the discount value is invalid.
     */
    public MessageResponseDTO createPostPromo(PostDTO postDto) {
        sellerService.findById(postDto.getUserId());
        if (!postDto.isHasPromo() || postDto.getDiscount() <= 0) {
            throw new BadRequestException("The product has no promotion");
        }
        Post post = parsePostDtoToModel(postDto, true);
        repository.add(post);
        productService.addProduct(postDto.getProduct());
        return new MessageResponseDTO("Promotional post successfully created");
    }

    /**
     * Parses a PostDTO object into a Post model.
     *
     * @param dto The PostDTO object to parse.
     * @param applyDiscount A boolean flag indicating whether to apply a discount for promotional posts.
     * @return The Post model created from the provided PostDTO.
     */
    private Post parsePostDtoToModel(PostDTO dto, boolean applyDiscount) {
        ProductDTO proDto = dto.getProduct();
        Product product = new Product(proDto.getProductId(), proDto.getProductName(), proDto.getType(),
                proDto.getColor(),
                proDto.getNotes(), proDto.getBrand());

        double discount = applyDiscount ? dto.getDiscount() : 0; //sino tiene entonces 0
        boolean hasPromo = applyDiscount && dto.isHasPromo(); //para setear en false cuando no tiene prom


        Post post = new Post(repository.findAll().size() + 1, dto.getUserId(), dateFormater(dto.getDate()),
                dto.getCategory(), dto.getPrice(),
                product, discount, hasPromo);

        return post;
    }
    ///////////////
//// US 0011

    /**
     * Finds promotional posts by a seller and returns a DTO with the seller information and the count
     * of their promotional products.
     *
     * @param id The ID of the seller.
     * @return A DTO containing information about the seller and the count of their promotional products.
     * @throws NotFoundException If the seller with the given ID is not found.
     */
    public SellerPromoResponseDTO findSellerPromoPostCount(int id) {
        Seller seller = sellerService.findById(id);
        UserResponseDTO userResponseDTO = new UserResponseDTO(seller.getId(), seller.getName());
        return SellerPromoResponseDTO.builder()
                .user(userResponseDTO)
                .promoProductsCount(this.repository.findByPromoPost(id).size())
                .build();
    }


    ///US 0012

    /**
     * Finds all promotional products with a specific type of product posted by a seller.
     *
     * @param id The ID of the seller.
     * @return A DTO containing the seller information and their promotional posts.
     * @throws NotFoundException If the seller with the given ID is not found.
     */
    public SellerPromoResponseDTO findPromoPostsBySellerAndType(int id, String type) {
        Seller seller = sellerService.findById(id);
        List<Post> posts = repository.findByPromoPostProductByType(id, type);

        UserResponseDTO userResponseDTO = new UserResponseDTO(seller.getId(), seller.getName());
        Integer promoCount = null;
        return SellerPromoResponseDTO.builder()
                .user(userResponseDTO)
                .promoProductsCount(promoCount)
                .posts(posts.stream().map(this::convertToPromPostResponseDTO).toList())
                .build();
    }


    /**
     * Converts a Post model into a DTO containing all the information of a promotional post.
     *
     * @param post The Post object to be converted.
     * @return A DTO containing all the information of a promotional post.
     */
    private PromPostResponseDTO convertToPromPostResponseDTO(Post post) {
        return new PromPostResponseDTO(post.getSellerId(),
                post.getId(), post.getDate(), productService.convertToProductDTO(post.getProduct())
                , post.getCategory(), post.getPrice(), post.isHasPromo(),
                post.getDiscount());
    }


}