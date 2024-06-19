package com.mercadolibre.final_project_java_hisp_w26_t1.service.interfaces;


import com.mercadolibre.final_project_java_hisp_w26_t1.dtos.BatchLocationDTO;
import com.mercadolibre.final_project_java_hisp_w26_t1.dtos.ProductLocationDTO;
import com.mercadolibre.final_project_java_hisp_w26_t1.dtos.ProductResponseDTO;
import com.mercadolibre.final_project_java_hisp_w26_t1.entity.Product;
import com.mercadolibre.final_project_java_hisp_w26_t1.enums.BatchOrderType;

import java.util.List;
import java.util.Set;

public interface IProductService {

    Product findById(Integer id);
    List<Product> findAllProductsInIds(List<Integer> ids);
    Boolean exists(Integer id);
    List<ProductResponseDTO> getAll();
    List<ProductResponseDTO> getAllByCategory(String category);
}
