package com.javabootcamp.socialmeli.service;

import com.javabootcamp.socialmeli.dto.PostDto;
import com.javabootcamp.socialmeli.dto.PostPromoDto;
import com.javabootcamp.socialmeli.dto.SellerWithCountProductsPromoDto;

import java.util.List;

public interface PostService {
    List<PostDto> findByTwoWeeksAgo(List<Integer> sellersId);
    void addPost(PostDto postDto);

    void addPostPromo(PostPromoDto postPromoDto);

    SellerWithCountProductsPromoDto findCountProductsPromo(int idUser);

    List<PostDto> findByTwoWeeksAgoOrderAsc(List<Integer> sellersId);

    List<PostDto> findByTwoWeeksAgoOrderDesc(List<Integer> sellersId);
}
