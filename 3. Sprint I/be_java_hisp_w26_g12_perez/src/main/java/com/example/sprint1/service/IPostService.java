package com.example.sprint1.service;

import com.example.sprint1.dto.PostDto;
import com.example.sprint1.dto.PostForListDto;
import com.example.sprint1.dto.PromoPostDto;
import com.example.sprint1.model.Post;
import java.util.List;

public interface IPostService {
    PostDto addPost(PostDto postDto) throws IllegalArgumentException;

    List<Post> findAll();

    Post findById(int id);

    List<PostForListDto> followedList(Integer userId, String order);

    PostDto postPromo(PostDto postDto);

    PromoPostDto quantityPromo(Integer user_id);

    List<PostForListDto> getPromoPosts(Integer user_id);

    List<PostForListDto> getPostsFilter(Integer category, Integer user_id, Boolean has_promo);
}
