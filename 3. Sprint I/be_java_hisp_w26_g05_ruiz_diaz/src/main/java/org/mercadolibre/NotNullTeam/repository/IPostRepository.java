package org.mercadolibre.NotNullTeam.repository;

import org.mercadolibre.NotNullTeam.model.Post;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public interface IPostRepository {
    Long createPost(Post post);
    List<Post> getPostsByWeeksAgo(int weeks, Long sellerId);
    List<Post> getPostsWithPromoByUserId(Long userId);
    Optional<Post> findPostByPostId(Long postId);
}
