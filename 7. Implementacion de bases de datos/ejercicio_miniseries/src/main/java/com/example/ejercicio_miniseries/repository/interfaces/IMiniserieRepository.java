package com.example.ejercicio_miniseries.repository.interfaces;

import com.example.ejercicio_miniseries.model.Miniserie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMiniserieRepository extends JpaRepository<Miniserie, Long> { }
