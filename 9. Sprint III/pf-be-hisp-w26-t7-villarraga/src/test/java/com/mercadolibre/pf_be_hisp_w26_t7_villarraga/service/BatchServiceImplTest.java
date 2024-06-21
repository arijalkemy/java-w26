package com.mercadolibre.pf_be_hisp_w26_t7_villarraga.service;

import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.beans.AuthDataUtil;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.batch.BatchStockDetailsResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.batch.BatchStockListResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.batch.SectionAverageTemperature;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.projection.IBatchesResponseProjection;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.repository.IBatchRepository;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.util.enums.OrderEnum;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.util.enums.StorageTypeEnum;
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
import java.util.Optional;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class BatchServiceImplTest {


    @Mock
    private IBatchRepository batchRepository;
    @Mock
    private AuthDataUtil authDataUtil;

    Clock clock = Clock.systemDefaultZone();

    private BatchServiceImpl batchService;

    @BeforeEach
    void setUp() {
        batchService = new BatchServiceImpl(batchRepository, clock, authDataUtil);
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

        BatchStockListResponseDTO batchTest = batchService.findBatchesNearExpiry(cantDays, category, order, representativeId);
        Assertions.assertEquals(expectedObject, batchTest);
    }

    @Test
    public void calculateAverageBySectionId(){
        Long representativeId = 1L;
        Long sectionId = 2L;
        Double result = 3.2;
        SectionAverageTemperature expected = SectionAverageTemperature.builder().averageTemperature(result).build();
        when(authDataUtil.getIdSession()).thenReturn(representativeId);
        when(batchRepository.findAvgTemperatureBySectionId(sectionId, representativeId)).thenReturn(Optional.of(result));
        SectionAverageTemperature actual = batchService.getBatchAverage(sectionId);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findBatchesNearExpiryNoOrderTest() {
        Integer cantDays = 4;
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


}

