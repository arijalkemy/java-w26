package com.mercadolibre.final_project_java_h_w26_t10.service;
import com.mercadolibre.final_project_java_h_w26_t10.dtos.ProductsGeneralDto;
import com.mercadolibre.final_project_java_h_w26_t10.dtos.CheckInventoryResponseDto;
import com.mercadolibre.final_project_java_h_w26_t10.entity.Product;
import java.util.List;

public interface IProductService {
    CheckInventoryResponseDto getProductWh(Integer idProduct);
    Product findById(Integer id);
    public List<ProductsGeneralDto> getProducts();
    public List<ProductsGeneralDto> findProductsByCategory(String category);
}
