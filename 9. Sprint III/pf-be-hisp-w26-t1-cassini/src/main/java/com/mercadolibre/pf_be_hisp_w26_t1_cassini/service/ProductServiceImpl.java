package com.mercadolibre.pf_be_hisp_w26_t1_cassini.service;

import com.mercadolibre.pf_be_hisp_w26_t1_cassini.dtos.ProductResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.entity.Product;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.enums.ProductCategory;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.exceptions.ApiException;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.repository.IProductRepository;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.service.interfaces.IProductService;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.service.interfaces.IProductServiceInternal;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.util.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService, IProductServiceInternal {

    private final IProductRepository productRepository;

    @Override
    public Product findById(Integer id) {
        return productRepository
                    .findById(id)
                    .orElseThrow(() -> new ApiException("Not Found","No se encontró un producto con id: " + id, 404));
    }

    @Override
    public Boolean exists(Integer id){
        return productRepository
                .existsById(id);
    }
    @Override
    public List<ProductResponseDTO> getAll(){
        List<Product> productList = productRepository.findAll();
        if (productList.isEmpty()) {
            throw new ApiException("Not Found", "No se encontró productos", 404);
        }
        return productList
                .stream()
                .map(ProductMapper::toProductDto)
                .toList();
    }

    @Override
    public List<ProductResponseDTO> getAllByCategory(String category) {
        String productCategory = ProductCategory.getCategory(category);
        List<Product> productListByCategory = productRepository.findAllByCategoryName(productCategory);
        if (productListByCategory.isEmpty()) {
            throw new ApiException("Not Found", "No se encontró productos en la categoria " + category, 404);
        }
        return productListByCategory
                .stream()
                .map(ProductMapper::toProductDto)
                .toList();
    }

    @Override
    public List<Product> findAllProductsInIds(List<Integer> ids){
        List<Product> products = productRepository.findAllByIds(ids);
        if(products.size() != ids.size()){
            throw new ApiException("Not Found","No se encontro uno o mas productos",404);
        }
        return products;
    }



}
