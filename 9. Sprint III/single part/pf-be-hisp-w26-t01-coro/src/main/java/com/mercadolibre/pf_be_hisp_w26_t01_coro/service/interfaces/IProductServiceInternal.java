package com.mercadolibre.pf_be_hisp_w26_t01_coro.service.interfaces;

import com.mercadolibre.pf_be_hisp_w26_t01_coro.entity.Product;
import org.springframework.stereotype.Service;

@Service
public interface IProductServiceInternal {

    Product findById(Integer id);


}
