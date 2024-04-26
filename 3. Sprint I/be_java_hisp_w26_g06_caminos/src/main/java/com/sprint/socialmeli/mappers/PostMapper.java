package com.sprint.socialmeli.mappers;

import com.sprint.socialmeli.dto.post.*;
import com.sprint.socialmeli.entity.Post;
import com.sprint.socialmeli.entity.Product;
import com.sprint.socialmeli.entity.Seller;
import com.sprint.socialmeli.exception.BadRequestException;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Phaser;

public class PostMapper {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static Post mapToEntity(PostDTO postDTO){
        try {
            LocalDate date = LocalDate.parse(postDTO.getDate(), formatter);
            if(postDTO instanceof PromoPostDTO promoPostDTO){
                return new Post(
                        mapProductToEntity(promoPostDTO.getProduct()),
                        date,
                        promoPostDTO.getCategory(),
                        promoPostDTO.getPrice(),
                        promoPostDTO.isHas_promo(),
                        promoPostDTO.getDiscount()
                );
            }
            return new Post(
                    mapProductToEntity(postDTO.getProduct()),
                    date,
                    postDTO.getCategory(),
                    postDTO.getPrice(),
                    false,
                    0.0
            );
        } catch (DateTimeException | IllegalArgumentException e) {
            throw new BadRequestException("Formato inválido " + e.getMessage());
        }
    }

    public static PostResponseDTO mapPostToPostResponseDto(Post post, Integer userId){
        return new PostResponseDTO(
                userId,
                post.getId(),
                formatter.format(post.getPostDate()),
                mapProductToDto(post.getProduct()),
                post.getCategory(),
                post.getPrice()
        );
    }

    private static Product mapProductToEntity(ProductDTO productDTO){
        return new Product(
                productDTO.getProduct_id(),
                productDTO.getProduct_name(),
                productDTO.getType(),
                productDTO.getColor(),
                productDTO.getBrand(),
                productDTO.getNotes()
        );
    }

    private static ProductDTO mapProductToDto(Product product){
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getType(),
                product.getBrand(),
                product.getColor(),
                product.getNotes()
        );
    }

    public static PostDTO mapPostToPromoPostResponseDto(Post post, Integer userId){
        return new PromoPostResponseDTO(
                userId,
                post.getId(),
                formatter.format(post.getPostDate()),
                mapProductToDto(post.getProduct()),
                post.getCategory(),
                post.getPrice(),
                post.isHasPromo(),
                post.getDiscount()
        );
    }

    public static PromoPostCountResponseDTO mapToPromoPostCountResponseDto(Seller sellerId, Integer count){
        return new PromoPostCountResponseDTO(
                sellerId.getUser().getUserId(),
                sellerId.getUser().getUserName(),
                count
        );
    }


}
