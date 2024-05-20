package com.mercadolibre.joyerialasperlas.repository;

import com.mercadolibre.joyerialasperlas.model.Jewel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJewelRepository extends JpaRepository<Jewel, Long> {
}
