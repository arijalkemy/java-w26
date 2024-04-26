package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.service;

import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.*;

import java.util.List;

public interface IPostService {
    ExceptionDto create(PostDTO postDto);
    ExceptionDto createWithPromotion(PromoPostDTO promoPostDTO);
    List<PromoPostDTO> getAll();
    UserPromoPostCountDTO retrieveUserPromoPostCount(Integer userId);
    UserPromoPostsDTO retrieveUserPromoPostList(Integer userId);
    List<PromoPostDTO> retrievePostWithMaxDiscount();
}
