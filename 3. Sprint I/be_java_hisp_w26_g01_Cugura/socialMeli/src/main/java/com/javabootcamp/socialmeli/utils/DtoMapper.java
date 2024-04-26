package com.javabootcamp.socialmeli.utils;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javabootcamp.socialmeli.dto.PostDto;
import com.javabootcamp.socialmeli.dto.ProductDto;
import com.javabootcamp.socialmeli.dto.PromoPostDto;
import com.javabootcamp.socialmeli.dto.SellerWithPromoPostDto;
import com.javabootcamp.socialmeli.model.Post;
import com.javabootcamp.socialmeli.model.Product;
import com.javabootcamp.socialmeli.model.User;

public class DtoMapper {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    private DtoMapper() {
    }

    public static ProductDto productEntityToDto(Product product) {
        return MAPPER.convertValue(product, ProductDto.class);
    }

    public static PostDto postToPostDto(Post post) {
        PostDto postDto = new PostDto();
        postDto.setDate(post.getDate());
        postDto.setIdUser(post.getUser().getId());
        postDto.setProduct(productEntityToDto(post.getProduct()));
        postDto.setCategory(post.getCategory());
        postDto.setPrice(post.getPrice());
        return postDto;
    }

    public static Post convertPromoPostDto(PromoPostDto promoPostDto, User user, int id) {
        Product p = MAPPER.convertValue(promoPostDto.getProduct(), Product.class);
        return new Post(
                user,
                id,
                promoPostDto.getDate(),
                p,
                promoPostDto.getCategory(),
                promoPostDto.getPrice(),
                promoPostDto.getHasPromo(),
                promoPostDto.getDiscount());
    }

    public static SellerWithPromoPostDto convertToSellerWithPromoPostDto(List<Post> posts) {
        User user = posts.get(0).getUser();
        List<PromoPostDto> listPromoPost = posts
                .stream()
                .map(p -> {
                    ProductDto productDto = MAPPER.convertValue(p.getProduct(), ProductDto.class);
                    return new PromoPostDto(
                        user.getId(),
                        p.getDate(),
                        productDto,
                        p.getCategory(),
                        p.getPrice(),
                        p.getHasPromo(),
                        p.getDiscount());
                })
                .toList();
        return new SellerWithPromoPostDto(user.getId(), user.getUsername(),listPromoPost);
    }
}
