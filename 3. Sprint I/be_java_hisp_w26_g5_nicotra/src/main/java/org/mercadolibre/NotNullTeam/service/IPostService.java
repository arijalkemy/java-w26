package org.mercadolibre.NotNullTeam.service;

import org.mercadolibre.NotNullTeam.DTO.request.PostDTO;
import org.mercadolibre.NotNullTeam.DTO.request.PostWithPromoDto;
import org.mercadolibre.NotNullTeam.DTO.response.PostCreatedDto;
import org.mercadolibre.NotNullTeam.DTO.response.PostPromoCountDto;
import org.mercadolibre.NotNullTeam.DTO.response.PostsByFollowedDTO;
import org.springframework.web.bind.annotation.PathVariable;

public interface IPostService {
    Long createPost(PostDTO postDTO);
    PostsByFollowedDTO getPostsByWeeksAgo(Long userId, String order);

    PostCreatedDto createPostWithPromo(PostWithPromoDto postDto);

    PostPromoCountDto getCountPostPromo(Long sellerId);
    PostWithPromoDto getMostDiscountBySellerId(Long sellerId);
}
