package com.api.socialmeli.service;

import java.util.List;

import com.api.socialmeli.entity.Buyer;

import com.api.socialmeli.dto.BuyerFollowedListDTO;

public interface IBuyerService {
    public List<Buyer> getAll();
    public Buyer followUser(Integer userId, Integer userIdToFollow);
    Buyer getBuyerById(Integer id);
    //Se define el método en la interface del servicio del cliente para su debida implementación
    public BuyerFollowedListDTO GetFollowedListByUser(Integer user_id, String order);
    void unfollowUser(Integer userToFollow,Integer userToUnfollow);
}
