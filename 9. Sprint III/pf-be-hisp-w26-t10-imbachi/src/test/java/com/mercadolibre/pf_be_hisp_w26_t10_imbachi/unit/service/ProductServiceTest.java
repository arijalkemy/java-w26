package com.mercadolibre.pf_be_hisp_w26_t10_imbachi.unit.service;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.dtos.NewProductDto;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.dtos.ProductsGeneralDto;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.entity.Product;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.exceptions.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.repository.IProductRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.service.implementations.ProductServiceImpl;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.unit.util.TestUtilGenerator;

import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.util.EntitiesUtilsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private IProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;


    @DisplayName("Service product not found")
    @Test
    public void productNotFoundTest() {
        //Arrange
        Optional<Product> productOptional = Optional.empty();
        when(productRepository.findById(1000)).thenReturn(productOptional);

        //Act
        //Assert
        Assertions.assertThrows(NotFoundException.class, () -> productService.findById(1000));

    }

    @DisplayName("Service product")
    @Test
    public void productTest() {
        //Arrange
        Optional<Product> productOptional = Optional.of(EntitiesUtilsTest.mazanaProduct());
        Product product;
        when(productRepository.findById(1000)).thenReturn(productOptional);

        //Act
        product = productService.findById(1000);

        //Assert
        Assertions.assertEquals(productOptional.get(),product);

    }

    /**
     * Test unitary Case Use 2 - Issue Obtener una lista de todos los products por categoria
     * Test Exitoso
     * Test Not found Exception
     */
    @Test
    @DisplayName("Service: Test CU 2 - Obtener una lista de todos los productos registrados exitosamente")
    public void getProductsSuccessfulTest(){
        //Arrange
        List<Product> products = TestUtilGenerator.getProductsExpectedTest();
        List<ProductsGeneralDto> productsExpected = TestUtilGenerator.getProductsDtoExpectedTest();
        //Act
        when(productRepository.findAll()).thenReturn(products);
        List<ProductsGeneralDto> productsObtained = productService.getProducts();
        //Assert
        assertEquals(productsExpected,productsObtained);
    }

    @Test
    @DisplayName("Service: Test CU 2 - Obtener una lista de todos los productos registrados NotFound")
    public void getProductsNotFoundExceptionTest(){
        //Arrange
        List<Product> products = new ArrayList<>();
        //Act
        when(productRepository.findAll()).thenReturn(products);
        //Assert
        assertThrows(NotFoundException.class,
                ()-> productService.getProducts());
    }

    /**
            * Test unitary Case Use 2 - Issue Obtener una lista de todos los products por categoria
     * Test Exitoso
     * Test Not found Exception
     */
    @Test
    @DisplayName("Service: Test CU 2 - Obtener una lista de todos los productos registrados por categoria exitosamente")
    public void getProductsByCategorySuccessfulTest(){
        //Arrange
        String category = "FF";
        List<Product> products = TestUtilGenerator.getProductsByCategoryExpectedTest();
        List<ProductsGeneralDto> productsExpected = TestUtilGenerator.getProductsDtoByCategoryExpectedTest();
        //Act
        when(productRepository.findAllByCategory_Name(category)).thenReturn(products);
        List<ProductsGeneralDto> productsObtained = productService.findProductsByCategory(category);
        //Assert
        assertEquals(productsExpected,productsObtained);
    }

    @Test
    @DisplayName("Service: Test CU 2 - Obtener una lista de todos los productos registrados por categoria NotFound")
    public void getProductsByCategoryNotFoundExceptionTest(){
        //Arrange
        String category = "FFF";
        List<Product> products = new ArrayList<>();
        //Act
        when(productRepository.findAllByCategory_Name(category)).thenReturn(products);
        //Assert
        assertThrows(NotFoundException.class,
                ()-> productService.findProductsByCategory(category));
    }

    @Test
    public void testSaveProductWhenProductDoesNotExist() {
        NewProductDto productDto = new NewProductDto(30, "Test Product", 99.99);
        when(productRepository.findById(productDto.getId())).thenReturn(Optional.empty());
        NewProductDto result = productService.saveProduct(productDto);

        assertNotNull(result);
        assertEquals(productDto.getId(), result.getId());
        assertEquals(productDto.getName(), result.getName());
        assertEquals(productDto.getPrice(), result.getPrice());

        verify(productRepository, times(1)).findById(productDto.getId());
        verify(productRepository, times(1)).save(any());
    }

    @Test
    public void testSaveProductWhenProductExists() {
        NewProductDto existingProductDto = new NewProductDto(1, "Existing Product", 199.99);
        Product existingProduct = new Product();
        existingProduct.setId(1);
        existingProduct.setName(existingProductDto.getName());
        existingProduct.setPrice(existingProductDto.getPrice());

        when(productRepository.findById(existingProductDto.getId())).thenReturn(Optional.of(existingProduct));

        assertThrows(NotFoundException.class, () -> productService.saveProduct(existingProductDto));

        verify(productRepository, times(1)).findById(existingProductDto.getId());
        verify(productRepository, never()).save(any());
    }

}
