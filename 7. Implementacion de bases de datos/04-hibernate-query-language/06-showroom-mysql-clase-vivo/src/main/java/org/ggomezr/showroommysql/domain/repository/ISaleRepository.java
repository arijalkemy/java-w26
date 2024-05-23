package org.ggomezr.showroommysql.domain.repository;

import org.ggomezr.showroommysql.domain.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ISaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> findByDate(LocalDate date);
    List<Sale> findByCode(Long code);
}
