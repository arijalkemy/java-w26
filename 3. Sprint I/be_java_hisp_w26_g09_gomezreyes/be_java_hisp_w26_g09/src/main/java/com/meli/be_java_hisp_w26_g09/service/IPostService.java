package com.meli.be_java_hisp_w26_g09.service;

import com.meli.be_java_hisp_w26_g09.dto.PostDTO;
import com.meli.be_java_hisp_w26_g09.dto.ResponseDTO;
import com.meli.be_java_hisp_w26_g09.dto.ProductFollowedListDTO;
import com.meli.be_java_hisp_w26_g09.dto.UserDTO;

public interface IPostService {
    ResponseDTO addPost(PostDTO post);
    ResponseDTO addPromoPost(PostDTO post);
    ProductFollowedListDTO findFollowedPostsLastTwoWeeks(int userID);
    ProductFollowedListDTO findFollowedPostsLastTwoWeeksSorted(int userID, String order);
    UserDTO findPromoPostCountBySeller(Integer id);
    ResponseDTO updatePostToPromoPost(Integer idPost, PostDTO post);
    PostDTO findPostById(Integer id);
    UserDTO findPromoPostBySeller(Integer id);
    ResponseDTO updatePost(Integer id, PostDTO post);
}
