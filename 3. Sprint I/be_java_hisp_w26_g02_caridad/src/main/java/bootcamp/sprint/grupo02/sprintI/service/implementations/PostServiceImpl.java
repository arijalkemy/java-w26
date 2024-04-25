package bootcamp.sprint.grupo02.sprintI.service.implementations;

import bootcamp.sprint.grupo02.sprintI.dto.request.PostPromoDTO;
import bootcamp.sprint.grupo02.sprintI.dto.response.*;
import bootcamp.sprint.grupo02.sprintI.enums.DateOrder;
import bootcamp.sprint.grupo02.sprintI.exception.BadRequestException;
import bootcamp.sprint.grupo02.sprintI.exception.NotFoundException;
import bootcamp.sprint.grupo02.sprintI.model.Post;
import bootcamp.sprint.grupo02.sprintI.model.Seller;
import bootcamp.sprint.grupo02.sprintI.service.BuyerService;
import bootcamp.sprint.grupo02.sprintI.service.ProductService;
import bootcamp.sprint.grupo02.sprintI.service.SellerService;
import bootcamp.sprint.grupo02.sprintI.dto.request.PostRequestDTO;
import bootcamp.sprint.grupo02.sprintI.dto.request.ProductRequestDTO;
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
    private final SellerService sellerService;
    private final ProductService productService;

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

    @Override
    public MessageResponseDTO addPost(PostRequestDTO dto) {
        if(!sellerService.existSeller(dto.getUserId())){
            throw new BadRequestException("Seller doesn't exists"); //AGREGADO
        }
        Post post = parsePostDtoToModelWithOutDiscount(dto);
        productService.addProduct(dto.getProduct());
        repository.add(post);
        return new MessageResponseDTO("Ok");
    }

    @Override
    public MessageResponseDTO addPostPromo(PostPromoDTO dto) {
        if(!sellerService.existSeller(dto.getUserId())){
            throw new BadRequestException("Seller not exists");
        }
        Post post = parsePostPromoDtoToModel(dto);
        repository.add(post);
        productService.addProduct(dto.getProduct());
        return new MessageResponseDTO("The product was successfully publish");
    }

    @Override
    public PromoQuantityResponseDTO calculatePostPromoBySeller(int sellerId) {
        PromoQuantityResponseDTO postPromoResponseDTO = new PromoQuantityResponseDTO();
        Seller seller = sellerService.findById(sellerId);
        if(seller == null){
            throw new NotFoundException("Seller not found");
        }
        postPromoResponseDTO.setUserResponseDTO(new UserResponseDTO(seller.getId(), seller.getName()));
        postPromoResponseDTO.setPromoProductsCount(repository.findWithPromo(sellerId).size());
        return postPromoResponseDTO;
    }

    @Override
    public PromoListBySeller findAllPromoBySeller(int sellerId) {
        PromoListBySeller promoListBySeller = new PromoListBySeller();
        Seller seller = sellerService.findById(sellerId);
        if(seller == null){
            throw new NotFoundException("Seller not found");
        }
        promoListBySeller.setUserResponseDTO(new UserResponseDTO(seller.getId(), seller.getName()));
        promoListBySeller.setPosts(repository.findWithPromo(sellerId).stream()
                .map(this::convertToPostPromoResponseDTO).toList());
        return promoListBySeller;
    }

    @Override
    public PostPromoResponseDTO removePromo(int postId) {
        Post post = repository.removePromo(postId);
        return convertToPostPromoResponseDTO(post);
    }


    /////////////////////METODOS PRIVADOS/////////////////////
    private Post parsePostDtoToModelWithOutDiscount(PostRequestDTO dto){
        ProductRequestDTO proDto = dto.getProduct();

        Product product = new Product(proDto.getProductId(),proDto.getProductName(),proDto.getType(),proDto.getColor(),
                proDto.getNotes(),proDto.getBrand());

        Post post = new Post(repository.findAll().size() + 1,dto.getUserId(),dateFormater(dto.getDate()),dto.getCategory(),dto.getPrice(),
                product, 1,false);

        return post;
    }

    private Post parsePostPromoDtoToModel(PostPromoDTO dto){
        return new Post(repository.findAll().size() + 1,
                dto.getUserId(),
                dateFormater(dto.getDate()),
                dto.getCategory(),
                dto.getPrice(),
                productService.convertToProductRequestDTO(dto.getProduct()),
                dto.getDiscount(),dto.isHasPromo());
    }
    private LocalDate dateFormater(String str){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(str, formatter);
        return date;
    }

    private PostResponseDTO convertToPostResponseDTO(Post post){
        PostResponseDTO postResponseDTO = new PostResponseDTO();
        postResponseDTO.setCategory(post.getCategory());
        postResponseDTO.setDate(post.getDate());
        postResponseDTO.setProduct(productService.convertToProductResponseDTO(post.getProduct()));
        postResponseDTO.setPrice(post.getPrice());
        postResponseDTO.setPostId(post.getId());
        postResponseDTO.setUserId(post.getSellerId());
        return postResponseDTO;
    }

    private PostPromoResponseDTO convertToPostPromoResponseDTO(Post post){
        PostPromoResponseDTO postResponseDTO = new PostPromoResponseDTO();
        postResponseDTO.setCategory(post.getCategory());
        postResponseDTO.setDate(post.getDate());
        postResponseDTO.setProduct(productService.convertToProductResponseDTO(post.getProduct()));
        postResponseDTO.setPrice(post.getPrice());
        postResponseDTO.setPostId(post.getId());
        postResponseDTO.setUserId(post.getSellerId());
        postResponseDTO.setHasPromo(post.isHasPromo());
        postResponseDTO.setDiscount(post.getDiscount());
        return postResponseDTO;
    }
}
