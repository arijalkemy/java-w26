package com.example.sprint1.repository;
import com.example.sprint1.model.User;
import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    List<User> findAll();
    User findUserById(Integer id);
    void updateUserFollower(User user, User userToFollow);
    Optional<User> getUserById(int id);

    void updateUserFollowerDelete(User user, User userToFollow);

    void addPost(Integer id, Integer postId);

}
