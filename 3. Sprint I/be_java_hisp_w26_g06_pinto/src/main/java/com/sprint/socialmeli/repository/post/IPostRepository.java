package com.sprint.socialmeli.repository.post;

import com.sprint.socialmeli.entity.Post;

import java.util.List;
import java.util.Map;

public interface IPostRepository {
    void save(Post post, Integer sellerId);
    void saveDiscountByPostId(Integer postId, Double discount);
    List<Post> findBySellerId(Integer sellerId);

    Map<Integer, Double> getPromoPostMap(); // INDIVIDUAL
}
