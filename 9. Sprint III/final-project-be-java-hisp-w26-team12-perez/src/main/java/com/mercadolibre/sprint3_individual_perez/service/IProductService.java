package com.mercadolibre.sprint3_individual_perez.service;

import com.mercadolibre.sprint3_individual_perez.dto.request.ProductRequestDTO;
import com.mercadolibre.sprint3_individual_perez.dto.response.ProductResponseDTO;
import com.mercadolibre.sprint3_individual_perez.dto.response.ResponseProductDTO;

import java.util.List;

public interface IProductService {
    ResponseProductDTO selectMethod(String category);
    ProductResponseDTO addProduct(ProductRequestDTO product);
    List<ProductResponseDTO> getProducts();
}
