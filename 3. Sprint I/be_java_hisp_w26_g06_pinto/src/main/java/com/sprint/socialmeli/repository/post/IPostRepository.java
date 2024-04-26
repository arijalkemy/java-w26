package com.sprint.socialmeli.repository.post;

import com.sprint.socialmeli.entity.Post;

import java.util.List;
import java.util.Map;

public interface IPostRepository {
    void save(Post post, Integer sellerId);
    List<Post> findBySellerId(Integer sellerId);

    // Individual
    Map<Integer,Double> getPromoPostMap();
    void saveDiscountByPostId(Integer postId, Double discount);
}
