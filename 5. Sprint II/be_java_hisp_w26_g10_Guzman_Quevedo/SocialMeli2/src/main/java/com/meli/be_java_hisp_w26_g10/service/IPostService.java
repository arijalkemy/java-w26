package com.meli.be_java_hisp_w26_g10.service;

import com.meli.be_java_hisp_w26_g10.dto.PostsByFollowedDto;

import com.meli.be_java_hisp_w26_g10.dto.PostDto;
import com.meli.be_java_hisp_w26_g10.entity.Post;

public interface IPostService {

    Post getPostById(Integer id);
    PostsByFollowedDto getPostsByFollowed(Integer userId, String order);

    PostDto publishPost(PostDto postDto);
}
