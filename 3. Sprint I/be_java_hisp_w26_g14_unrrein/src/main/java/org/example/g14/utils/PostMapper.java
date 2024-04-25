package org.example.g14.utils;

import lombok.NoArgsConstructor;
import org.example.g14.dto.CreatePostDto;
import org.example.g14.dto.PostDto;
import org.example.g14.dto.ProductDto;
import org.example.g14.exception.BadRequestException;
import org.example.g14.model.Post;
import org.example.g14.model.Product;

@NoArgsConstructor
public class PostMapper {

    public static Post createPostDtoToPost(CreatePostDto createPostDto) {

        if (!Validation.isValid(createPostDto))
            throw new BadRequestException("Campos inválidos y/o faltantes.");

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
            createPostDto.getIdUser()
        );
    }

    public static PostDto toDto(Post entity) {

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
