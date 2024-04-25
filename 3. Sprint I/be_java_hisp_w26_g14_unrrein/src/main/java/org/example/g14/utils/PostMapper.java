package org.example.g14.utils;

import org.example.g14.dto.CreatePostDto;
import org.example.g14.dto.PostDto;
import org.example.g14.dto.ProductDto;
import org.example.g14.model.Post;
import org.example.g14.model.Product;


public class PostMapper {

    public static Post mapToEntity(CreatePostDto createPostDto) {

        return new Post(
            createPostDto.getDate(),
            createPostDto.getPrice(),
            createPostDto.getCategory(),
            new Product(
                createPostDto.getProduct().getId(),
                createPostDto.getProduct().getName(),
                createPostDto.getProduct().getType(),
                createPostDto.getProduct().getBrand(),
                createPostDto.getProduct().getColor(),
                createPostDto.getProduct().getNotes()
            ),
            createPostDto.getIdUser(),
            createPostDto.getHasPromo() != null ? createPostDto.getHasPromo() : false,
            createPostDto.getDiscount() != null ? createPostDto.getDiscount() : 0
        );
    }

    public static PostDto mapToDto(Post entity) {

        ProductDto productDto = new ProductDto(
            entity.getProduct().getId(),
            entity.getProduct().getName(),
            entity.getProduct().getType(),
            entity.getProduct().getBrand(),
            entity.getProduct().getColor(),
            entity.getProduct().getNotes()
        );

        return new PostDto(
            entity.getIdUser(),
            entity.getId(),
            entity.getDate(),
            productDto,
            entity.getCategory(),
            entity.getPrice()
        );
    }
}
