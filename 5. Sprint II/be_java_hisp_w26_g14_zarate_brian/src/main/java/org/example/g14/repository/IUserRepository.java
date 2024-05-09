package org.example.g14.repository;

import org.example.g14.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    List<User> getAll();
    Optional<User> getById(int id);
    void save(User user);
}
