package com.api.socialmeli.service;

import com.api.socialmeli.dto.FollowedBySellerDto;
import com.api.socialmeli.dto.SellersCountFollowersDto;
import com.api.socialmeli.entity.Seller;

public interface ISellerService {

    FollowedBySellerDto getFollowersOfSeller(int seller_id, String order);
    SellersCountFollowersDto getCountOfSellerFollowers(Integer user_id);
    Seller getSellerById(Integer id);

}
