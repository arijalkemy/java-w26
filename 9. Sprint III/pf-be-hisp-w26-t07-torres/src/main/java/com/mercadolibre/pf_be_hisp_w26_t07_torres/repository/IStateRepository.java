package com.mercadolibre.pf_be_hisp_w26_t07_torres.repository;

import com.mercadolibre.pf_be_hisp_w26_t07_torres.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IStateRepository extends JpaRepository<Status, Long> {
    Optional<Status> findFirstByDescription(String description);
}
