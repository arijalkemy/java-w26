package bootcamp.sprint.grupo02.sprintI.service;

import bootcamp.sprint.grupo02.sprintI.dto.response.FollowedListResponseDTO;

import bootcamp.sprint.grupo02.sprintI.model.Seller;

import java.util.List;

public interface BuyerService {
    void followUser(int userId, int userIdToFollow);

    FollowedListResponseDTO searchBuyerFollows(int buyerId);
    FollowedListResponseDTO searchBuyerFollows(int buyerId, String order);


    List<Seller> getAllSellers(int buyerId);

    void UnfollowUser(int userId, int userIdToFollow);
}
