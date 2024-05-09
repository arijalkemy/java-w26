package com.api.socialmeli.repository;

import com.api.socialmeli.entity.Post;

import java.util.List;

public interface IPostRepository {
    Post getById(int id);

    List<Post> getAll();

    int searchPostId();

    void savePost(Post post);
}
