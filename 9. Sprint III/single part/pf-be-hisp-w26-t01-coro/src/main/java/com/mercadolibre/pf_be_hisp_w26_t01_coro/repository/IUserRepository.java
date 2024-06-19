package com.mercadolibre.pf_be_hisp_w26_t01_coro.repository;

import com.mercadolibre.pf_be_hisp_w26_t01_coro.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
