package com.mercadolibre.sprint3_individual_perez.repository;

import com.mercadolibre.sprint3_individual_perez.entity.User;
import com.mercadolibre.sprint3_individual_perez.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IWarehouseRepository extends JpaRepository<Warehouse, Long> {
    Optional<Warehouse> findByIdAndPeople(Long id, List<User> people);
}
