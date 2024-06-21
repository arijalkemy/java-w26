package com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.unit.service;

import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.dtos.ProductsGeneralDto;
import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.entity.Product;
import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.entity.Warehouse;
import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.exceptions.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.repository.IInboundOrderRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.repository.IWarehouseRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.service.implementations.WarehouseServiceImpl;
import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.unit.util.TestUtilGenerator;
import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.util.EntitiesUtilsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WarehouseTest {

    @Mock
    private IWarehouseRepository warehouseRepository;

    @Mock
    private IInboundOrderRepository orderRepository;

    @InjectMocks
    private WarehouseServiceImpl warehouseService;


    @DisplayName("Service warehouse not found")
    @Test
    public void warehouseNotFoundTest() {
        //Arrange
        Optional<Warehouse> warehouseOptional = Optional.empty();
        when(warehouseRepository.findById(1000)).thenReturn(warehouseOptional);

        //Act
        //Assert
        Assertions.assertThrows(NotFoundException.class, () -> warehouseService.findById(1000));

    }

    @DisplayName("Service warehouse")
    @Test
    public void warehouseTest() {

        //Arrange
        Optional<Warehouse> warehouseOptional = Optional.of(EntitiesUtilsTest.warehouse());
        Warehouse warehouse;
        when(warehouseRepository.findById(1)).thenReturn(warehouseOptional);

        //Act

        warehouse = warehouseService.findById(1);

        //Assert
        Assertions.assertEquals(warehouseOptional.get(),warehouse);
    }

    /**
     * Test unitary Case Use 6 - btiene la cantidad de ordenes que ingresaron exitosamente
     * Test Exitoso
     */
    @Test
    @DisplayName("Service: Test CU 6 - Obtiene la cantidad de ordenes que ingresaron exitosamente")
    public void getCantInboundOrderForMonthTestOk(){
        //Arrange
        int idWarehouse = 1;
        double cantInboundOrderExpected = 0.0;
        //Act
        double cantInboundOrderObtained = orderRepository.getCantInboundOrderForMonth(idWarehouse);
        //Assert
        assertEquals(cantInboundOrderExpected,cantInboundOrderObtained);
    }

}
