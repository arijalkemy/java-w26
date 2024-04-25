package org.example.g14.service;

import org.example.g14.dto.CreatePostDto;
import org.example.g14.dto.PostDto;
import org.example.g14.dto.UserWithPromoPostsCountDto;

import java.util.List;

public interface IPostService {
    void add(CreatePostDto createPostDto);
    void addWithPromo(CreatePostDto createPromoPostDto);
    UserWithPromoPostsCountDto getCountOfPromoPostsBySeller(Integer userId);
    List<PostDto> getPostsFromFollowed(int userId, String order);
}
