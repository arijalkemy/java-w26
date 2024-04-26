package com.api.socialmeli.service;

import com.api.socialmeli.dto.PostWithPromoDto;
import com.api.socialmeli.dto.PostsByFollowedDto;

import com.api.socialmeli.dto.PostDto;
import com.api.socialmeli.entity.Post;
import org.springframework.http.ResponseEntity;

public interface IPostService {

    PostsByFollowedDto getPostsByFollowed(Integer userId, String order);

    PostDto publishPost(PostDto postDto);

    void postPromo(PostWithPromoDto post);
}
