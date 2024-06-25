package com.mercadolibre.project_be_java_hisp_w26_t7.repository;

import com.mercadolibre.project_be_java_hisp_w26_t7.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IStateRepository extends JpaRepository<Status, Long> {
    Optional<Status> findFirstByDescription(String description);
}
