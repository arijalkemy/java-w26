package com.javabootcamp.socialmeli.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javabootcamp.socialmeli.dto.PostDto;
import com.javabootcamp.socialmeli.dto.ProductDto;
import com.javabootcamp.socialmeli.dto.PromoBySellerDto;
import com.javabootcamp.socialmeli.dto.QuantityPostWithPromoDto;
import com.javabootcamp.socialmeli.model.Post;
import com.javabootcamp.socialmeli.model.Product;
import com.javabootcamp.socialmeli.model.User;

import java.util.List;

public class DtoMapper {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    private DtoMapper(){}

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

    public static PromoBySellerDto postAndUserToPromoBySellerDto(List<Post> postList, User user) {
        PromoBySellerDto promoBySellerDto = new PromoBySellerDto();
        promoBySellerDto.setUserName(user.getUsername());
        promoBySellerDto.setUserId(user.getId());
        promoBySellerDto.setPosts(postList);


        return promoBySellerDto;
    }

    public static QuantityPostWithPromoDto intAndUserToquantityPostWithPromoDto(int quantity, User user) {
        QuantityPostWithPromoDto quantityPostWithPromoDto = new QuantityPostWithPromoDto();
        quantityPostWithPromoDto.setUserName(user.getUsername());
        quantityPostWithPromoDto.setUserId(user.getId());
        quantityPostWithPromoDto.setPromoProductsCount(quantity);


        return quantityPostWithPromoDto;
    }
}
