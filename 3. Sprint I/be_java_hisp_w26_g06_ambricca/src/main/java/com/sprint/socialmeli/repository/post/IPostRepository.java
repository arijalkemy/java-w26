package com.sprint.socialmeli.repository.post;

import com.sprint.socialmeli.entity.Post;
import com.sprint.socialmeli.entity.Promo;

import java.util.List;

public interface IPostRepository {
    void save(Post post, Integer sellerId);
    List<Post> findBySellerId(Integer sellerId);
    List<Promo> findPromosBySellerId(Integer sellerId);
    void savePromo(Promo promo);
    Post findBySellerIdAndPostId(Integer sellerId, Integer postId);
}
