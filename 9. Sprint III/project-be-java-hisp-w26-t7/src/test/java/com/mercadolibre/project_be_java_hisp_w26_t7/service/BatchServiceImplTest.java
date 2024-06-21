package com.mercadolibre.project_be_java_hisp_w26_t7.service;

import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.batch.BatchStockDetailsResponseDTO;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.batch.BatchStockListResponseDTO;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.projection.IBatchesResponseProjection;
import com.mercadolibre.project_be_java_hisp_w26_t7.repository.IBatchRepository;
import com.mercadolibre.project_be_java_hisp_w26_t7.util.enums.OrderEnum;
import com.mercadolibre.project_be_java_hisp_w26_t7.util.enums.StorageTypeEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Clock;
import java.time.LocalDate;
import java.util.List;


@ExtendWith(MockitoExtension.class)
class BatchServiceImplTest {


    @Mock
    IBatchRepository batchRepository;

    Clock clock = Clock.systemDefaultZone();

    private BatchServiceImpl batchService;

    @BeforeEach
    void setUp() {
        batchService = new BatchServiceImpl(batchRepository, clock);
    }


    @Test
    void findBatchesNearExpiryTest() {
        Integer cantDays = 4;
        StorageTypeEnum category = null;
        OrderEnum order = null;
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(cantDays);
        Integer representativeId = 1;
        IBatchesResponseProjection projectionOne = Mockito.mock(IBatchesResponseProjection.class);
        Mockito.when(projectionOne.getBatchNumber()).thenReturn(1);
        Mockito.when(projectionOne.getCurrentQuantity()).thenReturn(2);
        Mockito.when(projectionOne.getDueDate()).thenReturn(endDate);
        Mockito.when(projectionOne.getProductId()).thenReturn(2L);
        Mockito.when(projectionOne.getStorageType()).thenReturn(1L);

        List<IBatchesResponseProjection> listBatchesTest = List.of(projectionOne);


        Mockito.when(batchRepository.findBatchesCloseToExpire(startDate, endDate, representativeId, OrderEnum.DATE_ASC.getSort()))
                .thenReturn(listBatchesTest);
        List<BatchStockDetailsResponseDTO> expectedList = List.of(BatchStockDetailsResponseDTO.builder()
                .batchNumber(1).currentQuantity(2).dueDate(endDate)
                .productId(2).productTypeId(1).build());

        BatchStockListResponseDTO expectedObject = new BatchStockListResponseDTO(expectedList);

        BatchStockListResponseDTO batchTest = batchService.findBatchesNearExpiry(cantDays, category, order, representativeId);
        Assertions.assertEquals(expectedObject, batchTest);
    }

    @Test
    void findBatchesNearExpiryNoOrderTest() {
        Integer cantDays = 4;
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(cantDays);
        Integer representativeId = 1;
        IBatchesResponseProjection projectionOne = Mockito.mock(IBatchesResponseProjection.class);
        Mockito.when(projectionOne.getBatchNumber()).thenReturn(1);
        Mockito.when(projectionOne.getCurrentQuantity()).thenReturn(2);
        Mockito.when(projectionOne.getDueDate()).thenReturn(endDate);
        Mockito.when(projectionOne.getProductId()).thenReturn(2L);
        Mockito.when(projectionOne.getStorageType()).thenReturn(1L);

        List<IBatchesResponseProjection> listBatchesTest = List.of(projectionOne);


        Mockito.when(batchRepository.findBatchesCloseToExpire(startDate, endDate, 1, OrderEnum.DATE_ASC.getSort()))
                .thenReturn(listBatchesTest);
        List<BatchStockDetailsResponseDTO> expectedList = List.of(BatchStockDetailsResponseDTO.builder()
                .batchNumber(1).currentQuantity(2).dueDate(endDate)
                .productId(2).productTypeId(1).build());

        BatchStockListResponseDTO expectedObject = new BatchStockListResponseDTO(expectedList);

        BatchStockListResponseDTO batchTest = batchService.findBatchesNearExpiry(cantDays, null, null, representativeId);
        Assertions.assertEquals(expectedObject, batchTest);
    }

}

