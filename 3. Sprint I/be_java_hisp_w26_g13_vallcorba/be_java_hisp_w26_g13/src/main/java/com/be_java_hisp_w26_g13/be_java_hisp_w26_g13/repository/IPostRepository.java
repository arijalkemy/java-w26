package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.repository;

import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.entity.Post;

import java.util.List;
import java.util.Optional;

public interface IPostRepository {

    List<Post> getAll();

    void create(Post post);
    List<Post> getPostBy(int userId);

    Optional<Post> getPostById(int postId);
}
