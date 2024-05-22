package com.example.ejerciciocrudconjpa.repository;

import com.example.ejerciciocrudconjpa.model.Jewel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJewelRepository extends JpaRepository<Jewel, Integer> {
}
