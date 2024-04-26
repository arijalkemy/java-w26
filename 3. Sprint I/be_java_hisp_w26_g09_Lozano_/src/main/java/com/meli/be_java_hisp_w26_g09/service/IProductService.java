package com.meli.be_java_hisp_w26_g09.service;

import com.meli.be_java_hisp_w26_g09.dto.PostDTO;
import com.meli.be_java_hisp_w26_g09.dto.PostSellerPromoPostDTO;
import com.meli.be_java_hisp_w26_g09.dto.ResponseDTO;
import com.meli.be_java_hisp_w26_g09.dto.ProductFollowedListDTO;
import com.meli.be_java_hisp_w26_g09.entity.Post;

import java.util.List;

public interface IProductService {
    ResponseDTO createPost(PostDTO post);
    ResponseDTO addNotPromoPost(PostDTO post);
    ResponseDTO addPromoPost(PostDTO post);
    ProductFollowedListDTO findFollowedPostsLastTwoWeeks(int userID);
    ProductFollowedListDTO findFollowedPostsLastTwoWeeksSorted(int userID, String order);
    PostSellerPromoPostDTO findPromoPostBySeller(int userId);
    List<PostDTO> findAllPost();
    ResponseDTO deletePost(Integer id);
}
