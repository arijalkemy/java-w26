package com.mercadolibre.pf_be_hisp_w26_t4_aquino.repository;

import com.mercadolibre.pf_be_hisp_w26_t4_aquino.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAll();
    List<Product> findAllByProductTypeId(Long productTypeId);

    @Query(value = """
        SELECT W.ID AS warehouse_code, SUM(B.CURRENT_QUANTITY) AS total_quantity 
        FROM PRODUCT P
        JOIN BATCH B ON B.PRODUCT_ID = P.ID 
        JOIN SECTION_BATCH SB ON B.ID = SB.BATCH_ID 
        JOIN SECTION S ON S.ID = SB.SECTION_ID 
        JOIN WAREHOUSE W ON S.WAREHOUSE_ID = W.ID 
        WHERE P.ID = :productId 
        GROUP BY W.ID
        """, nativeQuery = true)
    List<Object[]> findProductQuantityInWarehouses(@Param("productId") Long productId);
}
