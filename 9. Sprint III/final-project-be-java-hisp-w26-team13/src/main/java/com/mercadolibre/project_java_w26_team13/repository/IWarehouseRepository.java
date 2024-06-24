package com.mercadolibre.project_java_w26_team13.repository;

import com.mercadolibre.project_java_w26_team13.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IWarehouseRepository extends JpaRepository<Warehouse, Long> {
}
