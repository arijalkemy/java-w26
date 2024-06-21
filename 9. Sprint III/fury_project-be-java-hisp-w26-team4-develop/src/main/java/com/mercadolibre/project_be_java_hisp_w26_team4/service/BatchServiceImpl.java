package com.mercadolibre.project_be_java_hisp_w26_team4.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.project_be_java_hisp_w26_team4.dtos.response.BatchResponseDto;
import com.mercadolibre.project_be_java_hisp_w26_team4.model.Batch;
import com.mercadolibre.project_be_java_hisp_w26_team4.model.ProductTypeEnum;
import com.mercadolibre.project_be_java_hisp_w26_team4.repository.IBatchRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BatchServiceImpl implements IBatchService{

    private final IBatchRepository batchRepository;
    private final ObjectMapper om;

    public BatchServiceImpl(ObjectMapper objectMapper, IBatchRepository batchRepository){
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
        List<BatchResponseDto> batchesDto = batches.stream()
                .map(batch -> {
                    BatchResponseDto batchDto = batchToBachResponseDTO(batch);
                    batchDto.setProductId(batch.getProduct().getId().intValue());
                    batchDto.setProductTypeId(batch.getProduct().getProductType().getId().intValue());
                    return batchDto;
                })
                .toList();

        return batchesDto;
    }

    @Override
    public List<BatchResponseDto> getBatchListByCategoryOrderByDueDate(int cantDays, String productTypeDescription, String order) {
        LocalDate dueDate = LocalDate.now().plusDays(cantDays);
        List<Batch> batches;
        if(order.equals("date_desc")) {
            batches = batchRepository
                .findByDueDateBetweenAndProduct_ProductType_DescriptionOrderByDueDateDesc(LocalDate.now(), dueDate, getEnum(productTypeDescription));
        }
        else {
            batches = batchRepository
                .findByDueDateBetweenAndProduct_ProductType_DescriptionOrderByDueDateAsc(LocalDate.now(), dueDate, getEnum(productTypeDescription));
        }
        List<BatchResponseDto> batchesDto = batches.stream()
                .map(batch -> {
                    BatchResponseDto batchDto = batchToBachResponseDTO(batch);
                    batchDto.setProductId(batch.getProduct().getId().intValue());
                    batchDto.setProductTypeId(batch.getProduct().getProductType().getId().intValue());
                    return batchDto;
                })
                .toList();

        return batchesDto;
    }

    private ProductTypeEnum getEnum(String productType) {
        if(productType.equals("FS")) {
            return ProductTypeEnum.FRESCO;
        }
        if(productType.equals("RF")) {
            return ProductTypeEnum.REFRIGERADO;
        }
        if(productType.equals("FF")) {
            return ProductTypeEnum.CONGELADO;
        }
        return null;
    }

    private BatchResponseDto batchToBachResponseDTO(Batch batch){
        return BatchResponseDto.builder()
                .batchNumber(batch.getId().intValue())
                .dueDate(batch.getDueDate())
                .currentQuantity(batch.getCurrentQuantity())
                .productId(batch.getProduct().getId().intValue())
                .productTypeId(batch.getProduct().getProductType().getId().intValue())
                .build();
    }
}
