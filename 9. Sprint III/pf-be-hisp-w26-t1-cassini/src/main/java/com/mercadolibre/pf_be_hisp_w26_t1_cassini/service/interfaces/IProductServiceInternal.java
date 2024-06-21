package com.mercadolibre.pf_be_hisp_w26_t1_cassini.service.interfaces;

import com.mercadolibre.pf_be_hisp_w26_t1_cassini.entity.Product;
import org.springframework.stereotype.Service;

@Service
public interface IProductServiceInternal {

    Product findById(Integer id);


}
