package com.showroom.showroom.repository;

import com.showroom.showroom.model.Sale;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SalesRepository extends CrudRepository<Sale, Long> {

    List<Sale> findAll();
    Sale findSaleById(Long id);
    Sale findSaleByDate(LocalDate date);
}
