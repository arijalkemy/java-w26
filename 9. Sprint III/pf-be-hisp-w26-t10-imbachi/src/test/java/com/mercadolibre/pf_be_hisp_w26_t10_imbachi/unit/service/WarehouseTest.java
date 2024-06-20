package com.mercadolibre.pf_be_hisp_w26_t10_imbachi.unit.service;

import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.dtos.WarehouseDto;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.entity.Rol;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.entity.UserAccount;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.entity.Warehouse;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.exceptions.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.repository.IWarehouseRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.service.implementations.WarehouseServiceImpl;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.util.EntitiesUtilsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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
        assertThrows(NotFoundException.class, () -> warehouseService.findById(1000));

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
        assertEquals(warehouseOptional.get(),warehouse);
    }

    @Test
    public void testGetWhBySupervisorWhenWarehousesFound() {
        Long supervisorId = 1L;
        Warehouse warehouse1 = new Warehouse();
        Warehouse warehouse2 = new Warehouse();
        List<Warehouse> mockWarehouses = List.of(warehouse1, warehouse2);

        when(warehouseRepository.findBySupervisorId(supervisorId)).thenReturn(mockWarehouses);

        List<WarehouseDto> result = warehouseService.getWhBySupervisor(supervisorId);
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(warehouse1.getId(), result.get(0).getWarehouse_id());
        assertEquals(warehouse1.getName(), result.get(0).getName());
        assertEquals(warehouse2.getId(), result.get(1).getWarehouse_id());
        assertEquals(warehouse2.getName(), result.get(1).getName());

        verify(warehouseRepository, times(1)).findBySupervisorId(supervisorId);
    }

    @Test
    public void testGetWhBySupervisorWhenNoWarehousesFound() {
        Long supervisorId = 1L;
        when(warehouseRepository.findBySupervisorId(supervisorId)).thenReturn(Collections.emptyList());
        assertThrows(NotFoundException.class, () -> warehouseService.getWhBySupervisor(supervisorId));

        verify(warehouseRepository, times(1)).findBySupervisorId(supervisorId);
    }

}
