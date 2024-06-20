package com.mercadolibre.pf_be_hisp_w26_t10_imbachi.unit;

import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.dtos.CheckInventoryResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.dtos.InventoryByWarehouseDto;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.exceptions.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.repository.IProductRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.service.implementations.ProductServiceImpl;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.util.TestGeneratorUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
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

    @Mock
    IProductRepository productRepository;

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
}
