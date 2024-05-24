package com.bootcamp.products.service;

import com.bootcamp.products.dto.ProductDTO;
import com.bootcamp.products.dto.ResponseDTO;

import java.util.List;

public interface IProductService {

    List<ProductDTO> getAlls();

    ProductDTO getById(String id);

    ResponseDTO create(ProductDTO productDTO);

    ResponseDTO update(String id, ProductDTO productDTO);

    void delete(String id);
}
