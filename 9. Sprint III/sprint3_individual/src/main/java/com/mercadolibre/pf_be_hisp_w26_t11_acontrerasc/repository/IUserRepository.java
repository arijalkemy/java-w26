package com.mercadolibre.pf_be_hisp_w26_t11_acontrerasc.repository;

import com.mercadolibre.pf_be_hisp_w26_t11_acontrerasc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUsername(String username);
}
