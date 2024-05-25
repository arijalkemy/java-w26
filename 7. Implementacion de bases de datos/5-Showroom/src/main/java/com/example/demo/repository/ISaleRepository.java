package com.example.demo.repository;

import com.example.demo.model.entity.Clothes;
import com.example.demo.model.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ISaleRepository extends JpaRepository<Sale,Long> {

    @Query("SELECT s.clothesList FROM Sale s WHERE s.date = :date")
    List<Clothes> findAllClothesBySaleDate(@Param("date") LocalDate date);

    @Query("SELECT s.clothesList FROM Sale s WHERE s.id = :saleId")
    List<Clothes> findAllClothesBySale(@Param("saleId") Long saleId);

}
