package com.meli.be_java_hisp_w26_g09.service;

import com.meli.be_java_hisp_w26_g09.dto.*;
import com.meli.be_java_hisp_w26_g09.entity.Post;

import java.util.List;

public interface IPostService {
    ResponseDTO addPost(PostDTO post);
    ProductFollowedListDTO findFollowedPostsLastTwoWeeks(int userID);
    ProductFollowedListDTO findFollowedPostsLastTwoWeeksSorted(int userID, String order);

    ResponseDTO savePromoPost(PostDTO postDTO);

    List<PostForListDTO> getAll();

    UserDTO getCountPromoPostById (Integer id);

    UserDTO getListPromoPostById (Integer id);
}
