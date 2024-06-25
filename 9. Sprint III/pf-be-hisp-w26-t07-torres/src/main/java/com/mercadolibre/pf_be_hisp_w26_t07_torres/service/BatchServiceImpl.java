package com.mercadolibre.pf_be_hisp_w26_t07_torres.service;

import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.batch.BatchStockDTO;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.batch.BatchStockDetailsResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.batch.BatchStockListResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.batch.BatchTemperatureDTO;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.projection.IBatchLowStock;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.projection.IBatchTemperatures;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.mapper.BatchLowStock;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.mapper.BatchStockDetailsMapper;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.mapper.BatchTemperatureDifference;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.repository.IBatchRepository;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.service.interfaces.IBatchService;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.util.enums.OrderEnum;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.util.enums.StorageTypeEnum;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Clock;
import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class BatchServiceImpl implements IBatchService {
    IBatchRepository batchRepository;
    Clock clock;

    @Override
    @Transactional(readOnly = true)
    public BatchStockListResponseDTO findBatchesNearExpiry(Integer cantDays, StorageTypeEnum category, OrderEnum order, Integer userId) {
        LocalDate startDate = LocalDate.now(clock);
        LocalDate endDate = startDate.plusDays(cantDays);
        if (order == null) {
            order = OrderEnum.DATE_ASC;
        }
        List<BatchStockDetailsResponseDTO> batchStockList;
        if (category == null) {
            batchStockList = batchRepository.findBatchesCloseToExpire(startDate, endDate, userId, order.getSort()).stream()
                    .map(BatchStockDetailsMapper::mapBatchStockDetailsResponseDto).toList();
        } else {
            batchStockList = batchRepository.findBatchesCloseToExpireByCategory(startDate, endDate, userId, category.getFullName(), order.getSort()).stream()
                    .map(BatchStockDetailsMapper::mapBatchStockDetailsResponseDto).toList();
        }
        return new BatchStockListResponseDTO(batchStockList);
    }

    @Override
    public List<BatchTemperatureDTO> getBatchesWithTemperatureDifference() {
        double threshold = 1.5;
        List<IBatchTemperatures> projections = batchRepository.findBatchesWithTemperatureDifference(threshold);
        return BatchTemperatureDifference.toBatchTemperatureDTOs(projections);
    }

    @Override
    public List<BatchStockDTO> getBatchesLowStock() {
        double thresholdPercentage = 0.2;
        List<IBatchLowStock> projections = batchRepository.findBatchesWithLowStock(thresholdPercentage);
        return BatchLowStock.toBatchStockDTOs(projections);
    }
}
