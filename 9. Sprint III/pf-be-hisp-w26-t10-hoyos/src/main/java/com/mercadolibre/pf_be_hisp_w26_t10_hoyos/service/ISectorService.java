package com.mercadolibre.pf_be_hisp_w26_t10_hoyos.service;


import com.mercadolibre.pf_be_hisp_w26_t10_hoyos.entity.Category;
import com.mercadolibre.pf_be_hisp_w26_t10_hoyos.entity.Sector;
import com.mercadolibre.pf_be_hisp_w26_t10_hoyos.entity.Warehouse;

public interface ISectorService {
    Sector searchSectorByCategoryAndWorehouse(Category category, Warehouse warehouse);
}
