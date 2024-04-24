package com.sprint.socialmeli.service.post;
import com.sprint.socialmeli.dto.post.FollowedProductsResponseDTO;
import com.sprint.socialmeli.dto.post.PostDTO;
import com.sprint.socialmeli.dto.post.PromoPostRequestDTO;
import com.sprint.socialmeli.dto.user.UserWithPromoPostsDTO;

public interface IPostService {

    void createPost(PostDTO post);
    FollowedProductsResponseDTO getFollowedProductsList(Integer customer_id, String order);
    void createPromoPost(PromoPostRequestDTO post);
    UserWithPromoPostsDTO getPromoPostsBySeller(Integer userId);
}
