package com.mercadolibre.pf_be_hisp_w26_t10_meza.service;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.dtos.ProductsGeneralDto;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.dtos.CheckInventoryResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.dtos.product.ProductInfoDto;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.dtos.product.ProductLoadRequestDto;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.dtos.product.ProductLoadResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.entity.Product;
import java.util.List;

public interface IProductService {
    CheckInventoryResponseDto getProductWh(Integer idProduct);
    Product findById(Integer id);
    public List<ProductsGeneralDto> getProducts();
    public List<ProductsGeneralDto> findProductsByCategory(String category);
    ProductLoadResponseDto productRegister(ProductLoadRequestDto productLoadRequestDto, Long idSeller);
    ProductLoadResponseDto updateProduct(ProductInfoDto productInfoDto, Long idSeller, Integer idProduct);
}
