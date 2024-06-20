package com.mercadolibre.project_be_java_hisp_w26_t7.repository;

import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.projection.IProductResponseProjection;
import com.mercadolibre.project_be_java_hisp_w26_t7.entity.ProductSeller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductSellerRepository extends JpaRepository<ProductSeller, Long> {

    @Query("SELECT ps.id AS id, p.description AS description, ps.price AS price, ps.seller.name AS sellerName, " +
            "st.name as category " +
            "FROM OrderProductSeller ops " +
            "JOIN ops.productSeller ps " +
            "JOIN ps.product p " +
            "JOIN p.storageType st " +
            "WHERE ops.order.id = :orderId")
    List<IProductResponseProjection> findAllByOrderId(@Param("orderId") Long orderId);

    @Query("SELECT ps.id AS id, p.description AS description, ps.price AS price, ps.seller.name AS sellerName, " +
            "st.name as category " +
            "FROM ProductSeller ps " +
            "JOIN ps.product p " +
            "JOIN p.storageType st " +
            "WHERE upper(st.name) = upper(:category)")
    List<IProductResponseProjection> findAllByCategory(@Param("category") String category);

    @Query("SELECT ps.id AS id, p.description AS description, ps.price AS price, ps.seller.name AS sellerName, " +
            "st.name as category " +
            "FROM ProductSeller ps " +
            "JOIN ps.product p " +
            "JOIN p.storageType st ")
    List<IProductResponseProjection> findAllJoinProduct();

}
