package com.meli.be_java_hisp_w26_g09.repository;

import com.meli.be_java_hisp_w26_g09.entity.Post;

import java.util.List;
import java.util.Optional;

public interface IPostRepository {
    void createPost(Post post);

    List<Post> findAll();

    List<Post> findAllByIdUser(Integer idUser);

}
