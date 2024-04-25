package bootcamp.sprint.grupo02.sprintI.service;

import bootcamp.sprint.grupo02.sprintI.dto.request.PostPromoDTO;
import bootcamp.sprint.grupo02.sprintI.dto.request.PostRequestDTO;

import bootcamp.sprint.grupo02.sprintI.dto.response.*;

import java.util.List;

public interface PostService {
    List<PostResponseDTO> getAllBySellerId(int sellerId, String order);
    List<PostResponseDTO> getBySellerIdLastTwoWeeks(int sellerId, String order);
    PostListByBuyerResponseDTO findPostsByBuyer(int id, String order);
    MessageResponseDTO addPost(PostRequestDTO dto);
    MessageResponseDTO addPostPromo(PostPromoDTO dto);
    PromoQuantityResponseDTO calculatePostPromoBySeller(int sellerId);
    PromoListBySeller findAllPromoBySeller(int sellerId);
}
