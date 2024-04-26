package com.javabootcamp.socialmeli.service;

import com.javabootcamp.socialmeli.dto.PostDto;
import com.javabootcamp.socialmeli.dto.ProductsPromoDto;
import com.javabootcamp.socialmeli.dto.PromoRequestDto;

import java.util.List;

public interface PostService {
    List<PostDto> findByTwoWeeksAgo(List<Integer> sellersId);

    void addPost(PostDto postDto);

    void addPromo(PromoRequestDto promoDto);

    List<PostDto> findByTwoWeeksAgoOrderAsc(List<Integer> sellersId);

    List<PostDto> findByTwoWeeksAgoOrderDesc(List<Integer> sellersId);
    ProductsPromoDto countPromoByIdUSer(Integer idUser);

}
