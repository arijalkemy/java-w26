package org.mercadolibre.NotNullTeam.mapper;

import org.mercadolibre.NotNullTeam.DTO.response.type.TypeBasicResponse;
import org.mercadolibre.NotNullTeam.model.Post;

import java.util.List;

public class TypeMapper {

    public static TypeBasicResponse toTypeBasicResponse(String type, List<Post> posts) {
        long amount = posts
                .stream()
                .filter(post -> post.getProduct().getType().equals(type))
                .count();
        return TypeBasicResponse.builder().name(type).amount(amount).build();
    }
}
