package com.meli.be_java_hisp_w26_g09.service;

import com.meli.be_java_hisp_w26_g09.dto.PostDTO;
import com.meli.be_java_hisp_w26_g09.dto.PromoProductsDTO;
import com.meli.be_java_hisp_w26_g09.dto.ResponseDTO;
import com.meli.be_java_hisp_w26_g09.dto.ProductFollowedListDTO;
import com.meli.be_java_hisp_w26_g09.entity.Post;

import java.util.List;

public interface IPostService {
    ResponseDTO addPost(PostDTO post);

    ProductFollowedListDTO findFollowedPostsLastTwoWeeks(int userID);

    ProductFollowedListDTO findFollowedPostsLastTwoWeeksSorted(int userID, String order);

    ResponseDTO createPostWithPromo(PostDTO post);

    PromoProductsDTO getPromoProducts(int userID);

    List<Post> getAllPromosForId(int userID);
}
