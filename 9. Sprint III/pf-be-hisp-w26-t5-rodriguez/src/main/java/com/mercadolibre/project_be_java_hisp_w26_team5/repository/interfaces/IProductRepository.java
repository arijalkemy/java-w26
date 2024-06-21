package com.mercadolibre.project_be_java_hisp_w26_team5.repository.interfaces;

import com.mercadolibre.project_be_java_hisp_w26_team5.enums.TypeProduct;
import com.mercadolibre.project_be_java_hisp_w26_team5.model.Product;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product> {

    List<Product> findByType(@NotNull TypeProduct type);

    List<Product> findAll(Specification<Product> spec);
}
