package com.mercadolibre.pf_be_hisp_w26_t10_hoyos.repository;


import com.mercadolibre.pf_be_hisp_w26_t10_hoyos.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserAccountRepository extends JpaRepository<UserAccount, Long> {
    UserAccount findByUserId(Long id);
}