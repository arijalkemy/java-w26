package com.example.showroom.repository;

import com.example.showroom.entity.Cloth;
import com.example.showroom.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IClothesRepository extends JpaRepository<Cloth, Long> {
    List<Cloth> findByNameContains(String name);
    List<Cloth> findBySales(Sale sale);

    @Query("SELECT c FROM Cloth c JOIN c.sales s WHERE s.date = :date")
    List<Cloth> findClothesBySaleDate(@Param("date") LocalDate date);
}
