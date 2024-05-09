package com.api.socialmeli.repository;

import com.api.socialmeli.entity.Buyer;
import com.api.socialmeli.entity.Seller;

import java.util.List;

public interface IBuyerRepository {
    Buyer getById(Integer id);
    List<Buyer> getAll();
    Buyer followUser(Buyer userFollowing, Seller userFollowed);
}
