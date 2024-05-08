package com.api.socialmeli.repository;

import com.api.socialmeli.entity.Seller;

import java.util.List;

public interface ISellerRepository {
    Seller getById(Integer id);
    List<Seller> getAll();
}
