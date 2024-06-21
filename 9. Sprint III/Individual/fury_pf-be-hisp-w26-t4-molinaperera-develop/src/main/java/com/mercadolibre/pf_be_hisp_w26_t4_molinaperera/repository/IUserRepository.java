package com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.repository;

import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface IUserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
