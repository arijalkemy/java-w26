package org.mercadolibre.NotNullTeam.repository;

import org.mercadolibre.NotNullTeam.model.Post;

import java.util.Arrays;
import java.util.List;

public interface IPostRepository {
    Long createPost(Post post);
    List<Post> getPostsByWeeksAgo(int weeks, Long sellerId);
    List<Post> getPostsWithPromoByUserId(Long userId);
}
