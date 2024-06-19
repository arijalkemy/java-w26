package com.mercadolibre.pf_be_hisp_w26_t11_roman.repository;

import com.mercadolibre.pf_be_hisp_w26_t11_roman.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IStatusRepository extends JpaRepository<Status,Integer> {

    Optional<Status> findByStatusCode(String statusCode);
}
