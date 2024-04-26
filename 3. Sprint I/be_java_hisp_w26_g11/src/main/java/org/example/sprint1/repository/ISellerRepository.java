package org.example.sprint1.repository;

import org.example.sprint1.entity.Post;
import org.example.sprint1.entity.Seller;

import java.util.List;
import java.util.Map;

public interface ISellerRepository {
    public Seller getSellerById(int id);
    Map<Integer, List<Post>> findPostsByFollowing(List<Integer> sellers);
    public boolean userIdToFollowSeller(int userId, int userIdToFollow);
    Seller filterSellerById(int id);
    boolean productIdExists(int id);
    boolean postIdExist(int id);
    List<Seller> getSellersList();
}
