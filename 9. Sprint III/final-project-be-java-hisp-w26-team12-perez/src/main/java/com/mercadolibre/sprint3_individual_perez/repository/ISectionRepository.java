package com.mercadolibre.sprint3_individual_perez.repository;

import com.mercadolibre.sprint3_individual_perez.entity.Section;
import com.mercadolibre.sprint3_individual_perez.entity.Warehouse;
import com.mercadolibre.sprint3_individual_perez.projections.SectionProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ISectionRepository extends JpaRepository<Section, Long> {
    Optional<Section> findByIdAndWarehouse(Long id, Warehouse warehouse);

    @Query("SELECT s.id AS id " +
            "FROM Section s " +
            "JOIN s.inboundOrders io " +
            "JOIN io.batchStocks bs " +
            "WHERE bs.product.id = :productId AND s.warehouse.id = :warehouseId")
    Optional<SectionProjection> findSectionByProductIdAndWarehouseId(@Param("productId") Long productId, @Param("warehouseId") Long warehouseId);

}
