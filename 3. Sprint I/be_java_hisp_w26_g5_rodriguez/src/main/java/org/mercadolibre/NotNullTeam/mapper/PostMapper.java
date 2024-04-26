package org.mercadolibre.NotNullTeam.mapper;

import org.mercadolibre.NotNullTeam.DTO.request.post.PostDTO;
import org.mercadolibre.NotNullTeam.DTO.request.post.PostPromoRequestDto;
import org.mercadolibre.NotNullTeam.DTO.response.post.PostPromoResponse;
import org.mercadolibre.NotNullTeam.DTO.response.post.PostResponseDTO;
import org.mercadolibre.NotNullTeam.DTO.response.post.PostsByFollowedDTO;
import org.mercadolibre.NotNullTeam.model.Post;
import org.mercadolibre.NotNullTeam.model.Product;
import org.mercadolibre.NotNullTeam.model.Seller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class PostMapper {

    public static PostsByFollowedDTO postToPostByFollowed(Long id, List<Post> posts) {
        return new PostsByFollowedDTO(id,
                posts.stream().map(PostMapper::postToPostResponseDto).toList());
    }

    public static PostResponseDTO postToPostResponseDto(Post post) {
        return new PostResponseDTO(post.getSeller().getUser().getId(),
                post.getId(),
                post.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                ProductMapper.productToProductDto(post.getProduct()),
                post.getCategory(),
                post.getPrice());
    }

    public static Post postDtoToPost(PostDTO postDTO, Seller seller) {
        return new Post(seller,
                LocalDate.parse(postDTO.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                ProductMapper.productDtoToProduct(postDTO.getProduct()),
                postDTO.getCategory(),
                postDTO.getPrice());
    }

    public static PostPromoResponse toPostPromoResponse(Post post) {
        return new PostPromoResponse(post.getSeller().getUser().getId(),
                post.getId(),
                post.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                ProductMapper.productToProductDto(post.getProduct()),
                post.getCategory(),
                post.getPrice(),
                post.getHasPromo(),
                post.getDiscount());
    }

    public static Post postPromoRequestToPost(PostPromoRequestDto request, Seller seller,
                                              Product product) {
        return new Post(seller,
                LocalDate.parse(request.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                product,
                request.getCategory(),
                request.getPrice(),
                request.isHas_promo(),
                request.getDiscount());
    }

}
