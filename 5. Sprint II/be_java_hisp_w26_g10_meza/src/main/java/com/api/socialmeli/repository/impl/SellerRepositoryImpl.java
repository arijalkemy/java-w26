package com.api.socialmeli.repository.impl;

import com.api.socialmeli.entity.Seller;
import com.api.socialmeli.repository.ISellerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SellerRepositoryImpl implements ISellerRepository {
    private List<Seller> sellers = new ArrayList<>();

    public SellerRepositoryImpl() {
        this.sellers = this.loadData();
    }

    @Override
    public Seller getById(Integer id) {
        return sellers.stream().filter(
                s -> s.getUser_id().equals(id)).findFirst().orElse(null);
    }

    //test
    @Override
    public List<Seller> getAll() {
        return sellers;
    }

    public List<Seller> loadData(){
        List<Seller> sellers = new ArrayList<>();
        String route = "classpath:seller.json";
        ObjectMapper objectMapper = new ObjectMapper();
        File file;
        try {
            file = ResourceUtils.getFile(route);

            Seller[] sellers1 = objectMapper.readValue(file, Seller[].class);

            for (Seller s : sellers1) {
                sellers.add(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sellers;
    }
}
