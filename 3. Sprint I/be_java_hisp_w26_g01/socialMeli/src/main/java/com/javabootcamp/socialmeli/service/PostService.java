package com.javabootcamp.socialmeli.service;

import com.javabootcamp.socialmeli.dto.PostDto;

import java.util.List;

public interface PostService {
    List<PostDto> findByTwoWeeksAgo(List<Integer> sellersId);
    void addPost(PostDto postDto);

    List<PostDto> findByTwoWeeksAgoOrderAsc(List<Integer> sellersId);

    List<PostDto> findByTwoWeeksAgoOrderDesc(List<Integer> sellersId);
}
