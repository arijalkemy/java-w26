package com.example.ejercicio_lasperlas.repository;

import com.example.ejercicio_lasperlas.model.Jewel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JewelRepository extends JpaRepository<Jewel, Long> { }
