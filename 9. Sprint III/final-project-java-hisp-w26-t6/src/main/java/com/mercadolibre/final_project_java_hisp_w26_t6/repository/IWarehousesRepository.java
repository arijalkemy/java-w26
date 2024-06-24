package com.mercadolibre.final_project_java_hisp_w26_t6.repository;

import com.mercadolibre.final_project_java_hisp_w26_t6.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWarehousesRepository extends JpaRepository<Warehouse, Integer> {
    Warehouse findBySupervisorUsername(String username);

}
