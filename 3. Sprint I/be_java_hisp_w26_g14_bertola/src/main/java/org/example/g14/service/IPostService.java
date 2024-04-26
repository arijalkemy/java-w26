package org.example.g14.service;

import org.example.g14.dto.*;

import java.util.List;

public interface IPostService {
    void add(CreatePostDto createPostDto);
    List<PostDto> getPostsFromFollowed(int userId, String order);
    void addPromoPost(CreatePostDto promoPostDto);
    int getPromoProdCountByUserId(int userId);
    CartPriceDto getCartTotalPrice(List<Integer> cart);
}
