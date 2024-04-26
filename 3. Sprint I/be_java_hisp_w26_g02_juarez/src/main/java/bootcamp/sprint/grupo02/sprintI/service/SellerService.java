package bootcamp.sprint.grupo02.sprintI.service;

import bootcamp.sprint.grupo02.sprintI.dto.response.PostPromoResponseDTO;
import bootcamp.sprint.grupo02.sprintI.dto.response.ProductPromoAmountBySellerDTO;
import bootcamp.sprint.grupo02.sprintI.model.Seller;
import bootcamp.sprint.grupo02.sprintI.dto.response.FollowersListResponseDTO;
import bootcamp.sprint.grupo02.sprintI.dto.response.SellerFollowersResponseDTO;

import java.util.List;

public interface SellerService {
    FollowersListResponseDTO getFollowersList(int id);
    FollowersListResponseDTO getFollowersList(int id, String order);
    SellerFollowersResponseDTO calculateFollowersCount(int id);
    ProductPromoAmountBySellerDTO getProductInPromoAmount(int id);
    Seller findById(int userIdToFollow);
    List<PostPromoResponseDTO> getPromoPostOfASeller(int id);
}
