package com.api.socialmeli.service;

import com.api.socialmeli.dto.*;
import com.api.socialmeli.entity.Seller;

import java.util.List;

public interface ISellerService {

    FollowedBySellerDto getFollowersOfSeller(int seller_id, String order);
    SellersCountFollowersDto getCountOfSellerFollowers(Integer user_id);
    Seller getSellerById(Integer id);
    List<CompletePostDto> getPost(Integer userId);
    UserDiscountProducts getDiscountProductsBySeller(Integer userId);
    UserDiscountProductsCount getCountDiscountProductsBySeller(Integer userId);
}
