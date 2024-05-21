package com.example.joyerialasperlas.repository;

import com.example.joyerialasperlas.entity.Jewelry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JewelryRepository extends JpaRepository<Jewelry, Long> {

}
