package com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.service;

import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.entity.Category;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.entity.Sector;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.entity.Warehouse;

public interface ISectorService {
    Sector searchSectorByCategoryAndWorehouse(Category category, Warehouse warehouse);
}
