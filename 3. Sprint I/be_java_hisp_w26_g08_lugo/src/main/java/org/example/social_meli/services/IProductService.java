package org.example.social_meli.services;

import org.example.social_meli.dto.*;

import java.util.List;

public interface IProductService {
    List<PostDTO> getAllPosts();
    List<PromoPostDTO> getAllPromoPosts();
    PostDTO savePost(PostDTO post);
    PromoPostDTO savePromoPost(PromoPostDTO promoPost);
    PromoPostResponseDTO countPromoPostBySeller(Integer id);
    FollowListDTO getSellersPostsFollowedByUser(Integer id);
    FollowListDTO getOrderedSellersPostsFollowedByUser(Integer id, String orderBy);
    PromoPostListDTO getOrderedPromoPostsBySeller(Integer id, String orderBy);
    PromoPostListDTO getPromoPostsBySeller(Integer id);
}
