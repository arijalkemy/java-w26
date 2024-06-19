package com.mercadolibre.final_project_java_hisp_w26_t1.repository;

import com.mercadolibre.final_project_java_hisp_w26_t1.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category,Integer> {
}
