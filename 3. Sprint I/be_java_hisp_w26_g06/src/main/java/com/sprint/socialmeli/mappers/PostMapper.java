package com.sprint.socialmeli.mappers;

import com.sprint.socialmeli.dto.post.*;
import com.sprint.socialmeli.entity.Post;
import com.sprint.socialmeli.entity.Product;
import com.sprint.socialmeli.entity.Seller;
import com.sprint.socialmeli.exception.BadRequestException;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class PostMapper {

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static Post mapToEntity(PostDTO postDTO ){
        try {
            LocalDate date = LocalDate.parse(postDTO.getDate(), formatter);
            return new Post(
                    mapProductToEntity(postDTO.getProduct()),
                    date,
                    postDTO.getCategory(),
                    postDTO.getPrice()
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

    // INDIVIDUAL
    public static Post mapPromoPostRequestToPost(PostPromoRequestDTO postPromoRequestDTO){

        Post post = new Post(
                mapProductToEntity(postPromoRequestDTO.getProduct()),
                LocalDate.parse(postPromoRequestDTO.getDate(), formatter),
                postPromoRequestDTO.getCategory(),
                postPromoRequestDTO.getPrice()
        );

        post.setHas_promo(true);
        post.setDiscount(postPromoRequestDTO.getDiscount());

        return post;
    }

    public static PostPromoDTO mapPostToPostPromoDto(Post post, int userId){
        return new PostPromoDTO(
                userId,
                post.getId(),
                post.getPostDate().format(formatter),
                mapProductToDto(post.getProduct()),
                post.getCategory(),
                post.getPrice(),
                post.isHas_promo(),
                post.getDiscount()
        );
    }

    public static PostPromoListResponseDTO createPostPromoListDto(Seller seller, List<PostPromoDTO> postPromosDto){
        return new PostPromoListResponseDTO(
                seller.getUser().getUserId(),
                seller.getUser().getUserName(),
                postPromosDto
        );
    }

    public static PostPromoCountResponseDTO createPostPromoCountDto(Seller seller, int count){
        return new PostPromoCountResponseDTO(
               seller.getUser().getUserId(), seller.getUser().getUserName(), count
        );
    }
}
