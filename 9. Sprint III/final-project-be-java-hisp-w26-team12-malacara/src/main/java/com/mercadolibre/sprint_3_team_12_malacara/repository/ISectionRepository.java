package com.mercadolibre.sprint_3_team_12_malacara.repository;

import com.mercadolibre.sprint_3_team_12_malacara.entity.Section;
import com.mercadolibre.sprint_3_team_12_malacara.entity.Warehouse;
import com.mercadolibre.sprint_3_team_12_malacara.projections.SectionProjection;
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
