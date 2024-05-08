package com.meli.be_java_hisp_w26_g10.repository;

import com.meli.be_java_hisp_w26_g10.entity.Seller;

import java.util.List;

public interface ISellerRepository {
    Seller getById(Integer id);
    List<Seller> getAll();
}
