package com.mercadolibre.final_project_java_h_w26_t10.repository;

import com.mercadolibre.final_project_java_h_w26_t10.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<UserAccount,Long> {

    Optional<UserAccount> findByUsername(String username);
    UserAccount findUserAccountByUserId(Long id);
}
