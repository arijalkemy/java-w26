package com.mercadolibre.pf_be_hisp_w26_t10_garcia.service;

import com.mercadolibre.pf_be_hisp_w26_t10_garcia.entity.Category;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.entity.Sector;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.entity.Warehouse;

public interface ISectorService {
    Sector searchSectorByCategoryAndWorehouse(Category category, Warehouse warehouse);
}
