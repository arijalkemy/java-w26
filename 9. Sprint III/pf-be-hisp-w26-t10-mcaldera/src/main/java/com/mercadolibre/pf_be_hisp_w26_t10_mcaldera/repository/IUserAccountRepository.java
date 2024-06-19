package com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.repository;

import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IUserAccountRepository extends JpaRepository<UserAccount, Long> {

    /**
     * Get role by user
     *
     * @param idSeller user identifier
     * @return user role
     */
    @Query("select userRole from UserAccount where userId = :userId")
    String validateUserSeller(@Param("userId") String idSeller);
}