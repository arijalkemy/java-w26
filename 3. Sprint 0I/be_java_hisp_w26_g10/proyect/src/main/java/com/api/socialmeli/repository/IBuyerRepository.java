package com.api.socialmeli.repository;

import com.api.socialmeli.entity.Buyer;
import com.api.socialmeli.entity.Seller;

import java.util.List;

public interface IBuyerRepository {
    Buyer save();
    Buyer getById(Integer id);
    List<Buyer> getAll();
    Buyer update(Buyer buyer);
    void delete(Integer id);
    Buyer followUser(Buyer userFollowing, Seller userFollowed);
}
