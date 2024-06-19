package com.mercadolibre.project_be_java_hisp_w26_t7.service;

import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.batch.BatchStockDetailsResponseDTO;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.batch.BatchStockListResponseDTO;
import com.mercadolibre.project_be_java_hisp_w26_t7.util.OrderEnum;
import com.mercadolibre.project_be_java_hisp_w26_t7.util.StorageTypeEnum;
import com.mercadolibre.project_be_java_hisp_w26_t7.mapper.BatchStockDetailsMapper;
import com.mercadolibre.project_be_java_hisp_w26_t7.repository.IBatchRepository;
import com.mercadolibre.project_be_java_hisp_w26_t7.service.interfaces.IBatchService;

import lombok.AllArgsConstructor;

import java.time.Clock;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BatchServiceImpl implements IBatchService {
    IBatchRepository batchRepository;
    Clock clock;

    @Override
    public BatchStockListResponseDTO findBatchesNearExpiry(Integer cantDays, StorageTypeEnum category, OrderEnum order, Integer userId ) {
        LocalDate startDate = LocalDate.now(clock);
        LocalDate endDate = startDate.plusDays(cantDays);
        if(order == null){
            order = OrderEnum.DATE_ASC;
        }
        if(category == null){
            List<BatchStockDetailsResponseDTO> batchStockList = batchRepository.findBatchesCloseToExpire(startDate, endDate, userId, order.getSort()).stream()
                    .map(b -> BatchStockDetailsMapper.mapBatchStockDetailsResponseDto(b)).toList();
            return new BatchStockListResponseDTO(batchStockList);
        }else{
            List<BatchStockDetailsResponseDTO> batchStockList = batchRepository.findBatchesCloseToExpireByCategory(startDate, endDate, userId, category.getFullName(), order.getSort()).stream()
                    .map(b -> BatchStockDetailsMapper.mapBatchStockDetailsResponseDto(b)).toList();
            return new BatchStockListResponseDTO(batchStockList);
        }

    }
}
