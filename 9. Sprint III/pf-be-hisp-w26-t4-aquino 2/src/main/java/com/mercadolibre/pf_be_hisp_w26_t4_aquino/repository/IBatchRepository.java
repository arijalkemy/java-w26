package com.mercadolibre.pf_be_hisp_w26_t4_aquino.repository;

import com.mercadolibre.pf_be_hisp_w26_t4_aquino.model.Batch;
import com.mercadolibre.pf_be_hisp_w26_t4_aquino.model.ProductTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import com.mercadolibre.pf_be_hisp_w26_t4_aquino.model.projection.BatchWithLocation;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IBatchRepository extends JpaRepository<Batch, Long> {
    List<Batch> findByDueDateBetweenOrderByDueDateAsc(LocalDate today, LocalDate dueDate);
    List<Batch> findByDueDateBetweenAndProduct_ProductType_DescriptionOrderByDueDateAsc(
            LocalDate today, LocalDate dueDate, ProductTypeEnum description);
    List<Batch> findByDueDateBetweenAndProduct_ProductType_DescriptionOrderByDueDateDesc(
            LocalDate today, LocalDate dueDate, ProductTypeEnum description);

    String QUERY = "SELECT " +
            "       w.id               as warehouseId," +
            "       s.id               as sectionId, " +
            "       b.product_id       as productId, " +
            "       b.id               as batchId, " +
            "       b.current_quantity as currentQuantity, " +
            "       b.due_date         as dueDate " +
            "FROM Warehouse w " +
            "         JOIN section s ON w.id = s.warehouse_id " +
            "         JOIN section_batch sb on s.id = sb.section_id " +
            "         JOIN batch b on sb.batch_id = b.id " +
            "         JOIN warehouse_manager u ON w.id = u.warehouse_id " +
            "WHERE u.user_id = :userId AND b.product_id = :productId ";

    @Query(nativeQuery = true, value = QUERY + "ORDER BY b.id")
    List<BatchWithLocation> findByProductIdOrderById(Long userId, Long productId);

    @Query(nativeQuery = true, value = QUERY + "ORDER BY b.due_date DESC")
    List<BatchWithLocation> findByProductIdOrderByDueDate(Long userId, Long productId);

    @Query(nativeQuery = true, value = QUERY + "ORDER BY b.current_quantity DESC")
    List<BatchWithLocation> findByProductIdOrderByCurrentQuantity(Long userId, Long productId);

}
