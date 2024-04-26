package com.example.sprint1.repository;

import com.example.sprint1.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements IUserRepository{

    private static List<User> listOfUsers;

    public UserRepositoryImpl() throws IOException {
        loadDatabase();
    }

    /**
     * Method use to load listOfUsers
     * @throws IOException
     */
    private void loadDatabase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<User> users;

        file= ResourceUtils.getFile("classpath:users.json");
        users = objectMapper.readValue(file,new TypeReference<List<User>>(){});

        listOfUsers = users;
    }

    /**
     * Returns the list of all users
     * @return
     */
    @Override
    public List<User> findAll(){
        return listOfUsers;
    }

    /**
     * Function that searches in the list by userId
     * @param id Id of the user to search
     * @return returns the user or null if it isnt found in the list
     */
    @Override
    public User findUserById(Integer id) {
        return listOfUsers.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }

    /**
     * Function that updates the followers of userToFollow and followed of user
     * @param user User who will follow
     * @param userToFollow User who will be followed
     */
    @Override
    public void updateUserFollower(User user, User userToFollow) {
        user.addFollowed(userToFollow.getId());
        userToFollow.addFollower(user.getId());
    }

    /**
     * Updates the follower and followed by deleting
     * @param user
     * @param userToFollow
     * @return
     */
    @Override
    public void updateUserFollowerDelete(User user, User userToFollow){
        user.deleteFollowed(userToFollow.getId());
        userToFollow.deleteFollower(user.getId());
    }

    /**
     * Returns an optional of users
     * @param id
     * @return
     */
    @Override
    public Optional<User> getUserById(int id) {
        return listOfUsers.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

}
