package com.meli.be_java_hisp_w26_g10.repository;

import com.meli.be_java_hisp_w26_g10.entity.Buyer;
import com.meli.be_java_hisp_w26_g10.entity.Seller;

import java.util.List;

public interface IBuyerRepository {
    Buyer getById(Integer id);
    List<Buyer> getAll();
    Buyer followUser(Buyer userFollowing, Seller userFollowed);
}
