package com.mercadolibre.pf_be_hisp_w26_t01_arguello.service.interfaces;


import com.mercadolibre.pf_be_hisp_w26_t01_arguello.dtos.BatchLocationDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.dtos.ProductLocationDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.dtos.ProductResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.entity.Product;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.enums.BatchOrderType;

import java.util.List;
import java.util.Set;

public interface IProductService {
  
    Product findById(Integer id);
    List<Product> findAllProductsInIds(List<Integer> ids);
    Boolean exists(Integer id);
    List<ProductResponseDTO> getAll();
    List<ProductResponseDTO> getAllByCategory(String category);
}
