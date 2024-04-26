package com.api.socialmeli.repository;

import com.api.socialmeli.entity.Post;

import java.util.List;

public interface IPostRepository {
    Post getById(int id);

    List<Post> getAll();
    Post update(Post post);
    void delete(int id);

    int searchPostId();

    void savePost(Post post);
}
