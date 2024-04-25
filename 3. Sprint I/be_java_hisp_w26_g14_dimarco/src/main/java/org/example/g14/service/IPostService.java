package org.example.g14.service;

import org.example.g14.dto.CountOfPostsWithPromoResponseDto;
import org.example.g14.dto.CreatePostDto;
import org.example.g14.dto.PostDto;

import java.util.List;

public interface IPostService {
    void add(CreatePostDto createPostDto);
    void addWithPromo(CreatePostDto createPostDto);
    List<PostDto> getPostsFromFollowed(int userId, String order);
    CountOfPostsWithPromoResponseDto calculateCountOfPostsWithPromo(int user_id);
    void pausePosts(int user_id);
}
