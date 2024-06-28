package com.mercadolibre.project_be_java_hisp_w26_t7.repository;

import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.projection.IBatchesResponseProjection;
import com.mercadolibre.project_be_java_hisp_w26_t7.entity.Batch;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IBatchRepository extends JpaRepository<Batch, Long> {

    Optional<Batch> findBatchesByProductSellerId(Long productSeller_id);

    @Query("""
        SELECT distinct w, s, b.batchNumber as batchNumber, b.dueDate as dueDate, 
           b.currentQuantity as currentQuantity, p.id as productId, st.id as storageType
           FROM Warehouse w 
           INNER JOIN fetch w.sections s 
           INNER JOIN fetch s.batches b
           INNER JOIN b.representative r 
           INNER JOIN b.productSeller ps 
           INNER JOIN ps.product p
           INNER JOIN p.storageType st
           WHERE b.dueDate BETWEEN :startDate AND :endDate 
           AND r.id = :representativeId
           """)
    List<IBatchesResponseProjection> findBatchesCloseToExpire(@Param("startDate") LocalDate startDate,
                                          @Param("endDate") LocalDate endDate,
                                          @Param("representativeId") int representativeId,
                                          Sort sort);


                                          

    @Query("""
    SELECT distinct w, s, b.batchNumber as batchNumber, b.dueDate as dueDate, 
           b.currentQuantity as currentQuantity, p.id as productId, st.id as storageType
           FROM Warehouse w 
           INNER JOIN fetch w.sections s 
           INNER JOIN fetch s.batches b
           INNER JOIN b.representative r 
           INNER JOIN b.productSeller ps 
           INNER JOIN ps.product p
           INNER JOIN p.storageType st
    WHERE b.dueDate BETWEEN :startDate AND :endDate 
    AND r.id = :representativeId
    AND p.storageType.name = :storageType
    """)
    List<IBatchesResponseProjection> findBatchesCloseToExpireByCategory(@Param("startDate") LocalDate startDate,
                                    @Param("endDate") LocalDate endDate,
                                    @Param("representativeId") int representativeId,
                                    @Param("storageType") String storageType,
                                    Sort sort);

    Optional<Batch> findBatchByBatchNumberAndProductSellerId(Long batchNumber, Long productSeller_id);
}

