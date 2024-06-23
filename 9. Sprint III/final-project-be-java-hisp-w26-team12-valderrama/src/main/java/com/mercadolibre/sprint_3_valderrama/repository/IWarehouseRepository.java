package com.mercadolibre.sprint_3_valderrama.repository;

import com.mercadolibre.sprint_3_valderrama.entity.User;
import com.mercadolibre.sprint_3_valderrama.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IWarehouseRepository extends JpaRepository<Warehouse, Long> {
    Optional<Warehouse> findByIdAndPeople(Long id, List<User> people);
}
