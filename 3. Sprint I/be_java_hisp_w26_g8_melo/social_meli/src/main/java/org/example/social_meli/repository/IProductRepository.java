package org.example.social_meli.repository;

import org.example.social_meli.model.Post;

import java.util.List;

public interface IProductRepository {
    Post savePost(Post post);
    Boolean existsPost(Integer postId);
    List<Post> getAllPosts();
    List<Post> findAllPostsByUserId(Integer userId);
    List<Post> findAllPromoPost();
}
