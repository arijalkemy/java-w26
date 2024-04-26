package bootcamp.sprint.grupo02.sprintI.service.implementations;

import bootcamp.sprint.grupo02.sprintI.dto.request.ProductDTO;
import bootcamp.sprint.grupo02.sprintI.dto.response.*;
import bootcamp.sprint.grupo02.sprintI.exception.NotFoundException;
import bootcamp.sprint.grupo02.sprintI.model.Post;
import bootcamp.sprint.grupo02.sprintI.model.Seller;
import bootcamp.sprint.grupo02.sprintI.enums.AlfabeticOrder;

import bootcamp.sprint.grupo02.sprintI.repository.PostRepository;
import org.springframework.stereotype.Service;

import bootcamp.sprint.grupo02.sprintI.repository.SellerRepository;
import bootcamp.sprint.grupo02.sprintI.service.SellerService;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SellerServiceImpl implements SellerService {
    
    private final SellerRepository repository;
    private final PostRepository postRepository;


    @Override
    public Seller findById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Seller not found: " + id));
    }

    @Override
    public List<PostPromoResponseDTO> getPromoPostOfASeller(int id) {
        Optional<Seller> sellerOptional = repository.findById(id);
        if(sellerOptional.isPresent()){
            List<Post> promoPostList = postRepository.getListOfPromoPostByUserId(id);
            return promoPostList.stream()
                    .map(this::parsePostModelToDto)
                    .toList();
        }
        else {
            throw new NotFoundException("Seller not found: " + id);
        }
    }

    @Override
    public FollowersListResponseDTO getFollowersList(int id) {
        Optional<Seller> result = repository.findById(id);

        if (result.isEmpty()) throw new NotFoundException(
                "No se encontró un vendedor con Id: " + id
        );

        List<UserResponseDTO> userResponseDTOList = result.get().getFollowers()
                .stream()
                .map(follower -> new UserResponseDTO(follower.getId(), follower.getName()))
                .collect(Collectors.toList());

        return new FollowersListResponseDTO(
                new UserResponseDTO(result.get().getId(), result.get().getName()),
                userResponseDTOList
        );
    }

    @Override
    public SellerFollowersResponseDTO calculateFollowersCount(int id) {
        return this.repository.findById(id)
                .map(this::toResponseSellerDTO)
                .orElseThrow(() -> new NotFoundException("No seller was found for ID: " + id));
    }

    @Override
    public ProductPromoAmountBySellerDTO getProductInPromoAmount(int id) {
     Seller seller = repository.findById(id).orElseThrow(() -> new NotFoundException("Seller not found"));
     int amountOfProductWithPromo = postRepository.getListOfPromoPostByUserId(id).size();
     return new ProductPromoAmountBySellerDTO(id,seller.getName(), amountOfProductWithPromo);
    }

    private SellerFollowersResponseDTO toResponseSellerDTO(Seller seller) {
        SellerFollowersResponseDTO responseDTO = new SellerFollowersResponseDTO(
                new UserResponseDTO(seller.getId(), seller.getName()),
                seller.getFollowers().size()
        );

        return responseDTO;

    }

  @Override
  public FollowersListResponseDTO getFollowersList(int id, String order) {
        FollowersListResponseDTO result = getFollowersList(id);
        this.orderResult(result.getFollowers(), order);
        return result;

  }
  ////////////////////////PRIVATE METHODS////////////////////////

  private void orderResult(List<UserResponseDTO> toOrder, String order){
        Comparator<UserResponseDTO> comparator = Comparator.comparing(UserResponseDTO::getUserName);
        if(order.equalsIgnoreCase(AlfabeticOrder.NAME_DESC.toString())) {
               comparator = comparator.reversed();
        }
        toOrder.sort(comparator);
  }

  private PostPromoResponseDTO parsePostModelToDto(Post post){
      ProductDTO productDTO = new ProductDTO(post.getProduct().getId(),post.getProduct().getName(),
              post.getProduct().getBrand(),post.getProduct().getType(),post.getProduct().getColor(),post.getProduct().getNotes());
      return new PostPromoResponseDTO(post.getSellerId(),post.getDate(),productDTO
              ,post.getCategory(),post.getPrice(),post.isHasPromo(),post.getDiscount());
  }
}
