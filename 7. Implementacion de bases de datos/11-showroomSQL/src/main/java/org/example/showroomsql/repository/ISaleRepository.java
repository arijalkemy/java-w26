package org.example.showroomsql.repository;

import org.example.showroomsql.model.Clothes;
import org.example.showroomsql.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ISaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> findAllByDate(LocalDate date);
}
