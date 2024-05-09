package org.mercadolibre.NotNullTeam.service;

import org.mercadolibre.NotNullTeam.DTO.request.post.PostDTO;
import org.mercadolibre.NotNullTeam.DTO.response.post.PostsByFollowedDTO;

public interface IPostService {
    Long createPost(PostDTO postDTO);
    PostsByFollowedDTO getPostsByWeeksAgo(Long userId, String order);
}
