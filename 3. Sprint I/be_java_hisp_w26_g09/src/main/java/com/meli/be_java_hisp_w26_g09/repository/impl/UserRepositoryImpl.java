package com.meli.be_java_hisp_w26_g09.repository.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w26_g09.entity.User;
import com.meli.be_java_hisp_w26_g09.repository.IUserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements IUserRepository {
    List<User> listOfUser = new ArrayList<>();

    public UserRepositoryImpl() throws IOException {
        loadDataBase();
    }

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<User> users;

        file = ResourceUtils.getFile("classpath:users_generated.json");
        users = objectMapper.readValue(file, new TypeReference<>() {
        });
        listOfUser = users;
    }


    @Override
    public Optional<User> findById(Integer id) {
        if (id == null || id == 0)
            return Optional.empty();

        return listOfUser.stream().filter(user -> user.getUserId().equals(id))
                .findFirst();
    }

    @Override
    public List<User> findAll() {
        return listOfUser;
    }

    @Override
    public void unfollowUser(User userWhoUnfollow, User userToUnfollow) {
        userWhoUnfollow.getFollowed().remove(userToUnfollow);
    }

    @Override
    public void addFollowed(User customer, User seller) {
        customer.getFollowed().add(seller);
    }

}
