package com.ejercicio.showroom.repository;

import com.ejercicio.showroom.entities.Sell;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface SellRepository extends JpaRepository<Sell, Integer> {
    List<Sell> findAllByDate(LocalDate date);
}
