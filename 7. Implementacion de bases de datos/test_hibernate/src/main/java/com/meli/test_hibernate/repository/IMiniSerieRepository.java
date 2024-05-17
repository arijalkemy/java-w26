package com.meli.test_hibernate.repository;

import com.meli.test_hibernate.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


public interface IMiniSerieRepository extends JpaRepository<MiniSerie, Long> {
}
