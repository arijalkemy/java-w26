package com.javabootcamp.socialmeli.service;

import com.javabootcamp.socialmeli.dto.response.LastPostDto;
import com.javabootcamp.socialmeli.enums.OrderType;
import com.javabootcamp.socialmeli.model.Product;

public interface ProductService {
    Product addProduct(Product product);
    LastPostDto getPostFromLastTwoWeeks(Integer userId);

    LastPostDto getPostFromLastTwooWeeksOrder(Integer userId, OrderType orderType);

}
