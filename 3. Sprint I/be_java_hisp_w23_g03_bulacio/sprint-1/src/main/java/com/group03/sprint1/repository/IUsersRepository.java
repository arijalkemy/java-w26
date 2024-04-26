package com.group03.sprint1.repository;

import com.group03.sprint1.entity.*;

import java.util.List;

import com.group03.sprint1.entity.Seller;

public interface IUsersRepository {
    List<Buyer> showBuyers();
    List<Seller> showSellers();
    Seller findSellerById(Integer userId);
    Buyer findBuyerById(Integer userId);
    void follow(Seller seller, Buyer buyer);
    void unfollow(Seller seller, Buyer buyer);
    List<Seller> findAllSellers();
    void createPublication(Publication publication);

    List<UserData> findBuyerSellersFollowedByUserId(Integer userId);
}
