package org.example.be_java_hisp_w26_g04.service.buyer;

import org.example.be_java_hisp_w26_g04.dto.BuyerDTO;
import org.example.be_java_hisp_w26_g04.model.Buyer;

import java.util.Optional;

public interface IBuyerService {
    void followSeller(int buyerId, int sellerId);
    BuyerDTO getFollowed(int id);
    void unfollowerSeller(int userId, int userIdToUnfollow);
    BuyerDTO sortGetFollowed(int userId, String order);
}
