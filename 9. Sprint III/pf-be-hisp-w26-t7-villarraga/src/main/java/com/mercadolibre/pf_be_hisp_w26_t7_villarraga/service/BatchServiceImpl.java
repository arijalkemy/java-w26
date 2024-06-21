package com.mercadolibre.pf_be_hisp_w26_t7_villarraga.service;

import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.beans.AuthDataUtil;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.batch.BatchStockDetailsResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.batch.BatchStockListResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.batch.SectionAverageTemperature;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.entity.Batch;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.entity.Representative;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.entity.Section;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.exceptions.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.mapper.BatchStockDetailsMapper;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.repository.IBatchRepository;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.repository.IRepresentativeRepository;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.repository.ISectionRepository;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.service.interfaces.IBatchService;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.service.interfaces.IRepresentativeService;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.util.enums.MessageError;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.util.enums.OrderEnum;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.util.enums.StorageTypeEnum;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDate;
import java.util.List;

@Service
public class BatchServiceImpl implements IBatchService {
    private final IBatchRepository batchRepository;
    private final Clock clock;
    private final AuthDataUtil authDataUtil;

    public BatchServiceImpl(@Autowired IBatchRepository batchRepository, Clock clock, @Autowired AuthDataUtil authDataUtil) {
        this.batchRepository = batchRepository;
        this.clock = clock;
        this.authDataUtil = authDataUtil;
    }

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

    @Transactional(readOnly = true)
    protected Double findAvgTemperatureBySectionId(Long sectionId, Long representativeId) {
        return batchRepository.findAvgTemperatureBySectionId(sectionId, representativeId).orElseThrow(() ->
                new NotFoundException(MessageError.BATCH_NOT_FOUND_NUMBER.getMessage(sectionId)));
    }

    @Override
    @Transactional(readOnly = true)
    public SectionAverageTemperature getBatchAverage(Long sectionId) {
        Long representativeId = authDataUtil.getIdSession();
        Double averageTemperature = findAvgTemperatureBySectionId(sectionId, representativeId);
        return SectionAverageTemperature.builder()
                .averageTemperature(averageTemperature)
                .build();
    }
}
