package org.mercadolibre.NotNullTeam.repository;

import org.mercadolibre.NotNullTeam.model.Post;

import java.util.List;

public interface IPostRepository {
    void createPost(Post post);
    List<Post> getPostsBySellerIdTwoWeeksAgo(Long sellerId);
}
