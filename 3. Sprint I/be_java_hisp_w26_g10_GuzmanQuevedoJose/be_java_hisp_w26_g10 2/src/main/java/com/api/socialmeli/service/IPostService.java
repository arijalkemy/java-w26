package com.api.socialmeli.service;

import com.api.socialmeli.dto.*;

import com.api.socialmeli.entity.Post;

public interface IPostService {

    Post getPostById(Integer id);
    PostsByFollowedDto getPostsByFollowed(Integer userId, String order);

    PostDto publishPost(PostDto postDto);

    PostPromoDTO publishPromoPost(PostPromoDTO postPromoDTO);
    SellersCountProductsPromoDTO SellersCountProductsPromo(Integer id_user);
    SellerProductsPromoDTO GetSellersProductsPromo(Integer userId);
}
