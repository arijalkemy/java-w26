package com.mercadolibre.pf_be_hisp_w26_t07_torres.service;

import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.batch.BatchStockDTO;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.batch.BatchStockDetailsResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.batch.BatchStockListResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.batch.BatchTemperatureDTO;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.projection.IBatchLowStock;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.projection.IBatchTemperatures;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.projection.IBatchesResponseProjection;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.mapper.BatchTemperatureDifference;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.repository.IBatchRepository;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.util.enums.OrderEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Clock;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.mercadolibre.pf_be_hisp_w26_t07_torres.util.DataUtils.createBatchLowStockProjection;
import static com.mercadolibre.pf_be_hisp_w26_t07_torres.util.DataUtils.createBatchTempProjection;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


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
        int cantDays = 4;
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(cantDays);
        int representativeId = 1;
        IBatchesResponseProjection projectionOne = Mockito.mock(IBatchesResponseProjection.class);
        when(projectionOne.getBatchNumber()).thenReturn(1);
        when(projectionOne.getCurrentQuantity()).thenReturn(2);
        when(projectionOne.getDueDate()).thenReturn(endDate);
        when(projectionOne.getProductId()).thenReturn(2L);
        when(projectionOne.getStorageType()).thenReturn(1L);

        List<IBatchesResponseProjection> listBatchesTest = List.of(projectionOne);


        when(batchRepository.findBatchesCloseToExpire(startDate, endDate, representativeId, OrderEnum.DATE_ASC.getSort()))
                .thenReturn(listBatchesTest);
        List<BatchStockDetailsResponseDTO> expectedList = List.of(BatchStockDetailsResponseDTO.builder()
                .batchNumber(1).currentQuantity(2).dueDate(endDate)
                .productId(2).productTypeId(1).build());

        BatchStockListResponseDTO expectedObject = new BatchStockListResponseDTO(expectedList);

        BatchStockListResponseDTO batchTest = batchService.findBatchesNearExpiry(cantDays, null, null, representativeId);
        Assertions.assertEquals(expectedObject, batchTest);
    }

    @Test
    void findBatchesNearExpiryNoOrderTest() {
        int cantDays = 4;
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(cantDays);
        Integer representativeId = 1;
        IBatchesResponseProjection projectionOne = Mockito.mock(IBatchesResponseProjection.class);
        when(projectionOne.getBatchNumber()).thenReturn(1);
        when(projectionOne.getCurrentQuantity()).thenReturn(2);
        when(projectionOne.getDueDate()).thenReturn(endDate);
        when(projectionOne.getProductId()).thenReturn(2L);
        when(projectionOne.getStorageType()).thenReturn(1L);

        List<IBatchesResponseProjection> listBatchesTest = List.of(projectionOne);


        when(batchRepository.findBatchesCloseToExpire(startDate, endDate, 1, OrderEnum.DATE_ASC.getSort()))
                .thenReturn(listBatchesTest);
        List<BatchStockDetailsResponseDTO> expectedList = List.of(BatchStockDetailsResponseDTO.builder()
                .batchNumber(1).currentQuantity(2).dueDate(endDate)
                .productId(2).productTypeId(1).build());

        BatchStockListResponseDTO expectedObject = new BatchStockListResponseDTO(expectedList);

        BatchStockListResponseDTO batchTest = batchService.findBatchesNearExpiry(cantDays, null, null, representativeId);
        Assertions.assertEquals(expectedObject, batchTest);
    }

    @Test
    @DisplayName("Temperatures: Empty list")
    public void tempDiffTest_EmptyList() {
        // Arrange
        double threshold = 1.5;
        when(batchRepository.findBatchesWithTemperatureDifference(threshold)).thenReturn(new ArrayList<>());
        // Act
        List<BatchTemperatureDTO> response = batchService.getBatchesWithTemperatureDifference();
        // Assert
        assertThat(response).isEmpty();
    }

    @Test
    @DisplayName("Temperatures: List with temperatures differences within batches")
    public void tempDiffTest_OkResponse() {
        // Arrange
        double threshold = 1.5;
        List<IBatchTemperatures> tempList = new ArrayList<>();
        IBatchTemperatures tempOne = createBatchTempProjection(1L, 2L, 2.5, 1);
        IBatchTemperatures tempTwo = createBatchTempProjection(2L, 4L, 7.2, 4);
        tempList.add(tempOne);
        tempList.add(tempTwo);
        when(batchRepository.findBatchesWithTemperatureDifference(threshold)).thenReturn(tempList);
        // Act
        List<BatchTemperatureDTO> response = batchService.getBatchesWithTemperatureDifference();
        // Assert
        assertThat(response).hasSize(2);
    }

    @Test
    @DisplayName("LowStock: Empty list")
    public void lowStockTest_EmptyList() {
        // Arrange
        double threshold = 0.2;
        when(batchRepository.findBatchesWithLowStock(threshold)).thenReturn(new ArrayList<>());
        // Act
        List<BatchStockDTO> response = batchService.getBatchesLowStock();
        // Assert
        assertThat(response).isEmpty();
    }

    @Test
    @DisplayName("LowStock: List with low stock within batches")
    public void lowStockTest_OkResponse() {
        // Arrange
        double threshold = 0.2;
        List<IBatchLowStock> tempList = new ArrayList<>();
        IBatchLowStock tempOne = createBatchLowStockProjection(1L, 2L, 2, 10);
        IBatchLowStock tempTwo = createBatchLowStockProjection(2L, 4L, 7, 40);
        tempList.add(tempOne);
        tempList.add(tempTwo);
        when(batchRepository.findBatchesWithLowStock(threshold)).thenReturn(tempList);
        // Act
        List<BatchStockDTO> response = batchService.getBatchesLowStock();
        // Assert
        assertThat(response).hasSize(2);
    }
}
