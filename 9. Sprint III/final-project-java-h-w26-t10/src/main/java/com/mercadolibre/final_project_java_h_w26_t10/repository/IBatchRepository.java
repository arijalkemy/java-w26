package com.mercadolibre.final_project_java_h_w26_t10.repository;

import com.mercadolibre.final_project_java_h_w26_t10.entity.Batch;
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