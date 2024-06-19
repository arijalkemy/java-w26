package com.mercadolibre.pf_be_hisp_w26_t11_pacheco.repository;

import com.mercadolibre.pf_be_hisp_w26_t11_pacheco.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IWarehouseRepository extends JpaRepository<Warehouse,Integer> {
    Optional<Warehouse> findByWarehouseCode(Integer warehouseCode);
}
