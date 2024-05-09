package org.mercadolibre.NotNullTeam.repository;

import org.mercadolibre.NotNullTeam.model.Post;

import java.util.List;
import java.util.Map;

public interface IPostRepository {
    Long createPost(Post post);
    List<Post> getPostsByWeeksAgo(int weeks, Long sellerId);
    void setPosts(Map<Long, List<Post>> posts);
}
