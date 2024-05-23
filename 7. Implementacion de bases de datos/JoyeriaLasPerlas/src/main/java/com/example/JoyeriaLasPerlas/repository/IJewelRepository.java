package com.example.JoyeriaLasPerlas.repository;

import com.example.JoyeriaLasPerlas.model.Jewel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJewelRepository extends JpaRepository<Jewel, Long> {
}
