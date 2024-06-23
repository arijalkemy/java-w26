package com.mercadolibre.pf_be_hisp_w26_t01_moises.service.interfaces;

import com.mercadolibre.pf_be_hisp_w26_t01_moises.entity.Product;
import org.springframework.stereotype.Service;

@Service
public interface IProductServiceInternal {

    Product findById(Integer id);


}
