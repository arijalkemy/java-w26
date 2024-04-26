package org.example.sprint1.repository;

import org.example.sprint1.entity.Post;
import org.example.sprint1.entity.Seller;

import java.util.List;
import java.util.Map;

public interface ISellerRepository {
    Seller getSellerById(int id);
    Map<Integer, List<Post>> findPostsByFollowing(List<Integer> sellers);
    boolean userIdToFollowSeller(int userId, int userIdToFollow);
    boolean productIdExists(int id);
    boolean postIdExist(int id);
    List<Seller> getSellersList();
    List<Seller> getCustomersThatFollowsSellersById(int userId);
    Integer getPromoPostCount(Seller seller);
}
