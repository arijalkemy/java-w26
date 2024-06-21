package com.mercadolibre.pf_be_hisp_w26_t1_cassini.unit.service;


import com.mercadolibre.pf_be_hisp_w26_t1_cassini.dtos.WarehouseResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.dtos.WarehouseStockResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.entity.Batch;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.entity.Warehouse;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.exceptions.ApiException;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.repository.IWarehouseRepository;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.service.WarehouseServiceImpl;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.service.interfaces.IBatchServiceInternal;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.service.interfaces.IProductServiceInternal;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.utils.TestUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WarehouseServiceImplTest {

    @Mock
    private IWarehouseRepository warehouseRepository;

    @Mock
    private IBatchServiceInternal batchServiceInternal;

    @Mock
    private IProductServiceInternal productServiceInternal;

    @InjectMocks
    private WarehouseServiceImpl warehouseService;

    @Test
    void findWarehouseById_Ok(){
        Warehouse w = new Warehouse();
        w.setId(1);

        when(warehouseRepository.findById(anyInt())).thenReturn(Optional.of(w));

        //act
        Warehouse result = warehouseService.findWarehouseById(1);

        //Assertions
        Assertions.assertEquals(1,result.getId());
    }

    @Test
    void findWarehouseById_NotFound(){

        when(warehouseRepository.findById(anyInt())).thenReturn(Optional.empty());


        //Assertions
        Assertions.assertThrows(ApiException.class, () -> warehouseService.findWarehouseById(1));
    }

    @Test
    void FindAllWarehouses_Ok(){

        List<Warehouse> allWarehouses = TestUtil.getTwoWarehouses();
        when(warehouseRepository.findAll()).thenReturn(allWarehouses);

        //Act
        List<Warehouse> result = warehouseService.findAllWarehouses();

        //Assertions
        Assertions.assertEquals(2,result.size());

    }

    @Test
    void FindAllWarehouses_NotFound(){

        when(warehouseRepository.findAll()).thenReturn(List.of());


        //Assertions
        Assertions.assertThrows(ApiException.class, () -> warehouseService.findAllWarehouses());

    }

    @Test
    public void findStockWarehouseByProductIdTest(){
        Integer productId=1;
        List<Warehouse> warehousesResult= TestUtil.getTwoWarehouses();
        List<Batch> batchesResult= TestUtil.getBatchList();

        WarehouseResponseDTO warehouseResponseDTO1= WarehouseResponseDTO.builder().warehouse_code(1)
                .total_quantity(100)
                .build();
        WarehouseResponseDTO warehouseResponseDTO2= WarehouseResponseDTO.builder().warehouse_code(2)
                .total_quantity(0)
                .build();

        List<WarehouseResponseDTO> warehouseResponseDTOListExpected= new ArrayList<>();
        warehouseResponseDTOListExpected.add(warehouseResponseDTO1);
        warehouseResponseDTOListExpected.add(warehouseResponseDTO2);

        WarehouseStockResponseDTO warehouseStockResponseDTOExpected= WarehouseStockResponseDTO.builder()
                        .product_id(productId)
                                .warehouses(warehouseResponseDTOListExpected)
                                        .build();

        when(productServiceInternal.findById(productId)).thenReturn(TestUtil.getbananaProduct());
        when(warehouseRepository.findAll()).thenReturn(warehousesResult);
        when(batchServiceInternal.findAllByProductIdAndQuantityGreatherThanCero(productId)).thenReturn(batchesResult);


        WarehouseStockResponseDTO warehouseStockResponseDTOResult= warehouseService.findStockWarehouseByProductId(productId);

        for (int i = 0; i < warehouseStockResponseDTOResult.getWarehouses().size(); i++) {
            Assertions.assertEquals(warehouseStockResponseDTOExpected.getWarehouses().get(i).getWarehouse_code(),
                    warehouseStockResponseDTOResult.getWarehouses().get(i).getWarehouse_code());
            Assertions.assertEquals(warehouseStockResponseDTOExpected.getWarehouses().get(i).getTotal_quantity(),
                    warehouseStockResponseDTOResult.getWarehouses().get(i).getTotal_quantity());
        }




    }



}
