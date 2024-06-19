package com.mercadolibre.fresh_market.repository;

import com.mercadolibre.fresh_market.model.Batch;
import com.mercadolibre.fresh_market.model.Product;
import com.mercadolibre.fresh_market.model.Section;
import com.mercadolibre.fresh_market.model.enums.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IBatchRepository extends JpaRepository<Batch, Long> {
    List<Batch> findByProduct(Product product);

    List<Batch> findByProductAndSection(Product product, Section section);

    @Query("SELECT b FROM Batch b WHERE b.dueDate BETWEEN :startDate AND :endDate " +
            "AND b.section.warehouse.id = :warehouseId")
    List<Batch> findBatchesExpiringSoon(@Param("warehouseId") Long warehouseId,
                                        @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query("SELECT DISTINCT b.product FROM Batch b WHERE b.section.category = ?1")
    List<Product> findDistinctProductsByCategory(Category category);
    List<Batch> findByProductId(Long productID);
}
