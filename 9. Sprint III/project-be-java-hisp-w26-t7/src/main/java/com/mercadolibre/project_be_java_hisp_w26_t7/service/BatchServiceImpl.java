package com.mercadolibre.project_be_java_hisp_w26_t7.service;

import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.batch.BatchStockDetailsResponseDTO;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.batch.BatchStockListResponseDTO;
import com.mercadolibre.project_be_java_hisp_w26_t7.mapper.BatchStockDetailsMapper;
import com.mercadolibre.project_be_java_hisp_w26_t7.repository.IBatchRepository;
import com.mercadolibre.project_be_java_hisp_w26_t7.service.interfaces.IBatchService;
import com.mercadolibre.project_be_java_hisp_w26_t7.util.enums.OrderEnum;
import com.mercadolibre.project_be_java_hisp_w26_t7.util.enums.StorageTypeEnum;
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
}
