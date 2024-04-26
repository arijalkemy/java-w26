package com.sprint.socialmeli.repository.post;

import com.sprint.socialmeli.entity.Post;

import java.util.List;
import java.util.Map;

public interface IPostRepository {
    void save(Post post, Integer sellerId);
    List<Post> findBySellerId(Integer sellerId);
    List<Post> findPromoBySellerId(Integer sellerId);
    Map<Integer, Long> getTotalByPromoPost();
}
