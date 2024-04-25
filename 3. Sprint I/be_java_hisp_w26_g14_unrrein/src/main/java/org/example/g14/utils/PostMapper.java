package org.example.g14.utils;

import org.example.g14.dto.CreatePostDto;
import org.example.g14.dto.PostDto;
import org.example.g14.dto.PostWithDiscountDto;
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

    public static ProductDto mapToProductDto(Product product) {
        return new ProductDto(
            product.getId(),
            product.getName(),
            product.getType(),
            product.getBrand(),
            product.getColor(),
            product.getNotes()
        );
    }

    public static PostDto mapToPostDto(Post post) {
        return new PostDto(
            post.getIdUser(),
            post.getId(),
            post.getDate(),
            mapToProductDto(post.getProduct()),
            post.getCategory(),
            post.getPrice()
        );
    }

    public static PostWithDiscountDto mapToPostWithDiscountDto(Post post) {

        return new PostWithDiscountDto(
            post.getIdUser(),
            post.getId(),
            post.getDate(),
            mapToProductDto(post.getProduct()),
            post.getCategory(),
            post.getPrice(),
            post.getDiscount(),
            post.getPrice() * (1 - post.getDiscount())
        );
    }

}
