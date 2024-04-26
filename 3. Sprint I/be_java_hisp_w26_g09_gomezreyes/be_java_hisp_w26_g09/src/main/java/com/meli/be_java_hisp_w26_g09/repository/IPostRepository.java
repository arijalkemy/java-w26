package com.meli.be_java_hisp_w26_g09.repository;

import com.meli.be_java_hisp_w26_g09.entity.Post;

import java.util.List;

public interface IPostRepository {
    void createPost(Post post);

    List<Post> findAll();

    List<Post> findPostBySeller(Integer id);

    void updatePost(Post post);

    Post findPostById(Integer id);

    void deletePost(Integer id);
}
