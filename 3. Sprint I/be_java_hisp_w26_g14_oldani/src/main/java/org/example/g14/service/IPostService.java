package org.example.g14.service;

import org.example.g14.dto.CreatePostDto;
import org.example.g14.dto.PostDto;
import org.example.g14.dto.ProductDto;
import org.example.g14.dto.PromotionProductCountDto;

import java.util.List;

public interface IPostService {
    void add(CreatePostDto createPostDto);
    List<PostDto> getPostsFromFollowed(int userId, String order);
    PromotionProductCountDto getPromotionalProducts(int user_id);
    List<ProductDto> getProductsFromTag(String tag);
}
