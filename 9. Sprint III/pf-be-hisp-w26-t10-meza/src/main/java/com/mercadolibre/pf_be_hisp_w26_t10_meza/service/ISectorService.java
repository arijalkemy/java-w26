package com.mercadolibre.pf_be_hisp_w26_t10_meza.service;

import com.mercadolibre.pf_be_hisp_w26_t10_meza.entity.Category;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.entity.Sector;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.entity.Warehouse;

public interface ISectorService {
    Sector searchSectorByCategoryAndWorehouse(Category category, Warehouse warehouse);
}
