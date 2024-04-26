package com.sprint.socialmeli.service.post;
import com.sprint.socialmeli.dto.post.*;

import java.util.List;

public interface IPostService {

    Integer createPost(PostDTO post);
    FollowedProductsResponseDTO getFollowedProductsList(Integer customer_id, String order);
    void createPromoPost(PromoPostDTO postDTO);
    PromoPostCountResponseDTO getPromoPostCount(Integer sellerId);
    List<PromoPostCountResponseDTO> getAllPromoPostCount();
    FollowedProductsResponseDTO getPromoPost(Integer sellerId);
    List<FollowedProductsResponseDTO>  getAllPromoPost();
}
