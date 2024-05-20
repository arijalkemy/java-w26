package com.example.miniseries.repository;

import com.example.miniseries.model.Miniserie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMiniserieRepository extends JpaRepository<Miniserie, Long> {
}
