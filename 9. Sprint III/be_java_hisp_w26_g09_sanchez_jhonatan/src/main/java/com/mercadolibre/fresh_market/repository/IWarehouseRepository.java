package com.mercadolibre.fresh_market.repository;

import com.mercadolibre.fresh_market.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWarehouseRepository extends JpaRepository<Warehouse,Long> {

    Warehouse findWarehouseByWarehousemanId(Long warehousemanId);
}
