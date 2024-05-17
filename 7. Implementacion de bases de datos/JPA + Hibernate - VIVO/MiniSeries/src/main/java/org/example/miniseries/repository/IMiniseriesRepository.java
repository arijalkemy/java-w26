package org.example.miniseries.repository;

import org.example.miniseries.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMiniseriesRepository extends JpaRepository<MiniSerie, Long> {
}
