package com.bootcamp.joyerialasperlas.repository;

import com.bootcamp.joyerialasperlas.models.Jewel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJewelryRepository  extends JpaRepository<Jewel,Long> {
}
