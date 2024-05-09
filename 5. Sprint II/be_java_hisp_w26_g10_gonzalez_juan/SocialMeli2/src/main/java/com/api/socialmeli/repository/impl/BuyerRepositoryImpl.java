package com.api.socialmeli.repository.impl;

import com.api.socialmeli.entity.Buyer;
import com.api.socialmeli.entity.Seller;
import com.api.socialmeli.repository.IBuyerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BuyerRepositoryImpl implements IBuyerRepository {
    private List<Buyer> buyers = new ArrayList<>();

    public BuyerRepositoryImpl(){
        this.buyers = this.loadData();
    }


    @Override
    public Buyer getById(Integer id) {
        return buyers.stream().filter(
                b -> b.getUser_id().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Buyer> getAll() {
        return buyers;
    }

    public void saveAll(List<Buyer> buyers) {
        this.buyers = buyers;
    }

    @Override
    public Buyer followUser(Buyer userFollowing, Seller userFollowed) {
        userFollowing.getFollowed().add(userFollowed);
        return userFollowing;
    }

    public List<Buyer> loadData(){
        List<Buyer> buyers = new ArrayList<>();
        String route = "classpath:buyer.json";
        ObjectMapper objectMapper = new ObjectMapper();
        File file;
        try {
            file = ResourceUtils.getFile(route);

            Buyer[] buyersArray = objectMapper.readValue(file, Buyer[].class);

            for (Buyer b : buyersArray) {
                buyers.add(b);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return buyers;
    }
}
