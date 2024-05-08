package bootcamp.sprint.grupo02.sprintI.service;

import bootcamp.sprint.grupo02.sprintI.model.Seller;
import bootcamp.sprint.grupo02.sprintI.dto.response.FollowersListResponseDTO;
import bootcamp.sprint.grupo02.sprintI.dto.response.SellerFollowersResponseDTO;

public interface SellerService {
    FollowersListResponseDTO getFollowersList(int id);
    FollowersListResponseDTO getFollowersList(int id, String order);
    SellerFollowersResponseDTO calculateFollowersCount(int id);

}
