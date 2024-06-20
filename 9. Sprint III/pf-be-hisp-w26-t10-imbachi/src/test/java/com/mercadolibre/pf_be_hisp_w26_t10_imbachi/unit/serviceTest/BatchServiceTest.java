package com.mercadolibre.pf_be_hisp_w26_t10_imbachi.unit.serviceTest;

import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.dtos.BatchesCloseToExpireDto;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.entity.Batch;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.entity.InboundOrder;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.entity.Product;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.entity.Sector;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.exceptions.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.repository.IBatchRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.service.implementations.BatchServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BatchServiceTest {

    @Mock
    IBatchRepository batchRepository;

    @InjectMocks
    BatchServiceImpl batchService;

    private static Batch testBatch;

    @BeforeAll
    public static void setUpBatches(){
        testBatch = new Batch();
        testBatch.setBatchNumber(12345);
        testBatch.setProduct(new Product());
        testBatch.setSector(new Sector());
        testBatch.setInbound(new InboundOrder());
        testBatch.setInitialQuantity(200);
        testBatch.setCurrentQuantity(150);
        testBatch.setCurrentTemperature(20.0);
        testBatch.setMinimumTemperature(15.0);
        testBatch.setManufacturingDate(LocalDate.of(2024,05,20));
        testBatch.setManufacturingTime(LocalTime.now());
        testBatch.setDueDate(LocalDate.of(2024,06,18));
    }

    @Test
    @DisplayName("Test - Get correct information")
    public void getBatchExpiringInDays(){
        //Act&&Arrange
        List<Batch> expectedResponse = List.of(testBatch);
        when(batchRepository.findByDueDateBetween(LocalDate.now(), LocalDate.now().plusDays(50))).thenReturn(expectedResponse);
        List<BatchesCloseToExpireDto> responseBatch = batchService.getBatchesExpiringInDays(50);
        //Assert
        assertNotNull(responseBatch);
    }

    @Test
    @DisplayName("Test - Get NotFoundException")
    public void testGetBatchesExpiringInDaysEmptyResult() {
        Integer days = 5;
        LocalDate actualDate = LocalDate.now();
        LocalDate limitDate = actualDate.plusDays(days);

        when(batchRepository.findByDueDateBetween(actualDate, limitDate)).thenReturn(new ArrayList<>());

        try {
            batchService.getBatchesExpiringInDays(days);
        } catch (NotFoundException e) {
            assert(e.getMessage().contains("No hay lotes que expiren en los proximos"));
        }

        verify(batchRepository, times(1)).findByDueDateBetween(actualDate, limitDate);
    }

    @Test
    @DisplayName("Test - Get Batches in Asc Order")
    public void testFindBatchesByDueDateAndCategory_AscOrder() {
        LocalDate actualDate = LocalDate.now();
        LocalDate limitDate = actualDate.plusDays(10);

        when(batchRepository.findBatchesByDueDateAndCategoryAsc(actualDate, limitDate, "FF")).thenReturn(Arrays.asList(testBatch));

        List<BatchesCloseToExpireDto> result = batchService.findBatchesByDueDateAndCategory(10, "FF", "ASC");

        assertEquals(1, result.size());
        assertEquals(12345, result.get(0).getBatch_number());
    }

    @Test
    @DisplayName("Test - Get Batches in Desc Order")
    public void testFindBatchesByDueDateAndCategory_DescOrder() {
        LocalDate actualDate = LocalDate.now();
        LocalDate limitDate = actualDate.plusDays(10);

        when(batchRepository.findBatchesByDueDateAndCategoryDesc(actualDate, limitDate, "FR")).thenReturn(Arrays.asList(testBatch));

        List<BatchesCloseToExpireDto> result = batchService.findBatchesByDueDateAndCategory(10, "FR", "DESC");

        assertEquals(1, result.size());
        assertEquals(12345, result.get(0).getBatch_number());
}

    @Test
    @DisplayName("Test - Get Batches with low quantity")
    public void testGetLowQuantityBatchWithBatchesFound() {

        List<Batch> mockBatches = Arrays.asList(testBatch);

        // Mock repository behavior
        when(batchRepository.findByCurrentQuantityIsLessThanEqual(anyInt())).thenReturn(mockBatches);

        // Call the service method
        List<BatchesCloseToExpireDto> result = batchService.getLowQuantityBatch(10);

        // Verify the result
        assertNotNull(result);
        assertEquals(1, result.size());

        // Verify mappings (assuming you have a method mapBatchesToDto)
        // Here you would ideally have more specific assertions based on your DTO structure
        verify(batchRepository, times(1)).findByCurrentQuantityIsLessThanEqual(10);
    }

    @Test
    @DisplayName("Test - Get No Batches with Low Quantities ")
    public void testGetLowQuantityBatchWithNoBatchesFound() {
        // Mock repository behavior for no batches found
        when(batchRepository.findByCurrentQuantityIsLessThanEqual(anyInt())).thenReturn(Collections.emptyList());

        // Call the service method and expect NotFoundException
        assertThrows(NotFoundException.class, () -> batchService.getLowQuantityBatch(10));

        // Verify that the repository method was called once
        verify(batchRepository, times(1)).findByCurrentQuantityIsLessThanEqual(10);
    }
}
