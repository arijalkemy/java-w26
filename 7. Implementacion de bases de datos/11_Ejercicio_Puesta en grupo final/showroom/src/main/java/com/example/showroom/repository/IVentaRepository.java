package com.example.showroom.repository;

import com.example.showroom.entity.Prenda;
import com.example.showroom.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IVentaRepository extends JpaRepository<Venta, Long> {
    @Query("SELECT p " +
            "FROM Venta s JOIN s.prendas p " +
            "WHERE s.fecha = :date")
    List<Prenda> findAllPrendasByDate(@Param("date") LocalDate date);

    @Query("SELECT p " +
            "FROM Venta s JOIN s.prendas p " +
            "WHERE s.numero = :number")
    List<Prenda> findAllPrendasBySale(@Param("number") Long number);
}
