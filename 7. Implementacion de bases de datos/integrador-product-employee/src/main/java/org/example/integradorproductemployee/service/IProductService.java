package org.example.integradorproductemployee.service;


import org.example.integradorproductemployee.entity.dto.ProductDTO;
import org.example.integradorproductemployee.entity.dto.ProductUtilDTO;

import java.util.List;

public interface IProductService {
    List<ProductUtilDTO> getAllProducts();
    ProductDTO getProductById(String id);
    void createProduct(ProductDTO productDTO);
    void updateProduct(ProductUtilDTO productUtilDTO);
}
