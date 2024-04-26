package com.api.socialmeli.service;

import com.api.socialmeli.dto.*;

public interface IPostService {

    PostsByFollowedDto getPostsByFollowed(Integer userId, String order);

    PostDto publishPost(PostDto postDto);

    PromoPostDto publishPromoPost(PromoPostDto promoPostDto);

    SellerCountPromoProductsDto CountProductsInPromoByOwner(Integer userId);

    UserPromoProductsDto GetListOfDiscountedProductsByUser(Integer userId);
}
