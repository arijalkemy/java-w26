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
            createPostDto.getIdUser()
        );
    }

    public Post createPostWithPromoDtoToPost(CreatePostDto createPostWithPromoDto) {
        if(createPostWithPromoDto.getDate() == null || createPostWithPromoDto.getCategory() == 0 ||
            createPostWithPromoDto.getPrice() == 0 || createPostWithPromoDto.getIdUser() == 0) {
            throw new BadRequestException("Campos inválidos y/o faltantes.");
        }
        if(createPostWithPromoDto.getProduct() == null ||
            createPostWithPromoDto.getProduct().getId() == 0 || createPostWithPromoDto.getProduct().getName() == null ||
            createPostWithPromoDto.getProduct().getType() == null || createPostWithPromoDto.getProduct().getBrand() == null ||
            createPostWithPromoDto.getProduct().getColor() == null || createPostWithPromoDto.getProduct().getNotes() == null
        ) {
            throw new BadRequestException("Campos inválidos y/o faltantes.");
        }

        return new Post(
            createPostWithPromoDto.getDate(),
            createPostWithPromoDto.getPrice(),
            createPostWithPromoDto.getCategory(),
            new Product(
                createPostWithPromoDto.getProduct().getId(),
                createPostWithPromoDto.getProduct().getName(),
                createPostWithPromoDto.getProduct().getType(),
                createPostWithPromoDto.getProduct().getBrand(),
                createPostWithPromoDto.getProduct().getColor(),
                createPostWithPromoDto.getProduct().getNotes()
            ),
            createPostWithPromoDto.getIdUser(),
            createPostWithPromoDto.getDiscount(),
            createPostWithPromoDto.isHasPromo()
        );
    }
}
