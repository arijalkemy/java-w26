package com.mercadolibre.pf_be_hisp_w26_t10_imbachi.repository;

import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IWarehouseRepository extends JpaRepository<Warehouse, Integer> {

    @Query("SELECT w FROM Warehouse w WHERE w.supervisor.userId = :supervisorId")
    List<Warehouse> findBySupervisorId(Long supervisorId);

}