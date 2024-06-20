package com.mercadolibre.pf_be_hisp_w26_t10_imbachi.service;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.dtos.NewProductDto;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.dtos.ProductsGeneralDto;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.dtos.CheckInventoryResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.entity.Product;
import java.util.List;

public interface IProductService {
    CheckInventoryResponseDto getProductWh(Integer idProduct);
    Product findById(Integer id);
    public List<ProductsGeneralDto> getProducts();
    public List<ProductsGeneralDto> findProductsByCategory(String category);
    NewProductDto saveProduct(NewProductDto product);
}
