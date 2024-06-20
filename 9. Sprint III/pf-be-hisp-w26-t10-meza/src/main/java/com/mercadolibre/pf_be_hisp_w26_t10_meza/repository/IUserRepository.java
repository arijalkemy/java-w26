package com.mercadolibre.pf_be_hisp_w26_t10_meza.repository;

import com.mercadolibre.pf_be_hisp_w26_t10_meza.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<UserAccount,Long> {

    Optional<UserAccount> findByUsername(String username);
    UserAccount findUserAccountByUserId(Long id);
}
