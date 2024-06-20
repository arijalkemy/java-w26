package com.mercadolibre.pf_be_hisp_w26_t10_meza.unit;

import com.mercadolibre.pf_be_hisp_w26_t10_meza.dtos.CheckInventoryResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.dtos.InventoryByWarehouseDto;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.dtos.product.ProductInfoDto;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.dtos.product.ProductLoadRequestDto;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.dtos.product.ProductLoadResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.entity.Category;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.entity.Product;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.entity.Rol;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.entity.UserAccount;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.exceptions.NoAccessException;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.exceptions.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.repository.ICategoryRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.repository.IProductRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.repository.IUserAccountRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.service.implementations.ProductServiceImpl;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.util.TestGeneratorUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    IProductRepository productRepository;

    @Mock
    IUserAccountRepository userAccountRepository;

    @Mock
    ICategoryRepository categoryRepository;

    @InjectMocks
    ProductServiceImpl productService;

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
        Assertions.assertEquals(responseDtoExpected, responseDtoObteined);
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
        Assertions.assertThrows(NotFoundException.class, () -> productService.getProductWh(idProduct));

    }

    @Test
    @DisplayName(" Test US 6 - Product registration successfully")
    public void productsRegistrationSuccessfully() {

        //Arrange
        List<ProductInfoDto> myList = Arrays.asList( new ProductInfoDto(2, "Pizzas", 19.99));
        ProductLoadRequestDto productLoadRequestDto = new ProductLoadRequestDto();
        productLoadRequestDto.setProductInfoDtoList(myList);

        Long idSeller = 7L;
        ProductLoadResponseDto productLoadResponseDto = new ProductLoadResponseDto();

        productLoadResponseDto.setOperation(901);
        productLoadResponseDto.setMessage("Products register successfully");
        productLoadResponseDto.setCode(201);

        //Act

        UserAccount userAccount = new UserAccount();
        userAccount.setUserRole(Rol.SELLER);
        Optional<UserAccount> posibleUser = Optional.of(userAccount);

        when(userAccountRepository.findById(idSeller)).thenReturn(posibleUser);

        for (ProductInfoDto p: productLoadRequestDto.getProductInfoDtoList()) {
            Optional<Category> posibleCategory = Optional.of(new Category());

            when(categoryRepository.findById(p.getProductCategory())).thenReturn(posibleCategory);

        }

        for (ProductInfoDto p: productLoadRequestDto.getProductInfoDtoList()) {
            Optional<Category> posibleCategory = Optional.of(new Category());
            when(categoryRepository.findById(p.getProductCategory())).thenReturn(posibleCategory);

        }

        ProductLoadResponseDto responseObtained = productService.productRegister(productLoadRequestDto, idSeller);

        Assertions.assertEquals(productLoadResponseDto, responseObtained);

    }

    @Test
    @DisplayName(" Test US 6 - NotFoundException thrown because of no existing user")
    public void noExistingUser() {

        //Arrange
        ProductLoadRequestDto productLoadRequestDto = new ProductLoadRequestDto();

        Long idSeller = 7L;

        //Act

        UserAccount userAccount = new UserAccount();
        userAccount.setUserRole(Rol.SELLER);
        Optional<UserAccount> posibleUser = Optional.empty();

        when(userAccountRepository.findById(idSeller)).thenReturn(posibleUser);

        Assertions.assertThrows(NotFoundException.class, () -> productService.productRegister(productLoadRequestDto, idSeller));

    }

    @Test
    @DisplayName(" Test US 6 - NoAccessException thrown because the user is not a seller")
    public void rolUserIncorrect() {

        //Arrange
        ProductLoadRequestDto productLoadRequestDto = new ProductLoadRequestDto();

        Long idSeller = 7L;

        //Act

        UserAccount userAccount = new UserAccount();
        userAccount.setUserRole(Rol.BUYER);
        Optional<UserAccount> posibleUser = Optional.of(userAccount);

        when(userAccountRepository.findById(idSeller)).thenReturn(posibleUser);

        Assertions.assertThrows(NoAccessException.class, () -> productService.productRegister(productLoadRequestDto, idSeller));

    }

    @Test
    @DisplayName(" Test US 6 - NotFoundException thrown because the category id no exist")
    public void categoryIdDoesNotExist() {

        //Arrange
        List<ProductInfoDto> myList = Arrays.asList( new ProductInfoDto(2, "Pizzas", 19.99));
        ProductLoadRequestDto productLoadRequestDto = new ProductLoadRequestDto();
        productLoadRequestDto.setProductInfoDtoList(myList);


        Long idSeller = 7L;

        //Act

        UserAccount userAccount = new UserAccount();
        userAccount.setUserRole(Rol.SELLER);
        Optional<UserAccount> posibleUser = Optional.of(userAccount);

        when(userAccountRepository.findById(idSeller)).thenReturn(posibleUser);


        Optional<Category> posibleCategory = Optional.empty();

        when(categoryRepository.findById(anyInt())).thenReturn(posibleCategory);

        Assertions.assertThrows(NotFoundException.class, () -> productService.productRegister(productLoadRequestDto, idSeller));

    }
    @Test
    @DisplayName(" Test US 6 - Product update successfully")
    public void updateProductSuccessfully() {

        //Arrange
        ProductInfoDto myList =  new ProductInfoDto(2, "Pizzas", 19.99);

        Long idSeller = 7L;
        Integer idProduct = 12;

        ProductLoadResponseDto productLoadResponseDto = new ProductLoadResponseDto();

        productLoadResponseDto.setOperation(1001);
        productLoadResponseDto.setMessage("Products updated successfully");
        productLoadResponseDto.setCode(201);

        //Act

        UserAccount userAccount = new UserAccount();
        userAccount.setUserRole(Rol.SELLER);
        Optional<UserAccount> posibleUser = Optional.of(userAccount);

        when(userAccountRepository.findById(idSeller)).thenReturn(posibleUser);

        Optional<Product> posibleProduct = Optional.of(new Product());
        when(productRepository.findById(idProduct)).thenReturn(posibleProduct);

        Optional<Category> posibleCategory = Optional.of(new Category());

        when(categoryRepository.findById(myList.getProductCategory())).thenReturn(posibleCategory);


        when(categoryRepository.findById(myList.getProductCategory())).thenReturn(posibleCategory);


        ProductLoadResponseDto responseObtained = productService.updateProduct(myList, idSeller, idProduct);

        Assertions.assertEquals(productLoadResponseDto, responseObtained);

    }

    @Test
    @DisplayName(" Test US 6 - NotFoundException thrown because of no existing product")
    public void noExistingProduct() {

        //Arrange
        ProductInfoDto myList =  new ProductInfoDto(2, "Pizzas", 19.99);

        Long idSeller = 7L;
        Integer idProduct = 12;
        //Act

        UserAccount userAccount = new UserAccount();
        userAccount.setUserRole(Rol.SELLER);
        Optional<UserAccount> posibleUser = Optional.of(userAccount);

        when(userAccountRepository.findById(idSeller)).thenReturn(posibleUser);

        Optional<Product> product = Optional.empty();

        when(productRepository.findById(idProduct)).thenReturn(product);

        Assertions.assertThrows(NotFoundException.class, () -> productService.updateProduct(myList, idSeller, idProduct));

    }

}
