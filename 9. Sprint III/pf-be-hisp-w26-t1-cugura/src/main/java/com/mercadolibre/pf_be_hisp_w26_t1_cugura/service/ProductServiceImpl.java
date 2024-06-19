package com.mercadolibre.pf_be_hisp_w26_t1_cugura.service;

import com.mercadolibre.pf_be_hisp_w26_t1_cugura.dtos.ProductDTO;
import com.mercadolibre.pf_be_hisp_w26_t1_cugura.dtos.ProductResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t1_cugura.entity.Category;
import com.mercadolibre.pf_be_hisp_w26_t1_cugura.entity.Product;
import com.mercadolibre.pf_be_hisp_w26_t1_cugura.enums.ProductCategory;
import com.mercadolibre.pf_be_hisp_w26_t1_cugura.exceptions.ApiException;
import com.mercadolibre.pf_be_hisp_w26_t1_cugura.repository.IProductRepository;
import com.mercadolibre.pf_be_hisp_w26_t1_cugura.service.interfaces.ICategoryService;
import com.mercadolibre.pf_be_hisp_w26_t1_cugura.service.interfaces.IProductService;


import com.mercadolibre.pf_be_hisp_w26_t1_cugura.util.ProductMapper;
import com.mercadolibre.pf_be_hisp_w26_t1_cugura.service.interfaces.IProductServiceInternal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService, IProductServiceInternal {

    private final IProductRepository productRepository;
    private final ICategoryService categoryService;

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

    @Override
    public void createProduct(ProductDTO productDTO) {
        Category category = categoryService.searchCategoryById(productDTO.getIdCategory());
        productRepository.save(ProductMapper
            .productMappingFromProductDto(productDTO, category));
    }

    @Override
    public void createBatchProducts(List<ProductDTO> listOfProducts) {
        listOfProducts.forEach(this::createProduct);
    }

    @Override
    public void deleteProduct(Integer id) {
        if(Boolean.FALSE.equals(exists(id))){
            throw new ApiException("Not Found", "El producto a eliminar no existe", 404);
        }
        productRepository.deleteById(id);
    }

    @Override
    public void modifyProduct(Integer id, ProductDTO productDTO) {
        Product product = findById(id);
        Category category = categoryService.searchCategoryById(productDTO.getIdCategory());
        ProductMapper.updateProduct(product,productDTO,category);
        productRepository.save(product);
    }

}
