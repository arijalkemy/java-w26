package com.mercadolibre.pf_be_hisp_w26_t07_torres.repository;

import com.mercadolibre.pf_be_hisp_w26_t07_torres.entity.StorageType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IStorageTypeRepository extends JpaRepository<StorageType, Long> {
    Optional<StorageType> findStorageTypeByNameEqualsIgnoreCase(String name);
}
