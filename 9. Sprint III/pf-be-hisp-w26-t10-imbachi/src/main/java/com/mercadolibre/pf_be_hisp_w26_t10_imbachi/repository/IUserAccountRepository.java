package com.mercadolibre.pf_be_hisp_w26_t10_imbachi.repository;

import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserAccountRepository extends JpaRepository<UserAccount, Long> {
}