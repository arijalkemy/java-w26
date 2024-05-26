package com.example.joyerialasperlas.repository;

import com.example.joyerialasperlas.model.Jewelry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJewelryRepository extends JpaRepository<Jewelry, Long> {
}
