package com.example._01miniseries.repository;

import com.example._01miniseries.models.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMiniSerieRepository extends JpaRepository<MiniSerie, Long> {
}
