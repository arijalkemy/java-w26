package com.mercadolibre.final_project_java_h_w26_t10.service;

import com.mercadolibre.final_project_java_h_w26_t10.entity.Category;
import com.mercadolibre.final_project_java_h_w26_t10.entity.Sector;
import com.mercadolibre.final_project_java_h_w26_t10.entity.Warehouse;

public interface ISectorService {
    Sector searchSectorByCategoryAndWorehouse(Category category, Warehouse warehouse);
}
