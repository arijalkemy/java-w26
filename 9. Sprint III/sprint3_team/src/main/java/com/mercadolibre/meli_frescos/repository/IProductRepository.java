package com.mercadolibre.meli_frescos.repository;


import com.mercadolibre.meli_frescos.dto.frescos.ProductSimpleResponseDTO;
import com.mercadolibre.meli_frescos.model.Product;
import com.mercadolibre.meli_frescos.dto.frescos.WarehouseDTO;
import com.mercadolibre.meli_frescos.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product,Integer> {
    @Override
    List<Product> findAllById(Iterable<Integer> longs);
    @Query("SELECT new com.mercadolibre.meli_frescos.dto.frescos.WarehouseDTO(w.warehouseCode, SUM(b.currentQuantity)) " +
           "FROM Product p JOIN p.batches b JOIN b.section s JOIN s.warehouse w " +
           "WHERE p.id = :id " +
           "GROUP BY w.warehouseCode")
    List<WarehouseDTO> findWarehousesAndQuantitiesByProductId(@Param("id") Integer id);


    @Query("SELECT new com.mercadolibre.meli_frescos.dto.frescos.ProductSimpleResponseDTO( p.name, p.price )" +
            "FROM Product p" + " JOIN p.batches b " + "JOIN b.section s WHERE s.productType.acronym = :acronym"
    )
    List<ProductSimpleResponseDTO> findAllByProductTypeAcronym(String acronym);
}
