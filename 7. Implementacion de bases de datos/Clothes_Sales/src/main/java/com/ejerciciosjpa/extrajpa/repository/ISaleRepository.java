package com.ejerciciosjpa.extrajpa.repository;

import com.ejerciciosjpa.extrajpa.entities.Cloth;
import com.ejerciciosjpa.extrajpa.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ISaleRepository extends JpaRepository<Sale,Long> {
    List<Sale> findAll();
    Sale findByNumero(Long numero);
    List<Sale> findSalesByFechaEquals(LocalDate date);
    List<Cloth> findSalesByClothesAndNumero(Long Number);
}
