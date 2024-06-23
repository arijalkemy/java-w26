package com.mercadolibre.pf_be_hisp_w26_t01_moises.service.interfaces;


import com.mercadolibre.pf_be_hisp_w26_t01_moises.dtos.ProductResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.entity.Product;

import java.util.List;

public interface IProductService {
  
    Product findById(Integer id);
    List<Product> findAllProductsInIds(List<Integer> ids);
    Boolean exists(Integer id);
    List<ProductResponseDTO> getAll();
    List<ProductResponseDTO> getAllByCategory(String category);
}
