package com.javabootcamp.socialmeli.service;

import com.javabootcamp.socialmeli.dto.LastPostDto;
import com.javabootcamp.socialmeli.dto.PostPromoDto;
import com.javabootcamp.socialmeli.dto.PostPromoRespDto;
import com.javabootcamp.socialmeli.dto.ProductsPromoDto;
import com.javabootcamp.socialmeli.enums.OrderType;
import com.javabootcamp.socialmeli.model.Product;

public interface ProductService {
    Product addProduct(Product product);
    LastPostDto getPostFromLastTwoWeeks(Integer userId);
    PostPromoRespDto getQuantityProductsPromo(Integer userId);
    LastPostDto getPostFromLastTwooWeeksOrder(Integer userId, OrderType orderType);
    void modifyPromoPost(ProductsPromoDto productsPromoDto);
}
