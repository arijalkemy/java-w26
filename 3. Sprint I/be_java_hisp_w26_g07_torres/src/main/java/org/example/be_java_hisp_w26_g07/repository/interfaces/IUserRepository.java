package org.example.be_java_hisp_w26_g07.repository.interfaces;

import org.example.be_java_hisp_w26_g07.dto.SuccessResponseDto;
import org.example.be_java_hisp_w26_g07.entity.Category;
import org.example.be_java_hisp_w26_g07.entity.Post;
import org.example.be_java_hisp_w26_g07.entity.Product;
import org.example.be_java_hisp_w26_g07.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IUserRepository {
    User findById(Integer id);

    public Boolean addFollowerById(Integer id, Integer sellerId);

    List<Integer> followerIdBySellerId(Integer sellerId);
    List<Integer> followedIdByUserId(Integer userId);

    public void addPost(Post newPost);

    Boolean userFollowSeller(Integer id, Integer userToFollow);

    boolean unfollow(User user, User sellerUser);

    List<Post> findProductByFollow(User user);

    Product findProductById(Integer productId);

    void createProduct(Product newProduct);
    List<Post> getPromoPostsBySellerId(Integer userId);
    List<Post> getPostsBySellerId(Integer userId);

    Category getCategoryById(Integer categoryId);
}
