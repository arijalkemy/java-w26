package com.mercadolibre.pf_be_hisp_w26_t01_coro.service.interfaces;


import com.mercadolibre.pf_be_hisp_w26_t01_coro.dtos.BatchLocationDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.dtos.ProductLocationDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.dtos.ProductResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.entity.Product;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.enums.BatchOrderType;

import java.util.List;
import java.util.Set;

public interface IProductService {

    Product findById(Integer id);
    List<Product> findAllProductsInIds(List<Integer> ids);
    Boolean exists(Integer id);
    List<ProductResponseDTO> getAll();
    List<ProductResponseDTO> getAllByCategory(String category);
}
