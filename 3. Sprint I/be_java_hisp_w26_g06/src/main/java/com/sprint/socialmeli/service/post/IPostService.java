package com.sprint.socialmeli.service.post;
import com.sprint.socialmeli.dto.post.FollowedProductsResponseDTO;
import com.sprint.socialmeli.dto.post.PostDTO;

public interface IPostService {

    Integer createPost(PostDTO post);
    FollowedProductsResponseDTO getFollowedProductsList(Integer customer_id, String order);

}
