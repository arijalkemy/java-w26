package com.mercadolibre.meli_frescos.repository;

import com.mercadolibre.meli_frescos.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IStatusRepository extends JpaRepository<Status,Integer> {

    Optional<Status> findByStatusCode(String statusCode);
}
