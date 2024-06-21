package com.mercadolibre.project_be_java_hisp_w26_team5.repository.interfaces;

import com.mercadolibre.project_be_java_hisp_w26_team5.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByUsername(String username);
    Boolean existsByUsername(String username);
}
