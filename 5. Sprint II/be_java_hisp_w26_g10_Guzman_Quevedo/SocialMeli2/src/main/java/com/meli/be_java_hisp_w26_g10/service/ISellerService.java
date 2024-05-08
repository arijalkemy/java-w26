package com.meli.be_java_hisp_w26_g10.service;

import com.meli.be_java_hisp_w26_g10.dto.FollowedBySellerDto;
import com.meli.be_java_hisp_w26_g10.dto.SellersCountFollowersDto;
import com.meli.be_java_hisp_w26_g10.entity.Seller;

public interface ISellerService {

    FollowedBySellerDto getFollowersOfSeller(int seller_id, String order);
    SellersCountFollowersDto getCountOfSellerFollowers(Integer user_id);
    Seller getSellerById(Integer id);

}
