package com.example.showroom.repository;

import com.example.showroom.model.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface SalesRepository extends JpaRepository<Sales, Long> {
    List<Sales> findAllByDateEqualsIgnoreCase(LocalDate date);
}
