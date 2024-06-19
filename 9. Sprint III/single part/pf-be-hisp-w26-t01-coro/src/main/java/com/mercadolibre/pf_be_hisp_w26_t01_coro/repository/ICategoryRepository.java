package com.mercadolibre.pf_be_hisp_w26_t01_coro.repository;

import com.mercadolibre.pf_be_hisp_w26_t01_coro.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category,Integer> {
}
