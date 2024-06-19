package com.mercadolibre.sprint3_individual_perez.unit.service;

import com.mercadolibre.sprint3_individual_perez.dto.request.ProductDTO;
import com.mercadolibre.sprint3_individual_perez.dto.response.ResponseProductDTO;
import com.mercadolibre.sprint3_individual_perez.enums.Category;
import com.mercadolibre.sprint3_individual_perez.exceptions.ApiException;
import com.mercadolibre.sprint3_individual_perez.projections.ProductProjection;
import com.mercadolibre.sprint3_individual_perez.repository.IProductRepository;
import com.mercadolibre.sprint3_individual_perez.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    //Mocking Product Repository
    @Mock
    private IProductRepository productRepository;

    //Injecting mocks on ProductService
    @InjectMocks
    private ProductService productService;

    //Creating objects to test
     ResponseProductDTO responseProductDTO;
     List<ProductProjection> productsProjection;

    //Setting up the objects
    @BeforeEach
    void setup(){
        List<ProductDTO>  productsDTO= new ArrayList<>();
        productsDTO.add(new ProductDTO(1000,2));
        productsDTO.add(new ProductDTO(1001,3));
        responseProductDTO = new ResponseProductDTO(productsDTO);
        productsProjection = new ArrayList<>();
        ProductProjection product1 = new ProductProjection() {
            @Override
            public Long getIdProduct() {return 1000L;}
            @Override
            public Integer getQuantity() {return 2;}
        };
        ProductProjection product2 = new ProductProjection() {
            @Override
            public Long getIdProduct() {return 1001L;}
            @Override
            public Integer getQuantity() {return 3;}
        };
        productsProjection.add(product1);
        productsProjection.add(product2);
    }

    /**
     * Test to get all products happy path
     */
    @Test
    void testGetAllProducts(){
        // Arrange
        when(productRepository.findAllProducts()).thenReturn(productsProjection);
        // Act
        ResponseProductDTO actualResponse = productService.getAllProducts();
        // Assert
        Assertions.assertEquals(responseProductDTO, actualResponse);
        Assertions.assertEquals(responseProductDTO.getProductDTOList().size(),
                actualResponse.getProductDTOList().size());
    }

    /**
     * Test to get all products error path
     */
    @Test
    void errorTestGetAllProducts(){
        //Arrange
        List<ProductProjection> productsProjectionError = new ArrayList<>();
        when(productRepository.findAllProducts()).thenReturn(productsProjectionError);
        //Act
        ApiException error= Assertions.assertThrows(ApiException.class,()->{
            productService.getAllProducts();
        });
        //Assert
        Assertions.assertEquals("Not Found",error.getCode());
        Assertions.assertEquals("No products found",error.getMessage());
        Assertions.assertEquals(404,error.getStatusCode());
    }

    /**
     * Test to get products by category happy path
     */
    @Test
    void testGetProductsByCategory(){
        //Arrange
        when(productRepository.findProductsByCategory(Category.FF)).thenReturn(productsProjection);
        //Act
        ResponseProductDTO responseProductDTO1 = productService.getProductsByCategory("FF");
        //Assert
        Assertions.assertEquals(responseProductDTO,responseProductDTO1);
        Assertions.assertEquals(responseProductDTO.getProductDTOList().size()
                ,responseProductDTO1.getProductDTOList().size());
    }

    /**
     * Test to get products by category error path
     * Invalid category
     */
    @Test
    void firstErrorTestGetProductsByCategory(){
        //Act
        ApiException error= Assertions.assertThrows(ApiException.class,()->{
            productService.getProductsByCategory("F");
        });
        //Assert
        Assertions.assertEquals("Not Found",error.getCode());
        Assertions.assertEquals("No products found",error.getMessage());
        Assertions.assertEquals(404,error.getStatusCode());
    }

    /**
     * Test to get products by category error path
     * No products found
     */
    @Test
    void secondErrorTestGetProductsByCategory(){
        //Arrange
        List<ProductProjection> productsProjectionError = new ArrayList<>();
        when(productRepository.findProductsByCategory(Category.FF)).thenReturn(productsProjectionError);
        //Act
        ApiException error= Assertions.assertThrows(ApiException.class,()->{
            productService.getProductsByCategory("FF");
        });
        //Assert
        Assertions.assertEquals("Not Found",error.getCode());
        Assertions.assertEquals("No products found",error.getMessage());
        Assertions.assertEquals(404,error.getStatusCode());
    }

    /**
     * Test to get All products selecting the method with null category
     */
    @Test
    void testSelectMethodWithNullCategory(){
        // Arrange
        when(productRepository.findAllProducts()).thenReturn(productsProjection);
        // Act
        ResponseProductDTO actualResponse = productService.selectMethod(null);
        // Assert
        Assertions.assertEquals(responseProductDTO, actualResponse);
    }

    /**
     * Test to get products selecting the method with valid category
     */
    @Test
    void testSelectMethodWithValidCategory(){
        // Arrange
        when(productRepository.findProductsByCategory(Category.FF)).thenReturn(productsProjection);
        // Act
        ResponseProductDTO actualResponse = productService.selectMethod("FF");
        // Assert
        Assertions.assertEquals(responseProductDTO, actualResponse);
    }
    /**
     * Test the method productProjectionToProductDTO
     * converting a ProductProjection to a ProductDTO
     */
    @Test
    void testProductProjectionToProductDTO(){
        //Arrange
        ProductProjection productProjectionC = new ProductProjection() {
            @Override
            public Long getIdProduct() {
                return 1000L;
            }
            @Override
            public Integer getQuantity() {
                return 2;
            }
        };
        ProductDTO productDTO = new ProductDTO(1000,2);
        //Act
        ProductDTO result = productService.productProjectionToProductDTO(productProjectionC);
        //Assert
        Assertions.assertEquals(productDTO.getIdProduct(),result.getIdProduct());
        Assertions.assertEquals(productDTO.getQuantity(),result.getQuantity());
    }
    /**
     * Test the method productProjectionToProductDTO with null quantity
     */
    @Test
    void testProductProjectionToProductDTONullQuantity(){
        //Arrange
        ProductProjection productProjectionC = new ProductProjection() {
            @Override
            public Long getIdProduct() {
                return 1000L;
            }
            @Override
            public Integer getQuantity() {
                return null;
            }
        };
        //Act
        ProductDTO result = productService.productProjectionToProductDTO(productProjectionC);
        //Assert
        Assertions.assertEquals(1000,result.getIdProduct());
        Assertions.assertEquals(0,result.getQuantity());
    }
}
