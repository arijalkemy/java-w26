package com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.service;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.dtos.*;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.entity.Product;
import java.util.List;

public interface IProductService {
    CheckInventoryResponseDto getProductWh(Integer idProduct);
    Product findById(Integer id);
    public List<ProductsGeneralDto> getProducts();
    public List<ProductsGeneralDto> findProductsByCategory(String category);
    public ProductUS6Response insertProducts(List<ProductUS6Dto> products, Integer seller_id);
    public ProductUS6Response updateProducts(ProductUS6Dto product, Integer product_id, Integer seller_id);
    public List<ProductDto> findProductByPriceRange(Double lowPriceRange, Double highPriceRange);
    public List<ProductDto> findByKeyword(String keyword);
 }
