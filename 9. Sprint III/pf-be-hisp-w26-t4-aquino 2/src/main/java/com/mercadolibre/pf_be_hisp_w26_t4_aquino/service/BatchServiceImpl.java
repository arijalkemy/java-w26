package com.mercadolibre.pf_be_hisp_w26_t4_aquino.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.pf_be_hisp_w26_t4_aquino.dtos.response.BatchResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t4_aquino.model.Batch;
import com.mercadolibre.pf_be_hisp_w26_t4_aquino.model.ProductTypeEnum;
import com.mercadolibre.pf_be_hisp_w26_t4_aquino.repository.IBatchRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BatchServiceImpl implements IBatchService {

    private final IBatchRepository batchRepository;
    private final ObjectMapper om;

    public BatchServiceImpl(ObjectMapper objectMapper, IBatchRepository batchRepository) {
        objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(new JavaTimeModule());
        this.om = objectMapper;
        this.batchRepository = batchRepository;
    }

    @Override
    public List<BatchResponseDto> getBatchesByDueDate(int cantDays) {
        LocalDate dueDate = LocalDate.now().plusDays(cantDays);
        List<Batch> batches = batchRepository.findByDueDateBetweenOrderByDueDateAsc(LocalDate.now(), dueDate);

        return getListOfBatchDto(batches);
    }

    @Override
    public List<BatchResponseDto> getBatchListByCategoryOrderByDueDate(int cantDays, String productTypeDescription, String order) {
        LocalDate dueDate = LocalDate.now().plusDays(cantDays);
        List<Batch> batches;
        if (order.equals("date_desc")) {
            batches = batchRepository
                    .findByDueDateBetweenAndProduct_ProductType_DescriptionOrderByDueDateDesc(LocalDate.now(), dueDate, getEnum(productTypeDescription));
        } else {
            batches = batchRepository
                    .findByDueDateBetweenAndProduct_ProductType_DescriptionOrderByDueDateAsc(LocalDate.now(), dueDate, getEnum(productTypeDescription));
        }

        return getListOfBatchDto(batches);
    }

    private List<BatchResponseDto> getListOfBatchDto(List<Batch> batches) {
        return batches.stream()
                .map(batch -> {
                    BatchResponseDto batchDto = batchToBachResponseDTO(batch);
                    batchDto.setProductId(batch.getProduct().getId().intValue());
                    batchDto.setProductTypeId(batch.getProduct().getProductType().getId().intValue());
                    return batchDto;
                })
                .toList();
    }

    @Override
    public List<BatchResponseDto> getBatches(Pageable pageable) {
        List<Batch> batches = batchRepository.findAll(pageable).toList();
        return getListOfBatchDto(batches);
    }

    private ProductTypeEnum getEnum(String productType) {
        return switch (productType) {
            case "FS" -> ProductTypeEnum.FRESCO;
            case "RF" -> ProductTypeEnum.REFRIGERADO;
            case "FF" -> ProductTypeEnum.CONGELADO;
            default -> null;
        };
    }

    private BatchResponseDto batchToBachResponseDTO(Batch batch) {
        return BatchResponseDto.builder()
                .batchNumber(batch.getId().intValue())
                .dueDate(batch.getDueDate())
                .currentQuantity(batch.getCurrentQuantity())
                .productId(batch.getProduct().getId().intValue())
                .productTypeId(batch.getProduct().getProductType().getId().intValue())
                .build();
    }
}
