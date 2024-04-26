package org.example.social_meli.services;

import org.example.social_meli.dto.FollowListDTO;
import org.example.social_meli.dto.PostDTO;
import org.example.social_meli.dto.PostsPromDTO;
import org.example.social_meli.dto.PromProductCountResponseDTO;

import java.util.List;

public interface IProductService {
    List<PostDTO> getAllPosts();
    PostDTO savePost(PostDTO post);
    FollowListDTO getSellersPostsFollowedByUser(Integer id);
    FollowListDTO getOrderedSellersPostsFollowedByUser(Integer id, String orderBy);
    PromProductCountResponseDTO getCountOfProductPromBySeller(Integer userId);
    PostsPromDTO getPostsProductPromBySellerId(Integer userId);

}
