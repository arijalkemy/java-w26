package com.mercadolibre.project_be_java_hisp_w26_t7.repository;

import com.mercadolibre.project_be_java_hisp_w26_t7.entity.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBuyerRepository  extends JpaRepository<Buyer, Long> {
}
