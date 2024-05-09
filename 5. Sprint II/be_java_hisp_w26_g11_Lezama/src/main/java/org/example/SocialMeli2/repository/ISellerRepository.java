package org.example.SocialMeli2.repository;

import org.example.SocialMeli2.entity.Post;
import org.example.SocialMeli2.entity.Seller;

import java.util.List;
import java.util.Map;

public interface ISellerRepository {
    public Seller getSellerById(int id);
    Map<Integer, List<Post>> findPostsByFollowing(List<Integer> sellers);
    public boolean userIdToFollowSeller(int userId, int userIdToFollow);
    boolean productIdExists(int id);
    boolean postIdExist(int id);
    List<Seller> getSellersList();
    List<Seller> getCustomersThatFollowsSellersById(int userId);
}
