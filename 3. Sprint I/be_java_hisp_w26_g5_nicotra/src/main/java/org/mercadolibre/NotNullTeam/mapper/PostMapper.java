package org.mercadolibre.NotNullTeam.mapper;

import org.mercadolibre.NotNullTeam.DTO.request.PostDTO;
import org.mercadolibre.NotNullTeam.DTO.request.ProductDTO;
import org.mercadolibre.NotNullTeam.DTO.response.PostResponseDTO;
import org.mercadolibre.NotNullTeam.DTO.response.PostsByFollowedDTO;
import org.mercadolibre.NotNullTeam.model.Post;
import org.mercadolibre.NotNullTeam.model.Product;
import org.mercadolibre.NotNullTeam.model.Seller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class PostMapper {

    public static PostsByFollowedDTO postToPostByFollowed(Long id, List<Post> posts){
        return new PostsByFollowedDTO(id, posts.stream()
                .map(PostMapper::postToPostResponseDto)
                .toList());
    }

    public static PostResponseDTO postToPostResponseDto(Post post) {
        return new PostResponseDTO(post.getSeller().getUser().getId(),
                post.getId(),
                post.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                productToProductDto(post.getProduct()),
                post.getCategory(),
                post.getPrice());
    }

    public static ProductDTO productToProductDto(Product product) {
        return new ProductDTO(product.getId(),
                product.getName(),
                product.getType(),
                product.getBrand(),
                product.getColor(),
                product.getNotes());
    }

    public static Post postDtoToPost(PostDTO postDTO, Seller seller) {
        return new Post(seller,
                LocalDate.parse(postDTO.getDate(),
                        DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                productDtoToProduct(postDTO.getProduct()),
                postDTO.getCategory(),
                postDTO.getPrice());
    }

    public static Product productDtoToProduct(ProductDTO productDTO) {
        return new Product(productDTO.getProduct_id(),
                productDTO.getProduct_name(),
                productDTO.getType(),
                productDTO.getBrand(),
                productDTO.getColor(),
                productDTO.getNotes());
    }
}
