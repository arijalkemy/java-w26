package com.mercadolibre.sprint3_individual_perez.repository;

import com.mercadolibre.sprint3_individual_perez.dto.response.BatchDueDTO;
import com.mercadolibre.sprint3_individual_perez.entity.BatchStock;
import com.mercadolibre.sprint3_individual_perez.projections.BatchStockProjection;
import com.mercadolibre.sprint3_individual_perez.projections.WarehouseProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.mercadolibre.sprint3_individual_perez.enums.Category;
import java.util.List;

import java.sql.Date;

public interface IBatchStockRepository extends JpaRepository<BatchStock,Long> {

    @Query("SELECT new com.mercadolibre.sprint3_individual_perez.dto.response.BatchDueDTO (bs.id, bs.product.id, p.type, bs.dueDate, bs.currentQuantity)" +
            "FROM BatchStock bs " +
            "INNER JOIN bs.product p " +
            "INNER JOIN bs.inboundOrder ibo " +
            "INNER JOIN ibo.section s " +
            "WHERE s.warehouse.id = :warehouseId " +
            "AND bs.dueDate BETWEEN :startDate AND :endDate")
    List<BatchDueDTO> findProductsBetweenDate(Long warehouseId, Date startDate, Date endDate);

    List<BatchStock> getBatchStocksByProductId(Long id);

    List<BatchStockProjection>  findByProductId(Long productID);

    @Query("SELECT NEW  com.mercadolibre.sprint3_individual_perez.projections.BatchStockProjection(bs.id, bs.currentQuantity, bs.dueDate) " +
            "FROM BatchStock bs " +
            "JOIN bs.inboundOrder io " +
            "JOIN io.section s " +
            "WHERE bs.product.id = :productId " +
            "AND s.warehouse.id = :warehouseId")
    List<BatchStockProjection> findByProductIDAndWareHouseID(@Param("productId")Long productI, @Param("warehouseId")Long warehouseId);

    @Query("SELECT NEW  com.mercadolibre.sprint3_individual_perez.projections.WarehouseProjection(s.warehouse.id, SUM(bs.currentQuantity)) " +
            "FROM BatchStock bs " +
            "JOIN bs.inboundOrder io " +
            "JOIN io.section s " +
            "WHERE bs.product.id = :productId " +
            "GROUP BY s.warehouse.id")
    List<WarehouseProjection> findWarehouseStockByProductId(@Param("productId")Long productId);


    @Query("SELECT new com.mercadolibre.sprint3_individual_perez.dto.response.BatchDueDTO(bs.id, bs.product.id, p.type, " +
            "bs.dueDate, bs.currentQuantity) " +
            "FROM BatchStock bs " +
            "INNER JOIN bs.product p " +
            "INNER JOIN bs.inboundOrder ibo " +
            "INNER JOIN ibo.section s " +
            "WHERE s.warehouse.id = :warehouseId " +
            "AND bs.dueDate BETWEEN :startDate AND :endDate " +
            "AND p.type = :category " +
            "ORDER BY " +
            "CASE WHEN :order = 'date_asc' THEN bs.dueDate END ASC, " +
            "CASE WHEN :order = 'date_desc' THEN bs.dueDate END DESC")
    List<BatchDueDTO> findProductsBetweenDateAndCategory(@Param("warehouseId") Long warehouseId,
                                                         @Param("startDate") Date startDate,
                                                         @Param("endDate") Date endDate,
                                                         @Param("category") Category category,
                                                         @Param("order") String order);


}
