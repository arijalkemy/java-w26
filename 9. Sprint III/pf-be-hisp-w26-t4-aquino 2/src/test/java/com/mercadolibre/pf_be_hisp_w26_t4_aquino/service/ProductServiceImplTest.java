package com.mercadolibre.pf_be_hisp_w26_t4_aquino.service;

import com.mercadolibre.pf_be_hisp_w26_t4_aquino.dtos.response.ProductDTO;
import com.mercadolibre.pf_be_hisp_w26_t4_aquino.exceptions.InvalidCategoryException;
import com.mercadolibre.pf_be_hisp_w26_t4_aquino.exceptions.ProductNotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t4_aquino.model.Product;
import com.mercadolibre.pf_be_hisp_w26_t4_aquino.model.ProductType;
import com.mercadolibre.pf_be_hisp_w26_t4_aquino.model.ProductTypeEnum;
import com.mercadolibre.pf_be_hisp_w26_t4_aquino.repository.IProductRepository;
import com.mercadolibre.pf_be_hisp_w26_t4_aquino.repository.IProductTypeRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {
    @Mock
    private IProductRepository productRepository;
    @Mock
    private IProductTypeRepository productTypeRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    @DisplayName("Buscar correctamente productos por categoria FRESCO")
    void searchAllProducts_withCategoryFS() {
        // Arrange
        String category = "FS";
        ProductType productType = new ProductType();
        productType.setDescription(ProductTypeEnum.FRESCO);
        Product product = new Product();
        product.setId(1L);
        product.setDescription("Product 1");
        product.setPrice(100.0);
        product.setProductType(productType);
        List<Product> productList = List.of(product);

        when(productTypeRepository.findByDescription(ProductTypeEnum.FRESCO)).thenReturn(productType);
        when(productRepository.findAllByProductTypeId(productType.getId())).thenReturn(productList);

        // Act
        List<ProductDTO> result = productService.searchAllProducts(category);

        // Assert
        assertEquals(1, result.size());
        assertEquals(product.getId(), result.get(0).getId());
        assertEquals(product.getDescription(), result.get(0).getDescription());
        assertEquals(product.getPrice(), result.get(0).getPrice());
    }

    @Test
    @DisplayName("Buscar correctamente productos por categoria REFRIGERADO")
    void searchAllProducts_withCategoryRF() {
        // Arrange
        String category = "RF";
        ProductType productType = new ProductType();
        productType.setDescription(ProductTypeEnum.REFRIGERADO);
        Product product = new Product();
        product.setId(1L);
        product.setDescription("Product 1");
        product.setPrice(100.0);
        product.setProductType(productType);
        List<Product> productList = List.of(product);

        when(productTypeRepository.findByDescription(ProductTypeEnum.REFRIGERADO)).thenReturn(productType);
        when(productRepository.findAllByProductTypeId(productType.getId())).thenReturn(productList);

        // Act
        List<ProductDTO> result = productService.searchAllProducts(category);

        // Assert
        assertEquals(1, result.size());
        assertEquals(product.getId(), result.get(0).getId());
        assertEquals(product.getDescription(), result.get(0).getDescription());
        assertEquals(product.getPrice(), result.get(0).getPrice());
    }

    @Test
    @DisplayName("Buscar correctamente productos por categoria CONGELADO")
    void searchAllProducts_withCategoryFF() {
        // Arrange
        String category = "FF";
        ProductType productType = new ProductType();
        productType.setDescription(ProductTypeEnum.CONGELADO);
        Product product = new Product();
        product.setId(1L);
        product.setDescription("Product 1");
        product.setPrice(100.0);
        product.setProductType(productType);
        List<Product> productList = List.of(product);

        when(productTypeRepository.findByDescription(ProductTypeEnum.CONGELADO)).thenReturn(productType);
        when(productRepository.findAllByProductTypeId(productType.getId())).thenReturn(productList);

        // Act
        List<ProductDTO> result = productService.searchAllProducts(category);

        // Assert
        assertEquals(1, result.size());
        assertEquals(product.getId(), result.get(0).getId());
        assertEquals(product.getDescription(), result.get(0).getDescription());
        assertEquals(product.getPrice(), result.get(0).getPrice());
    }

    @Test
    @DisplayName("Buscar productos por categoria no encontrada")
    void searchAllProducts_withCategory_noProductsFound() {
        // Arrange
        String category = "FS";
        ProductType productType = new ProductType();
        productType.setDescription(ProductTypeEnum.FRESCO);

        when(productTypeRepository.findByDescription(ProductTypeEnum.FRESCO)).thenReturn(productType);
        when(productRepository.findAllByProductTypeId(productType.getId()))
                .thenThrow(new ProductNotFoundException("The list is empty."));

        // Act & Assert
        assertThrows(ProductNotFoundException.class, () -> productService.searchAllProducts(category));
    }

    @Test
    @DisplayName("Buscar productos por categoria con error en el repositorio")
    void searchAllProducts_withCategory_repositoryError() {
        // Arrange
        String category = "FS";
        ProductType productType = new ProductType();
        productType.setDescription(ProductTypeEnum.FRESCO);

        when(productTypeRepository.findByDescription(ProductTypeEnum.FRESCO)).thenReturn(productType);
        when(productRepository.findAllByProductTypeId(productType.getId()))
                .thenThrow(new RuntimeException("Database error"));

        // Act & Assert
        assertThrows(RuntimeException.class, () -> productService.searchAllProducts(category));
    }

    @Test
    @DisplayName("Buscar todos los productos sin categoria")
    void searchAllProducts_withoutCategory() {
        // Arrange
        Product product = new Product();
        product.setId(1L);
        product.setDescription("Product 1");
        product.setPrice(100.0);
        List<Product> productList = List.of(product);

        when(productRepository.findAll()).thenReturn(productList);

        // Act
        List<ProductDTO> result = productService.searchAllProducts(null);

        // Assert
        assertEquals(1, result.size());
        assertEquals(product.getId(), result.get(0).getId());
        assertEquals(product.getDescription(), result.get(0).getDescription());
        assertEquals(product.getPrice(), result.get(0).getPrice());
    }

    @Test
    @DisplayName("Buscar todos los productos sin categoria no encontrados")
    void searchAllProducts_withoutCategory_noProductsFound() {
        // Arrange
        when(productRepository.findAll()).thenThrow(new ProductNotFoundException("The list is empty."));

        // Act & Assert
        assertThrows(ProductNotFoundException.class, () -> productService.searchAllProducts(null));
    }

    @Test
    @DisplayName("Buscar todos los productos sin categoria con error en el repositorio")
    void searchAllProducts_withoutCategory_repositoryError() {
        // Arrange
        when(productRepository.findAll()).thenThrow(new RuntimeException("Database error"));

        // Act & Assert
        assertThrows(RuntimeException.class, () -> productService.searchAllProducts(null));
    }

    @Test
    @DisplayName("Buscar productos por categoria invalida")
    void searchAllProducts_withInvalidCategory() {
        // Arrange
        String category = "Invalid";

        // Act & Assert
        assertThrows(InvalidCategoryException.class, () -> productService.searchAllProducts(category));
    }

    @Test
    @DisplayName("Buscar productos por categoria con lista vacia")
    void searchAllProducts_withEmptyProductList() {
        // Arrange
        String category = "FS";
        ProductType productType = new ProductType();
        productType.setDescription(ProductTypeEnum.FRESCO);

        when(productTypeRepository.findByDescription(ProductTypeEnum.FRESCO)).thenReturn(productType);
        when(productRepository.findAllByProductTypeId(productType.getId())).thenThrow(new ProductNotFoundException("The list is empty."));

        // Act & Assert
        assertThrows(ProductNotFoundException.class, () -> productService.searchAllProducts(category));
    }
}
