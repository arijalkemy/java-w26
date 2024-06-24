package com.mercadolibre.final_project_java_hisp_w26_t6.repository;

import com.mercadolibre.final_project_java_hisp_w26_t6.entity.Product;
import com.mercadolibre.final_project_java_hisp_w26_t6.util.StorageType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductsRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByStorageType(StorageType category);
}
