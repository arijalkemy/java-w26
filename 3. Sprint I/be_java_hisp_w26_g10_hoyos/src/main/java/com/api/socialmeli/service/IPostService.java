package com.api.socialmeli.service;

import com.api.socialmeli.dto.PostsByFollowedDto;

import com.api.socialmeli.dto.PostDto;
import com.api.socialmeli.dto.PromoPostDto;

import java.util.List;

public interface IPostService {

    PostsByFollowedDto getPostsByFollowed(Integer userId, String order);

    PostDto publishPost(PostDto postDto);

    PromoPostDto publishPromoPost(PromoPostDto promoPostDto);

    Integer CountProductsInPromoByOwner(Integer userId);

    List<PromoPostDto> ProductsWithDiscountByOwner(Integer userId);
}
