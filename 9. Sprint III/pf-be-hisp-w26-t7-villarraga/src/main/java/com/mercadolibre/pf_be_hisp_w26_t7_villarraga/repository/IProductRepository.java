package com.mercadolibre.pf_be_hisp_w26_t7_villarraga.repository;

import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.entity.Product;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.entity.StorageType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByDescriptionAndStorageType(String description, StorageType storageType);
}
