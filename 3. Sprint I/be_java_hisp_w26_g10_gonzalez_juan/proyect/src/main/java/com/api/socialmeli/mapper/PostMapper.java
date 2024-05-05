package com.api.socialmeli.mapper;

import com.api.socialmeli.dto.PostPromoDto;
import com.api.socialmeli.dto.ProductDto;
import com.api.socialmeli.entity.Post;
import com.api.socialmeli.entity.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;

public class PostMapper {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static Post postPromoDtoToEntity(PostPromoDto dto){
        return new Post(
                0,
                LocalDate.now(),
                dto.getCategory(),
                dto.getPrice(),
                dto.getUser_id(),
                objectMapper.convertValue(dto.getProduct(), Product.class),
                dto.isHas_promo(),
                dto.getDiscount()
        );
    }

    public static PostPromoDto entityToPostPromoDto(Post post){
        return new PostPromoDto(
                post.getUser_id(),
                post.getPost_id(),
                post.getDate().toString(),
                objectMapper.convertValue(post.getProduct(), ProductDto.class),
                post.getCategory(),
                post.getPrice(),
                post.isHas_promo(),
                post.getDiscount()
        );
    }
}
