package com.api.socialmeli.service;

import com.api.socialmeli.dto.PostsByFollowedDto;
import com.api.socialmeli.dto.PromoPostDto;
import com.api.socialmeli.entity.Post;

import java.util.List;

import com.api.socialmeli.dto.PostDto;

public interface IPostService {

    PostsByFollowedDto getPostsByFollowed(Integer userId, String order);

    PostDto publishPost(PostDto postDto);
    PromoPostDto publishPromoPost(PromoPostDto promoPostDto);
    
    List<Post> getAll();
}
