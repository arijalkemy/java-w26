package com.mercadolibre.pf_be_hisp_w26_t10_imbachi.service;

import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.entity.Category;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.entity.Sector;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.entity.Warehouse;

public interface ISectorService {
    Sector searchSectorByCategoryAndWorehouse(Category category, Warehouse warehouse);
}
