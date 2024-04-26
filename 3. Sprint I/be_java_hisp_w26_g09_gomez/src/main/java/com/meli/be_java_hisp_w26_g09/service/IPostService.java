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

}
