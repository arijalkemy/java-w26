package com.mercadolibre.pf_be_hisp_w26_t1_cassini.repository;


import com.mercadolibre.pf_be_hisp_w26_t1_cassini.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category,Integer> {
}
