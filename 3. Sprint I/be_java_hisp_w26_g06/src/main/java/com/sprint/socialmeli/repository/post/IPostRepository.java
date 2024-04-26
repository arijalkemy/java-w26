package com.sprint.socialmeli.repository.post;

import com.sprint.socialmeli.entity.Post;

import java.util.List;

public interface IPostRepository {
    void save(Post post, Integer sellerId);
    List<Post> findBySellerId(Integer sellerId);
    List<Post> findPromoPostsBySellerId(Integer sellerId);
}
