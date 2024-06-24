package com.mercadolibre.final_project_java_hisp_w26_t6.repository;

import com.mercadolibre.final_project_java_hisp_w26_t6.entity.Batch;
import com.mercadolibre.final_project_java_hisp_w26_t6.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IBatchesRepository extends JpaRepository<Batch,Long> {
    Batch findByBatchNumber(Integer batchNumber);
    List<Batch> findAllByProduct(Product product);
    List<Batch> findAllByDueDateBetweenOrderByDueDate(LocalDateTime today, LocalDateTime otherDate);
}
