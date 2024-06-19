package com.mercadolibre.pf_be_hisp_w26_t11_arriaga.repository;

import com.mercadolibre.pf_be_hisp_w26_t11_arriaga.model.Batch;
import com.mercadolibre.pf_be_hisp_w26_t11_arriaga.model.Product;
import com.mercadolibre.pf_be_hisp_w26_t11_arriaga.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

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

    @Query("SELECT b FROM Batch b JOIN b.inboudOrder i join b.product WHERE i.orderNumber = :orderNumber")
    List<Batch> findInboundOrderWithBatches(@Param("orderNumber") Integer orderNumber);
}
