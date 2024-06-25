package com.mercadolibre.pf_be_hisp_w26_t07_torres.repository;

import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.projection.IWarehouseBatchProduct;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IWarehouseRepository extends JpaRepository<Warehouse, Long> {
    @Query(" SELECT w.id warehouseId, w.name warehouseName, " +
            "   sum(b.currentQuantity) batchCurrentQuantity " +
            " FROM Warehouse w " +
            " INNER JOIN w.sections s" +
            " INNER JOIN s.batches b " +
            " INNER JOIN b.productSeller ps " +
            " WHERE ps.id = :idProductSeller " +
            " GROUP BY w.id ")
    List<IWarehouseBatchProduct> CalculationCuantityTheProductWarehouse(
            @Param("idProductSeller") Long idProductSeller);
}
