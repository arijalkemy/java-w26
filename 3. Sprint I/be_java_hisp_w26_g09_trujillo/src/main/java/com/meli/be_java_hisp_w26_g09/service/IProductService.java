package com.meli.be_java_hisp_w26_g09.service;


import com.meli.be_java_hisp_w26_g09.dto.ProductDTO;

import java.util.List;

public interface IProductService {
    List<ProductDTO> getAllProducts();
    List<ProductDTO> getProductsByName(String name);


}
