package com.mercadolibre.project_java_w26_team13.repository;

import com.mercadolibre.project_java_w26_team13.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String username);
}
