package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.service;

import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.*;

public interface IPostService {

    ExceptionDto create(PostDTO postDto);

    PromoProductCountDTO getPromoProductCount(int userId);

    ExceptionDto setPromo(PromoPostSetDTO promoPostSetDTO);

    PostListDTO getProductPosts(int productId, String order, Boolean onlyPromo);
}
