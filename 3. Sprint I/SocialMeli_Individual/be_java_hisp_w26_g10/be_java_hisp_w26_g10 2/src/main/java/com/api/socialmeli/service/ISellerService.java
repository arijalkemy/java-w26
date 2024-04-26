package com.api.socialmeli.service;

import com.api.socialmeli.dto.FollowedBySellerDto;
import com.api.socialmeli.dto.PromoProductBySellerDto;
import com.api.socialmeli.dto.SellersCountFollowersDto;

public interface ISellerService {

    FollowedBySellerDto getFollowersOfSeller(int seller_id, String order);
    SellersCountFollowersDto getCountOfSellerFollowers(Integer user_id);
    PromoProductBySellerDto getPromoProductBySeller(Integer user_id);
}
