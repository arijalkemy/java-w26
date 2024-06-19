package com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.unit;

import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.dtos.*;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.entity.Category;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.entity.Product;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.exceptions.ForbiddenException;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.exceptions.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.jwt.JwtService;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.repository.ICategoryRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.repository.IProductRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.repository.IUserAccountRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.repository.IUserRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.service.implementations.ProductServiceImpl;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.util.TestGeneratorUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    IProductRepository productRepository;

    @InjectMocks
    ProductServiceImpl productService;

    @Mock
    IUserAccountRepository userAccountRepository;

    @Mock
    ICategoryRepository categoryRepository;

    @Mock
    IUserRepository repository;

    @Mock
    PasswordEncoder passwordEncoder;

    @Mock
    JwtService jwtService;

    @Test
    @DisplayName("Test us 4 - Validation of service with correct data and successful response.")
    public void CheckInventoryResponseDtoTest() {
        //Arrange
        Integer idProduct = 1;
        List<InventoryByWarehouseDto> inventoryByWarehouseDtos = TestGeneratorUtil.getInvByWh();
        CheckInventoryResponseDto responseDtoExpected = TestGeneratorUtil.getCheckInvResponse();

        //Act
        when(this.productRepository.getWhData(idProduct)).thenReturn(inventoryByWarehouseDtos);
        CheckInventoryResponseDto responseDtoObteined = productService.getProductWh(idProduct);

        //Asserts
        assertEquals(responseDtoExpected, responseDtoObteined);
    }

    @Test
    @DisplayName("Test us 4 - Service validation with non-existent data, and response with exception.")
    public void CheckInventoryResponseDtoTestWithError() {
        //Arrange
        Integer idProduct = 5000;
        List<InventoryByWarehouseDto> inventoryByWarehouseDtos = new ArrayList<>();

        //Act
        when(this.productRepository.getWhData(idProduct)).thenReturn(inventoryByWarehouseDtos);

        //Asserts
        assertThrows(NotFoundException.class, () -> productService.getProductWh(idProduct));

    }

    @Test
    @DisplayName("Test us 6.1 - Create products validation")
    public void createProductCrudTest() {
        //Arrange
        String idSeller = "1";
        String userRole = "SELLER";
        ProductListDto productListDto = TestGeneratorUtil.getProductToSendList();
        Category categoryList = TestGeneratorUtil.getCategoryTest();
        ProductCrudResponseDto productCrudResponseDto = TestGeneratorUtil.getResponseSatisfactory();

        //Act
        when(this.userAccountRepository.validateUserSeller(idSeller)).thenReturn(userRole);
        when(this.productRepository.getMaxProductId()).thenReturn(2);
        when(this.categoryRepository.findById(4)).thenReturn(Optional.of(categoryList));

        ProductCrudResponseDto responseDto = this.productService.createProductCrud(productListDto, idSeller);

        //Asserts
        assertEquals(responseDto, productCrudResponseDto);
    }

    @Test
    @DisplayName("Test us 6.2 - Modify products validation")
    public void changeProductTest() {
        //Arrange
        String idSeller = "1";
        String userRole = "SELLER";
        Integer idProduct = 1;

        //Act
        when(this.userAccountRepository.validateUserSeller(idSeller)).thenReturn(userRole);
        when(this.productRepository.findById(idProduct)).thenReturn(Optional.of(TestGeneratorUtil.productToMod()));

        ProductCrudResponseDto responseDto = this.productService.changeProduct(idSeller, 1, TestGeneratorUtil.productInfoToMod());
        //Asserts
        assertEquals(TestGeneratorUtil.getResponseSatisfactoryToMod(), responseDto);
    }

    @Test
    @DisplayName("Test us 6.3 - Get all products created by seller")
    public void getAllProductSellerInfoTest() {
        //Arrange
        Integer category_id = 4;

        //Act
        when(this.productRepository.getAllProductsBySeller(category_id)).thenReturn(TestGeneratorUtil.getAllProductsBySeller());
        List<AllProductsBySellerDto> allProductsBySellerDtos = this.productService.getAllProductSellerInfo();

        //Asserts
        assertEquals(allProductsBySellerDtos, TestGeneratorUtil.getAllProductsBySeller());
    }

    @Test
    @DisplayName("Test us 6.3 - No products found for seller")
    public void noProductsFoundForSellerTest() {
        // Arrange
        Integer categoryId = 4;
        List<AllProductsBySellerDto> emptyProductsList = Collections.emptyList();

        // Act
        when(productRepository.getAllProductsBySeller(categoryId)).thenReturn(emptyProductsList);

        // Assert
        Assertions.assertThrows(NotFoundException.class, () -> productService.getAllProductSellerInfo());
    }


    @Test
    void testRemoveProductsBySeller_Success() {
        // Arrange
        String idSeller = "seller123";
        Integer idProduct = 1;
        String userRole = "SUPERVISOR";
        Product product = new Product(); // Suponiendo que tienes una clase Product

        when(userAccountRepository.validateUserSeller(idSeller)).thenReturn(userRole);
        when(productRepository.findById(idProduct)).thenReturn(Optional.of(product));

        // Act
        ProductCrudResponseDto response = productService.removeProductsBySeller(idSeller, idProduct);

        // Assert
        assertEquals("Se ha eliminado el registro", response.getMessage());
        assertEquals(202, response.getCode());
    }

    @Test
    void testRemoveProductsBySeller_UserNotSupervisor() {
        // Arrange
        String idSeller = "seller123";
        Integer idProduct = 1;
        String userRole = "USER";

        when(userAccountRepository.validateUserSeller(idSeller)).thenReturn(userRole);

        // Act & Assert
        ForbiddenException exception = assertThrows(ForbiddenException.class, () -> {
            productService.removeProductsBySeller(idSeller, idProduct);
        });

        assertEquals("Este usuario no tiene acceso a esta herrmaienta", exception.getMessage());
    }

    @Test
    void testRemoveProductsBySeller_ProductNotFound() {
        // Arrange
        String idSeller = "seller123";
        Integer idProduct = 1;
        String userRole = "SUPERVISOR";

        when(userAccountRepository.validateUserSeller(idSeller)).thenReturn(userRole);
        when(productRepository.findById(idProduct)).thenReturn(Optional.empty());

        // Act & Assert
        NotFoundException exception = assertThrows(NotFoundException.class, () -> {
            productService.removeProductsBySeller(idSeller, idProduct);
        });

        assertEquals("El producto no se encuentra registrado", exception.getMessage());
    }

}
