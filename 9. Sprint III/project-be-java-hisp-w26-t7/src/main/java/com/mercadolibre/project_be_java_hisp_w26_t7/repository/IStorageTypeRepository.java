package com.mercadolibre.project_be_java_hisp_w26_t7.repository;

import com.mercadolibre.project_be_java_hisp_w26_t7.entity.StorageType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStorageTypeRepository extends JpaRepository<StorageType, Long> {
}
