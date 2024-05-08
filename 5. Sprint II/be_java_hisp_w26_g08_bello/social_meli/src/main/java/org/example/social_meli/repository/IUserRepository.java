package org.example.social_meli.repository;

import org.example.social_meli.model.FollowerList;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.social_meli.model.FollowerList;
import org.example.social_meli.model.FollowerList;
import org.example.social_meli.model.FollowerList;
import org.example.social_meli.model.User;
import org.springframework.util.ResourceUtils;

import java.util.List;

public interface IUserRepository {
    FollowerList findSellerById(Integer id);
    FollowerList findClientById(Integer id);
    Integer getClientIndex(FollowerList client);
    Integer getSellerIndex(FollowerList seller);
    void updateClients(Integer index, FollowerList client);
    void updateSellers(Integer index, FollowerList seller);
    FollowerList getFollowerByUserId(Integer userId);
    String getUsernameById(Integer userId);
    User findById(Integer user_id);
    Boolean existsById(Integer user_Id);
    Boolean existsClientById(Integer clientId);
    Boolean existsSellerById(Integer sellerId);
    FollowerList findSellerByUser(User user);
    FollowerList findClientByUser(User user);
    void saveSeller(FollowerList seller);
    void saveClient(FollowerList client);
    int countFollowers(Integer userId);
    List<FollowerList> getAllSellers();
}
