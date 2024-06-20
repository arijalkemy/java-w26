package com.mercadolibre.fresh_market.service;

import com.mercadolibre.fresh_market.dtos.WarehouseDTO;
import com.mercadolibre.fresh_market.model.User;
import com.mercadolibre.fresh_market.model.Warehouse;
import com.mercadolibre.fresh_market.model.enums.Role;
import com.mercadolibre.fresh_market.repository.IWarehouseRepository;
import com.mercadolibre.fresh_market.service.impl.WarehouseServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WarehouseServiceTest {

    @Mock
    private IWarehouseRepository warehouseRepository;

    @InjectMocks
    private WarehouseServiceImpl warehouseService;


    @Test
    public void testGetWarehouseByWarehousemanId() {
        User warehouseman = new User();
        warehouseman.setFirstName("Warehouseman");
        warehouseman.setEmail("warehouseman@test.com");
        warehouseman.setPassword("password");
        warehouseman.setRole(Role.WAREHOUSEMAN);

        Long warehousemanId = 1L;
        Warehouse warehouse = new Warehouse();
        warehouse.setId(1L);
        warehouse.setWarehouseman(warehouseman);

        when(warehouseRepository.findWarehouseByWarehousemanId(warehousemanId)).thenReturn(warehouse);

        // Act
        WarehouseDTO foundWarehouse = warehouseService.getWarehouseByWarehousemanId(warehousemanId);

        // Assert
        assertEquals(warehouse.getId(), foundWarehouse.getId());
    }
}

