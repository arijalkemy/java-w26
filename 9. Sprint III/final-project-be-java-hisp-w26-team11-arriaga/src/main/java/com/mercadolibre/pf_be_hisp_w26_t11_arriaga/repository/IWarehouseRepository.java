package com.mercadolibre.pf_be_hisp_w26_t11_arriaga.repository;

import com.mercadolibre.pf_be_hisp_w26_t11_arriaga.model.Batch;
import com.mercadolibre.pf_be_hisp_w26_t11_arriaga.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IWarehouseRepository extends JpaRepository<Warehouse,Integer> {
   @Query("SELECT w.warehouseCode, u.firstName, u.lastName, u.role FROM Warehouse w JOIN w.representative u WHERE w.warehouseCode = :warehouseCode")
   List<Object[]>  findByRepresentativeOrderByWarehouseCode(@Param("warehouseCode") Integer warehouseCode);
}

//select * from WAREHOUSES w join USERS s on w.representative_id = s.id where w.warehouse_code = 1001;