package org.example.g14.service;

import org.example.g14.dto.CreatePostDto;
import org.example.g14.dto.PostDto;
import org.example.g14.dto.PromoPostDto;

import java.util.List;

public interface IPostService {
    void add(CreatePostDto createPostDto);
    List<PostDto> getPostsFromFollowed(int userId, String order);
    void addPromoPost(CreatePostDto promoPostDto);
    int getPromoProdCountByUserId(int userId);
}
