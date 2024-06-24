package com.mercadolibre.pf_be_hisp_w26_t01_ditta.repository;

import com.mercadolibre.pf_be_hisp_w26_t01_ditta.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category,Integer> {
}
