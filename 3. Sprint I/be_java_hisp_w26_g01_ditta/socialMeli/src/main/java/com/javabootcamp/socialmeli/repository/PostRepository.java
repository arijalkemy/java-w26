package com.javabootcamp.socialmeli.repository;

import java.util.List;

import com.javabootcamp.socialmeli.model.Post;
import com.javabootcamp.socialmeli.model.User;

public interface PostRepository {
    void add(Post post);
    List<Post> findByTwoWeeksAgo(List<Integer> sellersId);
    List<Post> findByTwoWeeksAgoOrderAsc(List<Integer> sellersId);
    List<Post> findByTwoWeeksAgoOrderDesc(List<Integer> sellersId);
    Long countPromoPostBySeller(User user);
}
