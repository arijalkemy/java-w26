package com.mercadolibre.sprint3_individual_perez.repository;

import com.mercadolibre.sprint3_individual_perez.entity.User;
import com.mercadolibre.sprint3_individual_perez.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IUserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);

    @Query("SELECT u.warehouses FROM User u WHERE u.id = :userId")
    List<Warehouse> findWarehousesByUserId(@Param("userId") Long userId);
}