package com.sprint.socialmeli.mappers;

import com.sprint.socialmeli.dto.post.PostDTO;
import com.sprint.socialmeli.dto.post.PostResponseDTO;
import com.sprint.socialmeli.dto.post.ProductDTO;
import com.sprint.socialmeli.entity.Post;
import com.sprint.socialmeli.entity.Product;
import com.sprint.socialmeli.exception.BadRequestException;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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




}
