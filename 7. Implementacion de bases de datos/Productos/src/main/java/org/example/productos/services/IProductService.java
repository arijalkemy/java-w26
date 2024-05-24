package org.example.productos.services;

import org.example.productos.model.DTO.ProductRequestDTO;
import org.example.productos.model.DTO.ProductResponseDTO;

import java.util.List;

public interface IProductService {
    List<ProductResponseDTO> findAll();
    ProductResponseDTO findById(String id);
    ProductResponseDTO createNew(ProductRequestDTO product);
    ProductResponseDTO updateProductById(String id, ProductRequestDTO product);
    String deleteProduct(String id);
    List<ProductResponseDTO> findProductByType(String type);
}
