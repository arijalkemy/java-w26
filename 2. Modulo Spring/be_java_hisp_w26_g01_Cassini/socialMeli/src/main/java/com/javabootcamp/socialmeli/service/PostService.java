package com.javabootcamp.socialmeli.service;

import com.javabootcamp.socialmeli.dto.PostDto;
import com.javabootcamp.socialmeli.dto.PostPromoDto;
import com.javabootcamp.socialmeli.dto.PostPromoRespDto;
import com.javabootcamp.socialmeli.dto.ProductsPromoDto;

import java.util.List;

public interface PostService {
    List<PostDto> findByTwoWeeksAgo(List<Integer> sellersId);
    void addPostList(List<PostDto> listPostDto);
    void addPost(PostDto postDto);
    void addPostPromo(PostPromoDto postPromoDto);
    List<PostDto> findByTwoWeeksAgoOrderAsc(List<Integer> sellersId);
    List<PostDto> findByTwoWeeksAgoOrderDesc(List<Integer> sellersId);
    PostPromoRespDto getQuantityProductsPromo(Integer sellerId);
    void modifyPromoPost(ProductsPromoDto productsPromoDto);

}
