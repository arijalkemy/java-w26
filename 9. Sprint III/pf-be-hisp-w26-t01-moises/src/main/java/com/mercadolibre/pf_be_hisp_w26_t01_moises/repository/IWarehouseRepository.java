package com.mercadolibre.pf_be_hisp_w26_t01_moises.repository;

import com.mercadolibre.pf_be_hisp_w26_t01_moises.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWarehouseRepository extends JpaRepository<Warehouse, Integer> {
}
