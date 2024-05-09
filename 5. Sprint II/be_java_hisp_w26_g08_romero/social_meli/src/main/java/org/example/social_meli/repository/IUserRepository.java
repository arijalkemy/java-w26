package org.example.social_meli.repository;

import org.example.social_meli.model.FollowerList;
import org.example.social_meli.model.User;


public interface IUserRepository {
    Integer getClientIndex(FollowerList client);
    Integer getSellerIndex(FollowerList seller);
    User findById(Integer userId);
    FollowerList findSellerById(Integer id);
    FollowerList findClientById(Integer id);
    FollowerList findSellerByUser(User user);
    FollowerList findClientByUser(User user);
    Boolean existsById(Integer user_Id);
    Boolean existsClientById(Integer clientId);
    Boolean existsSellerById(Integer sellerId);
    void updateClients(Integer index, FollowerList client);
    void updateSellers(Integer index, FollowerList seller);
    void saveSeller(FollowerList seller);
    void saveClient(FollowerList client);
}
