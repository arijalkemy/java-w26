package com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.unit.service;

import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.repository.IShoppingCartRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.service.implementations.ShoppingCartServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
@ExtendWith(MockitoExtension.class)
public class ShoppingCartServiceTest {

    @Mock
    IShoppingCartRepository shoppingCartRepository;

    @InjectMocks
    ShoppingCartServiceImpl shoppingCartService;

    /**
     * Test unitary Case Use 6 - btiene la cantidad de ordenes que ingresaron exitosamente
     * Test Exitoso
     */
    @Test
    @DisplayName("Service: Test CU 6 - Obtiene la cantidad de ordenes que ingresaron exitosamente")
    public void getTotalSalesForMonthTestOk(){
        //Arrange
        int idWarehouse = 1;
        double collectedTotalExpected = 0.0;
        //Act
        double collectedTotalObtained = shoppingCartService.getTotalSalesForMonth(idWarehouse);
        //Assert
        assertEquals(collectedTotalExpected,collectedTotalObtained);
    }
}
