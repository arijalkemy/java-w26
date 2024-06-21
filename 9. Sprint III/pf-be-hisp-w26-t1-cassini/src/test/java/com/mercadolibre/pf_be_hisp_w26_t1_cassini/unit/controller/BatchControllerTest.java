package com.mercadolibre.pf_be_hisp_w26_t1_cassini.unit.controller;


import com.mercadolibre.pf_be_hisp_w26_t1_cassini.Enum.CategoryEnum;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.Enum.OrderTypeEnum;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.authentication.AuthenticationService;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.controller.BatchController;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.dtos.BatchStockDTO;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.dtos.BatchStockResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.dtos.BatchUpdateTemperatureReqDTO;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.dtos.BatchWrongTemperatureRespDTO;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.enums.BatchOrderType;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.service.interfaces.IBatchService;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.utils.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BatchControllerTest {

    @Mock
    private IBatchService batchService;

    @Mock
    private AuthenticationService authenticationService;

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

    @Test
    void GetBatchesWrongTemperatureWithoutOrderTest(){

        //Arrange
        Integer idProduct = 1;
        String managerEmail= "managerWithoutWarehouse@gmail.com";

        when(authenticationService.getLogMail()).thenReturn(managerEmail);

        when(batchService.getBatchesWrongTemperature(idProduct, managerEmail, null))
                .thenReturn(TestUtil.getResponseWrongTemperature());

        //Act
        ResponseEntity<BatchWrongTemperatureRespDTO> result = batchController
                .GetBatchesWrongTemperature(idProduct,null);


        //Assertions
        Assertions.assertEquals(200, result.getStatusCode().value());
    }

    @Test
    @DisplayName("Get product location returns ResponseEntity with status Ok")
    public void getProductLocation_Ok() {
        //arrange
        HttpStatus expected = HttpStatus.OK;
        String mockedEmail = "asd@asd.com";
        when(authenticationService.getLogMail()).thenReturn(mockedEmail);
        //act
        ResponseEntity<?> actual = batchController.getProductLocation(
                1,
                BatchOrderType.C
        );
        //assert
        verify(batchService , atLeast(1))
                .getProductLocation(mockedEmail,1,BatchOrderType.C);
        assertEquals(expected, actual.getStatusCode());
    }

    @Test
    void updateBatchTemperatureTest(){
        String mockedEmail = "asd@asd.com";
        Integer batchId= 1;
        BatchUpdateTemperatureReqDTO updateTemperatureReqDTO= new BatchUpdateTemperatureReqDTO(10.0);


        when(authenticationService.getLogMail()).thenReturn(mockedEmail);
        when(batchService.updateBatchTemperature(batchId,
                updateTemperatureReqDTO,
                mockedEmail)).thenReturn(TestUtil.getBatchResponseDTO());

        //Act
        ResponseEntity<BatchStockDTO> result = batchController
                .updateBatchTemperature(batchId,
                        updateTemperatureReqDTO);


        //Assertions
        Assertions.assertEquals(200, result.getStatusCode().value());
    }
}
