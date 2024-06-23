package com.mercadolibre.pf_be_hisp_w26_t01_moises.repository;

import com.mercadolibre.pf_be_hisp_w26_t01_moises.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT e FROM Product e WHERE e.id IN :ids")
    List<Product> findAllByIds(@Param("ids") List<Integer> ids);
    List<Product> findAllByCategoryName(String categoryName);
}
