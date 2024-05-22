package com.mercadolibre.clothes.repository;

import com.mercadolibre.clothes.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ISalesRepository extends JpaRepository<Sale, Long> {
    List<Sale> findSalesByDateEquals(LocalDate date);
}
