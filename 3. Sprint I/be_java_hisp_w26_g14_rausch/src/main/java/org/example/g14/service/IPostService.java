package org.example.g14.service;

import org.example.g14.dto.CreatePostDto;
import org.example.g14.dto.CreatePostPromoDto;
import org.example.g14.dto.PostDto;
import org.example.g14.dto.PromoPostCountDto;

import java.util.List;

public interface IPostService {
    void add(CreatePostDto createPostDto);
    List<PostDto> getPostsFromFollowed(int userId, String order);
    void addPromopPost(CreatePostPromoDto createPostPromoDto);
    PromoPostCountDto getPostsPromoByUserId(int userId);
    List<CreatePostPromoDto> getPostsInOrder();
}
