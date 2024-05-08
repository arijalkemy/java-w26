package com.meli.be_java_hisp_w26_g10.repository;

import com.meli.be_java_hisp_w26_g10.entity.Post;

import java.util.List;

public interface IPostRepository {
    Post getById(int id);

    List<Post> getAll();

    int searchPostId();

    void savePost(Post post);
}
