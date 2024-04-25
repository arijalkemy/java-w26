package org.example.g14.utils;

import lombok.NoArgsConstructor;
import org.example.g14.dto.CreatePostDto;
import org.example.g14.exception.BadRequestException;
import org.example.g14.model.Post;
import org.example.g14.model.Product;

@NoArgsConstructor
public class PostMapper {
    public Post createPostDtoToPost(CreatePostDto createPostDto) {
        if(createPostDto.getDate() == null || createPostDto.getCategory() == 0 ||
            createPostDto.getPrice() == 0 || createPostDto.getIdUser() == 0) {
            throw new BadRequestException("Campos inválidos y/o faltantes.");
        }
        if(createPostDto.getProduct() == null ||
            createPostDto.getProduct().getId() == 0 || createPostDto.getProduct().getName() == null ||
            createPostDto.getProduct().getType() == null || createPostDto.getProduct().getBrand() == null ||
            createPostDto.getProduct().getColor() == null || createPostDto.getProduct().getNotes() == null
        ) {
            throw new BadRequestException("Campos inválidos y/o faltantes.");
        }

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
            createPostDto.isHasPromo(),
            createPostDto.getDiscount()
        );
    }
}
