package com.mercadolibre.pf_be_hisp_w26_t6_martinez.repository;

import com.mercadolibre.pf_be_hisp_w26_t6_martinez.entity.Product;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.util.StorageType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductsRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByStorageType(StorageType category);
}
