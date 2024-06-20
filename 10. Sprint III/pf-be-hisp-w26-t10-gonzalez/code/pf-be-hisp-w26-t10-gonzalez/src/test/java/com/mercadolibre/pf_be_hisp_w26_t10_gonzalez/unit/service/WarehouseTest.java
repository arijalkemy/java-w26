package com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.unit.service;

import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.entity.Warehouse;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.exceptions.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.repository.IWarehouseRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.service.implementations.WarehouseServiceImpl;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.util.EntitiesUtilsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WarehouseTest {

    @Mock
    private IWarehouseRepository warehouseRepository;

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


}
