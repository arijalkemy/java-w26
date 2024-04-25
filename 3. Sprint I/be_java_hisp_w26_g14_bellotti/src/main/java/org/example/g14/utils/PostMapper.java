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
            createPostDto.getDiscount(),
            createPostDto.isHasPromo(),
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

    public PostDto createPostToPostDto(Post post){
        return new PostDto(
                post.getIdUser(),
                post.getId(),
                post.getDate(),
                new ProductDto(
                        post.getProduct().getId(),
                        post.getProduct().getName(),
                        post.getProduct().getType(),
                        post.getProduct().getBrand(),
                        post.getProduct().getColor(),
                        post.getProduct().getNotes()
                ),
                post.getCategory(),
                post.getPrice(),
                post.isHasPromo(),
                post.getDiscount()
        );
    }
}
