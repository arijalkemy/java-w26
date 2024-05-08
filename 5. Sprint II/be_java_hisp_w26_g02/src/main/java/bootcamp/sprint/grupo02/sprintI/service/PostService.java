package bootcamp.sprint.grupo02.sprintI.service;

import bootcamp.sprint.grupo02.sprintI.dto.request.PostDTO;

import bootcamp.sprint.grupo02.sprintI.dto.response.MessageResponseDTO;
import bootcamp.sprint.grupo02.sprintI.dto.response.PostListByBuyerResponseDTO;
import bootcamp.sprint.grupo02.sprintI.dto.response.PostResponseDTO;

import java.util.List;

public interface PostService {
    PostListByBuyerResponseDTO findPostsByBuyer(int id, String order);
     MessageResponseDTO createPost(PostDTO dto);
     List<PostResponseDTO> searchBySellersBetween(List<Integer> sellersIs, String order, Long period);
}
