package org.mercadolibre.NotNullTeam.repository;

import org.mercadolibre.NotNullTeam.model.Post;

import java.util.Collection;
import java.util.List;

public interface IPostRepository {
    Long createPost(Post post);
    List<Post> getPostsByWeeksAgo(int WEEKS, Long sellerId);
    int getCantPromosSellersByUserId(Long userId);
    List<Post> getTopWeekPromosByUserId(Long sellerId, int LIMIT, int WEEKS);
    List<Post> getPostBySellerId(Long sellerId, int category);
    void deletePostById(Long sellerId, Long postId);
    List<Post> getPostsByProductName(Long id, String productName);
}
