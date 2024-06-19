package com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.service;

import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.dtos.*;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.entity.Product;

import java.util.List;

public interface IProductService {
    CheckInventoryResponseDto getProductWh(Integer idProduct);

    Product findById(Integer id);

    public List<ProductsGeneralDto> getProducts();

    public List<ProductsGeneralDto> findProductsByCategory(String category);

    ProductCrudResponseDto createProductCrud(ProductListDto productListDto, String idSeller);

    ProductCrudResponseDto changeProduct(String idSeller, Integer idProduct, ProductInfoDto productInfoDto);

    List<AllProductsBySellerDto> getAllProductSellerInfo();

    ProductCrudResponseDto removeProductsBySeller(String idSeller, Integer idProduct);
}
