package org.mercadolibre.NotNullTeam.repository;

import org.mercadolibre.NotNullTeam.model.Post;

import java.util.List;

public interface IPostRepository {
    Long createPost(Post post);
    List<Post> getPostsByWeeksAgo(int weeks, Long sellerId);
    List<Post> getPostsBySellerId(Long sellerId);
    List<Post> getPostsPromoBySellerId(Long sellerId);
    List<Post> getAll();
}
