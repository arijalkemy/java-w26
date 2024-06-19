package com.mercadolibre.pf_be_hisp_w26_t11_pacheco.repository;

import com.mercadolibre.pf_be_hisp_w26_t11_pacheco.model.Batch;
import com.mercadolibre.pf_be_hisp_w26_t11_pacheco.model.Product;
import com.mercadolibre.pf_be_hisp_w26_t11_pacheco.model.Section;
import com.mercadolibre.pf_be_hisp_w26_t11_pacheco.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface IBatchRepository extends JpaRepository<Batch,Integer> {
    List<Batch> findAllByProduct(Product product);

    @Query("SELECT b FROM Batch b WHERE b.dueDate >= :minDueDate AND b.product.id = :idProduct")
    List<Batch> findByMinDueDate(@Param("minDueDate") LocalDate minDueDate, @Param("idProduct") Integer idProduct);

    Batch findByBatchNumber(Integer batchNumber);
    List<Batch> findAllBySection(Section sectionCode);
    @Query("SELECT b FROM Batch b WHERE b.dueDate BETWEEN :currentDate AND :futureDate ")
    List<Batch> findByDueDate(@Param("currentDate") LocalDate currentDate,
                                            @Param("futureDate") LocalDate futureDate);
    @Query("SELECT b FROM Batch b WHERE b.dueDate BETWEEN :currentDate AND :futureDate " +
            "AND b.section.productType.id = :productTypeId")
    List<Batch> findByDueDateAndProductType(@Param("currentDate") LocalDate currentDate,
                                            @Param("futureDate") LocalDate futureDate,
                                            @Param("productTypeId") Integer productTypeId);

    @Query("SELECT b FROM Batch b WHERE b.product = :product AND b.section.warehouse = :warehouse")
    List<Batch> findByProductAndWarehouse(@Param("product") Product product, @Param("warehouse") Warehouse warehouse);
}
