package com.mercadolibre.sprint_3_team_12_malacara.repository;

import com.mercadolibre.sprint_3_team_12_malacara.entity.User;
import com.mercadolibre.sprint_3_team_12_malacara.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IWarehouseRepository extends JpaRepository<Warehouse, Long> {
    Optional<Warehouse> findByIdAndPeople(Long id, List<User> people);
}
