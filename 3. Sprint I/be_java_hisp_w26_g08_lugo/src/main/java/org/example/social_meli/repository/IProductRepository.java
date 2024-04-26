package org.example.social_meli.repository;

import org.example.social_meli.model.Post;
import org.example.social_meli.model.PromoPost;

import java.util.List;

public interface IProductRepository {
    void savePost(Post post);
    void savePromoPost(PromoPost promoPost);
    Boolean existsPost(Integer postId);
    List<Post> getAllPosts();
    List<PromoPost> getAllPromoPosts();
}
