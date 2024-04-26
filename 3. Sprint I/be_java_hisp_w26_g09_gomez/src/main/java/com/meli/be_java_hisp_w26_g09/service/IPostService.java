package com.meli.be_java_hisp_w26_g09.service;

import com.meli.be_java_hisp_w26_g09.dto.*;

import java.util.List;

public interface IPostService {
    ResponseDTO addPost(PostDTO post);
    ProductFollowedListDTO findFollowedPostsLastTwoWeeks(int userID);
    ProductFollowedListDTO findFollowedPostsLastTwoWeeksSorted(int userID, String order);
    ResponseDTO addPostWithDiscount(PostDTO postDTO);
    PostPromoDTO getAllPostsBySeller(Integer sellerId);
    PromoCountDTO getPromoCountBySeller(Integer sellerId);
    PostPromoDTO getAllPromoPostsBySeller(Integer sellerId);
    List<PostDTO> getAllPostByCategory(Integer categoryId);
    List<PostDTO> getAllPostByPriceRange(Double minPrice, Double maxPrice);
    List<PostDTO> getAllPostsByProductBrand(String brand);
    List<PostDTO> getAllPostByProductName(String name);
    List<PostDTO> getAllPostByProductTypeAndColor(String type, String color);
}
