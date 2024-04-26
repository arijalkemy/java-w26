package com.meli.be_java_hisp_w26_g09.repository;

import com.meli.be_java_hisp_w26_g09.dto.ResponseDTO;
import com.meli.be_java_hisp_w26_g09.entity.Post;

import java.util.List;

public interface IPostRepository {
    void createPost(Post post);

    List<Post> findAll();
    Boolean postExistById(int id);
    void deletePost(int id);
    List<Post> findBySellerAndPromoPost(int idUser);
}
