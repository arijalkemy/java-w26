package com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.repository.interfaces;

import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByUsername(String username);
    Boolean existsByUsername(String username);
}
