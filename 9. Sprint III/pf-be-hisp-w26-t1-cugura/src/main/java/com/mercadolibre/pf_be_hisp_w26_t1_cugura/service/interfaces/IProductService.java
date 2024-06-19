package com.mercadolibre.pf_be_hisp_w26_t1_cugura.service.interfaces;


import com.mercadolibre.pf_be_hisp_w26_t1_cugura.dtos.ProductDTO;
import com.mercadolibre.pf_be_hisp_w26_t1_cugura.dtos.ProductResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t1_cugura.entity.Product;
import java.util.List;

public interface IProductService {
  
    Product findById(Integer id);
    List<Product> findAllProductsInIds(List<Integer> ids);
    Boolean exists(Integer id);
    List<ProductResponseDTO> getAll();
    List<ProductResponseDTO> getAllByCategory(String category);
    void createProduct(ProductDTO productDTO);
    void createBatchProducts(List<ProductDTO> listOfProducts);
    void deleteProduct(Integer id);
    void modifyProduct(Integer id, ProductDTO productDTO);
}
