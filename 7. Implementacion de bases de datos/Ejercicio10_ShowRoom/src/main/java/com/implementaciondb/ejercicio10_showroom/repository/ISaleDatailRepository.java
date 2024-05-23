package com.implementaciondb.ejercicio10_showroom.repository;

import com.implementaciondb.ejercicio10_showroom.model.entity.SaleDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISaleDatailRepository extends JpaRepository<SaleDetail, Long> {
}
