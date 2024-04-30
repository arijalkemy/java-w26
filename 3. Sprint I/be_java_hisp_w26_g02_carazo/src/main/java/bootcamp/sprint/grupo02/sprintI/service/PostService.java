package bootcamp.sprint.grupo02.sprintI.service;

import bootcamp.sprint.grupo02.sprintI.dto.request.PostDTO;

import bootcamp.sprint.grupo02.sprintI.dto.response.*;

import java.util.List;

public interface PostService {
    List<PostResponseDTO> getAllBySellerId(int sellerId, String order);

    List<PostResponseDTO> getBySellerIdLastTwoWeeks(int sellerId, String order);

    PostListByBuyerResponseDTO findPostsByBuyer(int id, String order);

    MessageResponseDTO createPost(PostDTO dto);

    MessageResponseDTO createPostPromo(PostDTO dto);

    SellerPromoResponseDTO findSellerPromoPostCount(int id);

    SellerPromoResponseDTO findPromoPostsBySellerAndType(int id, String type);


}
