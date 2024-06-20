package com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.service;
import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.dtos.ProductsGeneralDto;
import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.dtos.CheckInventoryResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.entity.Product;
import java.util.List;

public interface IProductService {
    CheckInventoryResponseDto getProductWh(Integer idProduct);
    Product findById(Integer id);
    public List<ProductsGeneralDto> getProducts();
    public List<ProductsGeneralDto> findProductsByCategory(String category);
}
