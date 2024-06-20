package com.mercadolibre.pf_be_hisp_w26_t11_perez.repository;


import com.mercadolibre.pf_be_hisp_w26_t11_perez.dto.frescos.ProductSimpleResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t11_perez.dto.frescos.WarehouseDTO;
import com.mercadolibre.pf_be_hisp_w26_t11_perez.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product,Integer> {
    @Override
    List<Product> findAllById(Iterable<Integer> longs);
    @Query("SELECT new com.mercadolibre.pf_be_hisp_w26_t11_perez.dto.frescos.WarehouseDTO(w.warehouseCode, SUM(b.currentQuantity)) " +
           "FROM Product p JOIN p.batches b JOIN b.section s JOIN s.warehouse w " +
           "WHERE p.id = :id " +
           "GROUP BY w.warehouseCode")
    List<WarehouseDTO> findWarehousesAndQuantitiesByProductId(@Param("id") Integer id);


    @Query("SELECT new com.mercadolibre.pf_be_hisp_w26_t11_perez.dto.frescos.ProductSimpleResponseDTO( p.name, p.price )" +
            "FROM Product p" + " JOIN p.batches b " + "JOIN b.section s WHERE s.productType.acronym = :acronym"
    )
    List<ProductSimpleResponseDTO> findAllByProductTypeAcronym(String acronym);
}