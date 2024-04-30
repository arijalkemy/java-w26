package org.mercadolibre.NotNullTeam.repository.impl;

import org.mercadolibre.NotNullTeam.DTO.response.PromoProductsBySellerResponeseDTO;
import org.mercadolibre.NotNullTeam.model.Post;
import org.mercadolibre.NotNullTeam.model.PromoPost;
import org.mercadolibre.NotNullTeam.model.Seller;
import org.mercadolibre.NotNullTeam.repository.IPromoPostRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.mercadolibre.NotNullTeam.mapper.PostMapper;

@Repository
public class PromoPostRepositoryImpl implements IPromoPostRepository {
    Map<Long, List<PromoPost>> promoPosts = new HashMap<>();


    @Override
    public Long createPromoPost(PromoPost promoPost) {
        Long sellerId = promoPost.getUser_id();

        if (!promoPosts.containsKey(sellerId)) {
            promoPosts.put(sellerId, new ArrayList<>(List.of(promoPost)));
        }else{
            promoPosts.get(sellerId).add(promoPost);
        }

        return promoPost.getUser_id();
    }

    @Override
    public PromoProductsBySellerResponeseDTO getPromoProductsBySeller(Seller seller) {
        PromoProductsBySellerResponeseDTO promoProductsBySellerResponeseDTO = new PromoProductsBySellerResponeseDTO();

        promoProductsBySellerResponeseDTO.setUserId(seller.getUser().getId());
        promoProductsBySellerResponeseDTO.setUserName(seller.getUser().getName());

        List<PromoPost> posts = seller.getPromoPosts();
        promoProductsBySellerResponeseDTO.setPosts(PostMapper.promoPostToPromoPostResponseDto(posts));

        return promoProductsBySellerResponeseDTO;
    }


}
