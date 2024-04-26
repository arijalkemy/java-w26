package com.meli.be_java_hisp_w26_g09.service;

import com.meli.be_java_hisp_w26_g09.dto.PostDTO;
import com.meli.be_java_hisp_w26_g09.dto.ResponseDTO;
import com.meli.be_java_hisp_w26_g09.dto.ProductFollowedListDTO;
import com.meli.be_java_hisp_w26_g09.dto.SellerPromoDTO;

public interface IPostService {
    ResponseDTO addPost(PostDTO post);

    ProductFollowedListDTO findFollowedPostsLastTwoWeeks(int userID);

    ProductFollowedListDTO findFollowedPostsLastTwoWeeksSorted(int userID, String order);

    ResponseDTO addProductInPromoPost(PostDTO postDTO);

    SellerPromoDTO countProductsInPromoBySeller(Integer sellerId);

    SellerPromoDTO findProductsInPromoBySeller(Integer sellerId);

}
