package com.mercadolibre.project_be_java_hisp_w26_team4.repository;

import com.mercadolibre.project_be_java_hisp_w26_team4.model.Warehouse;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IWarehouseRepository extends JpaRepository<Warehouse,Long> {

}
