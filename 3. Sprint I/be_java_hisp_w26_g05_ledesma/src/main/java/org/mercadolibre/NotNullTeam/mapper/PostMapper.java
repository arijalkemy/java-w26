package org.mercadolibre.NotNullTeam.mapper;

import org.mercadolibre.NotNullTeam.DTO.request.PostDTO;
import org.mercadolibre.NotNullTeam.DTO.request.PostWithPromoDTO;
import org.mercadolibre.NotNullTeam.DTO.request.ProductDTO;
import org.mercadolibre.NotNullTeam.DTO.response.*;
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

    public static PromosCountDTO toPromosCountDTO(Long userId, String sellerName, int cantPromos){
        return new PromosCountDTO(userId,
                sellerName,
                cantPromos
        );
    }

    public static Post postWithPromoDtoToPost(PostWithPromoDTO postWithPromoDTO, Seller seller) {
        return new Post(seller,
                LocalDate.parse(postWithPromoDTO.getDate(),
                        DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                productDtoToProduct(postWithPromoDTO.getProduct()),
                postWithPromoDTO.getCategory(),
                postWithPromoDTO.getPrice(),
                postWithPromoDTO.isHas_promo(),
                postWithPromoDTO.getDiscount()
        );
    }

    public static PostResponseWithPromoDTO postToPostWithPromoDto(Post post) {
        return new PostResponseWithPromoDTO(post.getSeller().getUser().getId(),
                post.getId(),
                post.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                productToProductDto(post.getProduct()),
                post.getCategory(),
                post.getPrice(),
                post.getHasPromo(),
                post.getDiscount());
    }

    public static PostsWithPromoDTO toPostOfWeekWithPromoDTO(Long userId, List<Post> posts){
        return new PostsWithPromoDTO(userId, posts.stream().map(PostMapper::postToPostWithPromoDto).toList());
    }
}
