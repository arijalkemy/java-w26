package com.meli.lasperlas.repository;

import com.meli.lasperlas.model.Jewell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJewellRepository extends JpaRepository<Jewell, Long> {
}
