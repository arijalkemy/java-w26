package com.api.socialmeli.service;

import com.api.socialmeli.dto.CompletePostDto;
import com.api.socialmeli.dto.PostsByFollowedDto;

import com.api.socialmeli.dto.PostDto;
import com.api.socialmeli.entity.Post;

import java.util.List;

public interface IPostService {

    Post getPostById(Integer id);
    PostsByFollowedDto getPostsByFollowed(Integer userId, String order);
    PostDto publishPost(PostDto postDto);
    void publishComplete(CompletePostDto postDto);
}
