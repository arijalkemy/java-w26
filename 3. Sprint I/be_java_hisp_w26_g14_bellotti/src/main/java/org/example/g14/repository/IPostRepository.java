package org.example.g14.repository;

import org.example.g14.model.Post;

import java.util.List;

public interface IPostRepository {
    Post modifyToPromo(Post post);
    List<Post> findAllByUser(int idUser);
    void save(Post post);
}
