package com.sprint.socialmeli.service.post;
import com.sprint.socialmeli.dto.post.*;

import java.util.List;

public interface IPostService {

    void createPost(PostDTO post);
    FollowedProductsResponseDTO getFollowedProductsList(Integer customer_id, String order);
    void createPromoPost(PostPromoRequestDTO postPromo); // Individual
    PostPromoCountResponseDTO getPostPromoCount(int userId); // Individual
    PostPromoListResponseDTO getPostPromoList(int userId);
}
