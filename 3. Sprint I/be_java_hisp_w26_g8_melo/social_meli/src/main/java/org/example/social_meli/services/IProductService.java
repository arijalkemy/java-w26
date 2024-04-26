package org.example.social_meli.services;

import org.example.social_meli.dto.*;

import java.util.List;

public interface IProductService {
    List<PostDTO> getAllPosts();
    PostDTO savePost(PostDTO post);
    FollowedPostListDTO getSellersPostsFollowedByUser(Integer id);
    FollowedPostListDTO getOrderedSellersPostsFollowedByUser(Integer id, String orderBy);
    PromoPostDTO savePromoPost(PromoPostDTO post);
    UserCountPromoPostDTO getPromoPostCountByUser(Integer id);
    FollowedPromoPostDTO getFollowedPromoPostByUser(Integer userId);
    UserPromoPostListDTO getPromoPostByUser(Integer userId);
}
