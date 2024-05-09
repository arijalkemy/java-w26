package org.example.social_meli.services;

import org.example.social_meli.dto.FollowListDTO;
import org.example.social_meli.dto.PostDTO;

import java.util.List;

public interface IProductService {
    PostDTO savePost(PostDTO post);
    List<PostDTO> getAllPosts();
    FollowListDTO getSellersPostsFollowedByUser(Integer id);
    FollowListDTO getOrderedSellersPostsFollowedByUser(Integer id, String orderBy);
}
