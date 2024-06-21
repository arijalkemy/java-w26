package com.mercadolibre.pf_be_hisp_w26_t1_cassini.unit.controller;


import com.mercadolibre.pf_be_hisp_w26_t1_cassini.controller.WarehouseController;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.dtos.WarehouseResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.dtos.WarehouseStockResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.service.interfaces.IWarehouseService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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


}
