package com.api.socialmeli.repository;

import com.api.socialmeli.dto.PromoPostDto;
import com.api.socialmeli.entity.Post;

import java.util.List;

public interface IPostRepository {
    Post getById(int id);

    List<Post> getAll();
    Post update(Post post);
    void delete(int id);

    int searchPostId();

    int getCountPromoPosts(Integer user_id);

    void savePost(Post post);

    List<PromoPostDto> getAllSellerById(Integer user_id);
}
