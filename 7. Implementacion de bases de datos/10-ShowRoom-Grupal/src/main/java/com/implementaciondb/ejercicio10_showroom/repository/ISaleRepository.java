package com.implementaciondb.ejercicio10_showroom.repository;

import com.implementaciondb.ejercicio10_showroom.model.entity.Garment;
import com.implementaciondb.ejercicio10_showroom.model.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ISaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT sd.garment " +
            "FROM Sale s JOIN s.saleDetails sd " +
            "WHERE s.date = :date")
    List<Garment> findAllClothesByDate(@Param("date") LocalDate date);

    @Query("SELECT sd.garment " +
            "FROM Sale s JOIN s.saleDetails sd " +
            "WHERE s.number = :number")
    List<Garment> findAllClothesBySale(@Param("number") Long number);

}
