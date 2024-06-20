package com.mercadolibre.pf_be_hisp_w26_t10_imbachi.repository;

import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.entity.Batch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IBatchRepository extends JpaRepository<Batch, Integer> {
    List<Batch> findByProductIdAndDueDateAfterAndCurrentQuantityGreaterThanEqual(Integer productId, LocalDate date, Integer quantity);
    List<Batch> findByDueDateBefore(LocalDate date);
    List<Batch> findByDueDateBetween(LocalDate actualDate, LocalDate limitDate);

    List<Batch> findByCurrentQuantityIsLessThanEqual(Integer quantity);

    @Query("SELECT b FROM Batch b WHERE b.dueDate BETWEEN :today AND :endDate AND b.product.category.name = :category ORDER BY b.dueDate ASC")
    List<Batch> findBatchesByDueDateAndCategoryAsc(@Param("today") LocalDate initialDate,
                                                @Param("endDate") LocalDate limitDate,
                                                @Param("category") String category);

    @Query("SELECT b FROM Batch b WHERE b.dueDate BETWEEN :today AND :endDate AND b.product.category.name = :category ORDER BY b.dueDate DESC")
    List<Batch> findBatchesByDueDateAndCategoryDesc(@Param("today") LocalDate initialDate,
                                                   @Param("endDate") LocalDate limitDate,
                                                   @Param("category") String category);

    @Query("SELECT b " + "FROM Batch b " + "WHERE b.batchNumber = :batch_number")
    Batch findBatchByBatchNumber(@Param("batch_number" ) Integer batch_number);
}