package com.javabootcamp.socialmeli.service;

import com.javabootcamp.socialmeli.dto.PostDto;
import com.javabootcamp.socialmeli.dto.PromoPostCountDto;
import com.javabootcamp.socialmeli.dto.PromoPostDto;

import java.util.List;

public interface PostService {
    List<PostDto> findByTwoWeeksAgo(List<Integer> sellersId);
    void addPost(PostDto postDto);

    void addPromoPost(PromoPostDto promoPostDto);

    List<PostDto> findByTwoWeeksAgoOrderAsc(List<Integer> sellersId);

    List<PostDto> findByTwoWeeksAgoOrderDesc(List<Integer> sellersId);

    PromoPostCountDto countPromoPostBySeller(Integer sellerId);
}
