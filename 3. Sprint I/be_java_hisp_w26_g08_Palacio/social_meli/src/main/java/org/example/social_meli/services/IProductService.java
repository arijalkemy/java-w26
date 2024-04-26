package org.example.social_meli.services;

import org.example.social_meli.dto.FollowListDTO;
import org.example.social_meli.dto.PostDTO;
import org.example.social_meli.dto.PromoListDTO;
import org.example.social_meli.dto.PromoProductsDTO;

import java.util.List;

public interface IProductService {
    List<PostDTO> getAllPosts();
    PostDTO savePost(PostDTO post);
    FollowListDTO getSellersPostsFollowedByUser(Integer id);
    FollowListDTO getOrderedSellersPostsFollowedByUser(Integer id, String orderBy);
    PromoProductsDTO getPromoPostCount(Integer user_Id);
    PromoListDTO getPromoPostList(Integer user_Id);
}
