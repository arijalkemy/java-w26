package com.mercadolibre.pf_be_hisp_w26_t7_villarraga.repository;

import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.projection.IProductResponseProjection;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.entity.Product;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.entity.ProductSeller;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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

    Optional<ProductSeller> findByProductAndSeller(Product product, Seller seller);
}
