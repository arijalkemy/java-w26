package com.mercadolibre.final_project_java_hisp_w26_t1.unit.controller;


import com.mercadolibre.final_project_java_hisp_w26_t1.Enum.CategoryEnum;
import com.mercadolibre.final_project_java_hisp_w26_t1.Enum.OrderTypeEnum;
import com.mercadolibre.final_project_java_hisp_w26_t1.controller.BatchController;
import com.mercadolibre.final_project_java_hisp_w26_t1.dtos.BatchStockDTO;
import com.mercadolibre.final_project_java_hisp_w26_t1.dtos.BatchStockResponseDTO;
import com.mercadolibre.final_project_java_hisp_w26_t1.service.interfaces.IBatchService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BatchControllerTest {

    @Mock
    private IBatchService batchService;

    @InjectMocks
    BatchController batchController;

    @Test
    void GetProductCloseToExpiration(){

        //Arrange
        Integer cantDays = 10;

        BatchStockDTO batchStockDTO = new BatchStockDTO();
        batchStockDTO.setBatch_number(1);
        batchStockDTO.setProduct_id(1);
        batchStockDTO.setDue_date(LocalDate.of(2024, 2, 15));
        batchStockDTO.setInitial_quantity(10);
        batchStockDTO.setCurrent_temperature(20.0);

        BatchStockResponseDTO batchStockResponseDTO = new BatchStockResponseDTO();
        batchStockResponseDTO.setBatch_stock(List.of(batchStockDTO));

        when(batchService.getBatchesCloseToExpiration(cantDays, CategoryEnum.FF, OrderTypeEnum.date_asc))
                .thenReturn(batchStockResponseDTO);

        //Act
        ResponseEntity<BatchStockResponseDTO> result = batchController
                .GetProductCloseToExpiration(cantDays, CategoryEnum.FF, OrderTypeEnum.date_asc);

        //Assertions
        Assertions.assertEquals(200, result.getStatusCode().value());
    }
}
