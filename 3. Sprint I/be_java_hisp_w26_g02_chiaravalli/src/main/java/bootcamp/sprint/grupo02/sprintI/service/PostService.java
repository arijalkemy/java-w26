package bootcamp.sprint.grupo02.sprintI.service;

import bootcamp.sprint.grupo02.sprintI.dto.request.PostDTO;

import bootcamp.sprint.grupo02.sprintI.dto.request.PromoPostDTO;
import bootcamp.sprint.grupo02.sprintI.dto.response.MessageResponseDTO;
import bootcamp.sprint.grupo02.sprintI.dto.response.PostListByBuyerResponseDTO;
import bootcamp.sprint.grupo02.sprintI.dto.response.PostResponseDTO;
import bootcamp.sprint.grupo02.sprintI.dto.response.PromoPostResponseDTO;
import bootcamp.sprint.grupo02.sprintI.model.Post;

import java.util.List;

public interface PostService {
    List<PostResponseDTO> getAllBySellerId(int sellerId, String order);
    List<PostResponseDTO> getBySellerIdLastTwoWeeks(int sellerId, String order);
    PostListByBuyerResponseDTO findPostsByBuyer(int id, String order);
    MessageResponseDTO createPost(PostDTO dto);

    MessageResponseDTO createPromoPost(PromoPostDTO dto);

    PromoPostResponseDTO countPromoPosts(int id);
}
