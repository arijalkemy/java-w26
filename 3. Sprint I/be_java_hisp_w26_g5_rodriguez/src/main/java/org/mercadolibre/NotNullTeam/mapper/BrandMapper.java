package org.mercadolibre.NotNullTeam.mapper;

import org.mercadolibre.NotNullTeam.DTO.response.brand.BrandBasicResponse;
import org.mercadolibre.NotNullTeam.model.Post;

import java.util.List;

public class BrandMapper {

    public static BrandBasicResponse toBrandBasicResponse(String name, List<Post> posts) {
        long amount = posts
                .stream()
                .filter(post -> post.getProduct().getBrand().equals(name))
                .count();
        return BrandBasicResponse.builder().name(name).amount(amount).build();
    }
}
