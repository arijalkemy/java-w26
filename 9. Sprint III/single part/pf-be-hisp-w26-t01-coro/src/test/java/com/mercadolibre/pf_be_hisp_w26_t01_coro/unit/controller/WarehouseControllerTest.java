package com.mercadolibre.pf_be_hisp_w26_t01_coro.unit.controller;


import com.mercadolibre.pf_be_hisp_w26_t01_coro.controller.WarehouseController;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.dtos.ResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.dtos.WarehouseRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.dtos.WarehouseResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.dtos.WarehouseStockResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.service.interfaces.IWarehouseService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WarehouseControllerTest {

    @Mock
    IWarehouseService warehouseService;

    @InjectMocks
    WarehouseController warehouseController;

    @Test
    void GetProductLocationTest(){
        Integer idProduct = 1;

        WarehouseResponseDTO warehouse1 = new WarehouseResponseDTO(1,20);
        WarehouseResponseDTO warehouse2 = new WarehouseResponseDTO(2,30);

        WarehouseStockResponseDTO response = new WarehouseStockResponseDTO();
        response.setProduct_id(1);
        response.setWarehouses(List.of(warehouse1,warehouse2));

        when(warehouseService.findStockWarehouseByProductId(idProduct)).thenReturn(response);


        //Act
        WarehouseStockResponseDTO result = (WarehouseStockResponseDTO) warehouseController.getStockWarehouseByProductId(idProduct).getBody();

        //Asserts

        Assertions.assertEquals(1,result.getProduct_id());
        Assertions.assertEquals(2,result.getWarehouses().size());

    }
    @Test
    void createWarehouse_WhenWarehouseRequestIsValid() {
        WarehouseRequestDTO warehouseRequestDTO = new WarehouseRequestDTO();
        warehouseRequestDTO.setName("Test Warehouse");
        warehouseRequestDTO.setCity("Test City");
        warehouseRequestDTO.setProvince("Test Province");

        ResponseDto response = new ResponseDto("a");


        when(warehouseService.createWarehouse(warehouseRequestDTO)).thenReturn(response);

        ResponseEntity<?> result = warehouseController.createWarehouse(warehouseRequestDTO);

        Assertions.assertEquals(HttpStatus.CREATED, result.getStatusCode());
        Assertions.assertEquals(response, result.getBody());
    }


}
