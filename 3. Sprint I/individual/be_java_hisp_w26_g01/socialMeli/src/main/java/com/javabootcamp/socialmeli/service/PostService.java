package com.javabootcamp.socialmeli.service;

import com.javabootcamp.socialmeli.dto.PostDto;
import com.javabootcamp.socialmeli.dto.PostWithPromoDto;
import com.javabootcamp.socialmeli.dto.PromoBySellerDto;
import com.javabootcamp.socialmeli.dto.QuantityPostWithPromoDto;

import java.util.List;

public interface PostService {
    List<PostDto> findByTwoWeeksAgo(List<Integer> sellersId);
    void addPost(PostDto postDto);

    List<PostDto> findByTwoWeeksAgoOrderAsc(List<Integer> sellersId);

    List<PostDto> findByTwoWeeksAgoOrderDesc(List<Integer> sellersId);

    PromoBySellerDto findPromosBySellerId(int userId);

    void addPostWithPromo(PostWithPromoDto postWithPromo);

    QuantityPostWithPromoDto countPostWithPromoBySeller(int userId);
}
