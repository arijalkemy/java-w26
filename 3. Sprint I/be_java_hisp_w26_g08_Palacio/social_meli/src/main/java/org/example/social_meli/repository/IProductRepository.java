package org.example.social_meli.repository;

import org.example.social_meli.model.Post;

import java.util.List;

public interface IProductRepository {
    void savePost(Post post);
    Boolean existsPost(Integer postId);
    List<Post> getAllPosts();
    Integer getPromoPostCount(Integer user_Id);
    List<Post> getPromoPostListByUser(Integer user_Id);
}
