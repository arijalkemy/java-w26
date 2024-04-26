package org.example.sprint1.repository;

import org.example.sprint1.dto.PostDTO;
import org.example.sprint1.entity.Post;
import org.example.sprint1.entity.Product;
import org.example.sprint1.entity.Seller;

import java.util.List;
import java.util.Map;

public interface ISellerRepository {
    public Seller getSellerById(int id);
    Map<Integer, List<Post>> findPostsByFollowing(List<Integer> sellers);
    public boolean userIdToFollowSeller(int userId, int userIdToFollow);
    void postNewPoroductWithPromotion(PostDTO v);
    // Seller getProductPromotionsBySeller(int sellerId);
}
