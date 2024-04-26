package com.example.sprint1.repository;

import com.example.sprint1.model.Post;
import java.util.List;

public interface IPostRepository {
    List<Post> getResentPost(Integer userId);
    Post save(Post post);
    List<Post> findAll();
    Post findById(Integer id);
    Integer getPostInPromoCountByUserId(Integer userId);
    List<Post> getPostInPromoByUserId(Integer userId);
    List<Post> getPostsFilter(Integer category, Integer user_id, Boolean has_promo);
}
