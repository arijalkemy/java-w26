package com.meli.be_java_hisp_w26_g09.service;

import com.meli.be_java_hisp_w26_g09.dto.*;

public interface IPostService {
    ResponseDTO addPost(PostDTO post);
    ResponseDTO addPostPromo(PostDTO postPromo);

    CountPromosBySellerDTO getCountPromosBySeller(Integer idSeller);
    PromosBySellerDTO getListPromosBySeller(Integer idSeller);

    ProductFollowedListDTO findFollowedPostsLastTwoWeeks(int userID);
    ProductFollowedListDTO findFollowedPostsLastTwoWeeksSorted(int userID, String order);
}
