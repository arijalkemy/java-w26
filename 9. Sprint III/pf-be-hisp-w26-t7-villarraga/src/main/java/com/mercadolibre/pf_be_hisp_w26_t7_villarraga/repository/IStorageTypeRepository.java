package com.mercadolibre.pf_be_hisp_w26_t7_villarraga.repository;

import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.entity.StorageType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IStorageTypeRepository extends JpaRepository<StorageType, Long> {
    Optional<StorageType> findByName(String name);
}
