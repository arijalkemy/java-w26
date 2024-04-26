package com.api.socialmeli.service;

import com.api.socialmeli.dto.*;

import java.util.List;

public interface IPostService {

    PostsByFollowedDto getPostsByFollowed(Integer userId, String order);

    PostDto publishPost(PostDto postDto);
    PromoPostDto publishPromoPost(PromoPostDto promoPostDto);

    PromoPostBySellerDto getPromoPosts(Integer user_id);

    SellerPostsDto getPromoBySeller(Integer user_id);
}
