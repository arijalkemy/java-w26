package com.mercadolibre.sprint_3_team_12.unit.service;

import com.mercadolibre.sprint_3_team_12.dto.request.ProductCreationDTO;
import com.mercadolibre.sprint_3_team_12.dto.request.ProductCreationListRequestDTO;
import com.mercadolibre.sprint_3_team_12.dto.request.ProductDTO;
import com.mercadolibre.sprint_3_team_12.dto.response.ProductCreationResponseDTO;
import com.mercadolibre.sprint_3_team_12.dto.response.ResponseProductDTO;
import com.mercadolibre.sprint_3_team_12.entity.Product;
import com.mercadolibre.sprint_3_team_12.entity.UserProduct;
import com.mercadolibre.sprint_3_team_12.enums.Category;
import com.mercadolibre.sprint_3_team_12.exceptions.ApiException;
import com.mercadolibre.sprint_3_team_12.projections.ProductProjection;
import com.mercadolibre.sprint_3_team_12.repository.IProductRepository;
import com.mercadolibre.sprint_3_team_12.repository.IUserProductRepository;
import com.mercadolibre.sprint_3_team_12.repository.IUserRepository;
import com.mercadolibre.sprint_3_team_12.service.ProductService;
import com.mercadolibre.sprint_3_team_12.utils.CustomObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    //Mocking Product Repository
    @Mock
    private IProductRepository productRepository;

    @Mock
    private IUserRepository userRepository;

    @Mock
    private IUserProductRepository userProductRepository;

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

    @Test
    @DisplayName("Test product creation happy path")
    void testProductCreation(){
        //Arrange
        Long idSeller = 1L;
        ProductCreationListRequestDTO inputProducts = CustomObjectMapper.productCreationListRequestDTOGenerator();
        ProductCreationResponseDTO expectedOutput = ProductCreationResponseDTO.builder()
                .operation(1)
                .message("Product created")
                .code(HttpStatus.CREATED.value())
                .build();
        //Mock
        Mockito.when(userRepository.findById(idSeller)).thenReturn(CustomObjectMapper.userGenerator());
        Mockito.when(userProductRepository.findByProductNameAndUserId(inputProducts.getProductCreationDTO().get(0).getName(), idSeller)).thenReturn(null);

        //Act
        ProductCreationResponseDTO actualOutput = productService.postProduct(inputProducts, idSeller);

        //Assert
        Assertions.assertEquals(expectedOutput,actualOutput);
    }

    @Test
    @DisplayName("Test product creation sad path")
    void testProductCreationProductAlreadyInDatabase(){
        //Arrange
        Long idSeller = 1L;
        ProductCreationListRequestDTO inputProducts = CustomObjectMapper.productCreationListRequestDTOGenerator();
        ProductCreationResponseDTO expectedOutput = ProductCreationResponseDTO.builder()
                .operation(1)
                .message("Product created")
                .code(HttpStatus.CREATED.value())
                .build();
        //Mock
        Mockito.when(userRepository.findById(idSeller)).thenReturn(CustomObjectMapper.userGenerator());
        Mockito.when(userProductRepository.findByProductNameAndUserId(inputProducts.getProductCreationDTO().get(0).getName(), idSeller)).thenReturn(UserProduct.builder().id(idSeller).build());

        //Act and assert
        Assertions.assertThrows(ApiException.class, ()-> productService.postProduct(inputProducts, idSeller));
    }

    @Test
    @DisplayName("Test product creation happy path")
    void testProductEdition(){
        //Arrange
        Long idSeller = 1L;
        Long idProduct = 1L;

        ProductCreationDTO inputProducts = CustomObjectMapper.productCreationListRequestDTOGenerator().getProductCreationDTO().get(0);
        ProductCreationResponseDTO expectedOutput = ProductCreationResponseDTO.builder()
                .operation(2)
                .message("Product updated")
                .code(HttpStatus.CREATED.value())
                .build();
        //Mock
        Mockito.when(userRepository.findById(idSeller)).thenReturn(CustomObjectMapper.userGenerator());
        Mockito.when(userProductRepository.findByProductNameAndUserId(inputProducts.getName(), idSeller)).thenReturn(UserProduct.builder().id(idSeller).product(Product.builder().build()).build());
        Mockito.when(productRepository.findById(idProduct)).thenReturn(Optional.of(Product.builder().build()));
        //Act
        ProductCreationResponseDTO productCreationResponseDTO = productService.updateProduct(idProduct, inputProducts,idSeller);

        Assertions.assertEquals(expectedOutput,productCreationResponseDTO);
    }

    @Test
    @DisplayName("Test product creation no product")
    void testProductEditionNoProduct(){
        //Arrange
        Long idSeller = 1L;
        Long idProduct = 1L;

        ProductCreationDTO inputProducts = CustomObjectMapper.productCreationListRequestDTOGenerator().getProductCreationDTO().get(0);
        ProductCreationResponseDTO expectedOutput = ProductCreationResponseDTO.builder()
                .operation(2)
                .message("Product updated")
                .code(HttpStatus.CREATED.value())
                .build();
        //Mock
        Mockito.when(userRepository.findById(idSeller)).thenReturn(CustomObjectMapper.userGenerator());
        Mockito.when(userProductRepository.findByProductNameAndUserId(inputProducts.getName(), idSeller)).thenReturn(null);

        //Act and assert
        Assertions.assertThrows(ApiException.class, ()-> productService.updateProduct(idProduct, inputProducts,idSeller));
    }
}
