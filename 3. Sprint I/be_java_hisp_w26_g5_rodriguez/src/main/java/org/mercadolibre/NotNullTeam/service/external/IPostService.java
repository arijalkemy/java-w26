package org.mercadolibre.NotNullTeam.service.external;

import org.mercadolibre.NotNullTeam.DTO.request.post.PostDTO;
import org.mercadolibre.NotNullTeam.DTO.request.post.PostPromoRequestDto;
import org.mercadolibre.NotNullTeam.DTO.response.post.PostsByFollowedDTO;
import org.mercadolibre.NotNullTeam.DTO.response.seller.SellerPromosCountResponse;
import org.mercadolibre.NotNullTeam.DTO.response.seller.SellerPromosResponse;

public interface IPostService {
    Long createPost(PostDTO postDTO);
    PostsByFollowedDTO getPostsByWeeksAgo(Long userId, String order);

    Long newProductPromo(PostPromoRequestDto request);

    SellerPromosCountResponse getCountPromosBySellerId(Long userId);

    SellerPromosResponse getPromosBySellerId(Long userId);
}
