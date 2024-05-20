package com.bootcamp.joyeriacrud.repository;

import com.bootcamp.joyeriacrud.model.Jewelry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JewelryRepository extends JpaRepository<Jewelry, Long> {
    @Query("SELECT j FROM Jewelry j WHERE j.sellOrNot = true")
    List<Jewelry> findAllSellOrNot();


    @Query("SELECT j FROM Jewelry j WHERE j.sellOrNot = true AND j.id = ?1")
    Optional<Jewelry> findByIdSellOrNot(Long id);
}
