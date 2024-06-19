package com.mercadolibre.final_project_java_hisp_w26_t1.repository;

import com.mercadolibre.final_project_java_hisp_w26_t1.dtos.ProductPurchaseDTO;
import com.mercadolibre.final_project_java_hisp_w26_t1.entity.Batch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface IBatchRepository extends JpaRepository<Batch, Integer> {
    @Query("SELECT count(b) " +
            "FROM Batch b JOIN b.inboundOrder as order JOIN order.section as section " +
            "WHERE section.id = :sectionId")
    Integer countBatchesBySection(Integer sectionId);
    List<Batch> findByDueDateBetween(LocalDate startDate, LocalDate endDate);
    List<Batch> findByDueDateBetweenOrderByDueDateAsc(LocalDate startDate, LocalDate endDate);
    List<Batch> findByDueDateBetweenOrderByDueDateDesc(LocalDate startDate, LocalDate endDate);


    List<Batch> findAllByProductId(Integer productId);

    @Query("SELECT b " +
            "FROM Batch b " +
            "JOIN b.inboundOrder as order " +
            "JOIN order.section as section " +
            "JOIN section.warehouse as warehouse " +
            "WHERE b.product.id = :productId " +
            "AND warehouse.id = :warehouseId")
    List<Batch> findAllByProductIdAndWarehouseId(Integer productId, Integer warehouseId);
    @Query("SELECT b FROM Batch b WHERE b.product.id in :productsId")
    List<Batch> findByProductIdIn(@Param("productsId") List<Integer> productsIds);


}
