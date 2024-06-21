package com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.service;

import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.entity.Category;
import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.entity.Sector;
import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.entity.Warehouse;

public interface ISectorService {
    Sector searchSectorByCategoryAndWorehouse(Category category, Warehouse warehouse);
}
