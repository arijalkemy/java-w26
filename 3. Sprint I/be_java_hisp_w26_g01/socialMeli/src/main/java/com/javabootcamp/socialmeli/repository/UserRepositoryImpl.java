package com.javabootcamp.socialmeli.repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javabootcamp.socialmeli.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

@Repository
public class UserRepositoryImpl implements UserRepository{

    private List<User> usersList = new ArrayList<>();

    public UserRepositoryImpl() throws  IOException {
        loadDataBase();
    }

    @Override
    public Optional<User> findById(Integer id) {
        return usersList
            .stream()
            .filter(u -> u.getId().equals(id))
            .findFirst();
    }

    @Override
    public List<User> getAllUsers() {
        return usersList;
    }

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<User> users;

        file = ResourceUtils.getFile("classpath:users.json");
        users = objectMapper.readValue(file, new TypeReference<List<User>>() {
        });

        usersList = users;
    }

}
