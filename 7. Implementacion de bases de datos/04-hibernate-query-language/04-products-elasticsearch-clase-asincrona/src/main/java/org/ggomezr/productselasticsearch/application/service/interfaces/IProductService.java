package org.ggomezr.productselasticsearch.application.service.interfaces;

import org.ggomezr.productselasticsearch.domain.dto.ProductDTO;
import org.ggomezr.productselasticsearch.domain.dto.ResponseDTO;

import java.util.List;

public interface IProductService {
    ProductDTO createProduct(ProductDTO productDTO);
    List<ProductDTO> createProducts(List<ProductDTO> productDTOList);
    List<ProductDTO> getAllProducts();
    ProductDTO getProductById(String id);
    ProductDTO updateProduct(String id, ProductDTO productDTO);
    ResponseDTO deleteProduct(String id);
}
