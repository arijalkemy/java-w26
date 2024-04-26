package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.service;

import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.ExceptionDto;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.PostDTO;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.PromoPostCountDTO;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.PromoPostDTO;

import java.util.List;

public interface IPostService {

    ExceptionDto create(PostDTO postDto);

    ExceptionDto createPromo(PromoPostDTO promoPostDto);

    PromoPostCountDTO getPromoProductCount(int userId);

    List<PostDTO> getAllPromoPostsSortedByDiscountDesc();

    ExceptionDto setDiscountToPost(Integer postId, double discount);

    ExceptionDto removeDiscountToPost(Integer postId);
}
