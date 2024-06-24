package com.mercadolibre.pf_be_hisp_w26_t6_martinez.mappers;

import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.BatchDto.*;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.SectionDto.ListProductsBatchDto;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.SectionDto.SectionDto;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.entity.Batch;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.entity.Product;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BatchMapper {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static final DateTimeFormatter formatterHs = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");


    public static BatchStockListResponseDto createBatchStockListResponseDto(List<Batch> batches){
        return BatchStockListResponseDto.builder()
                .batchStock(batches.stream().map(BatchMapper::batchToBatchStockDTOComplete).toList())
                .build();
    }

    public static BatchStockDto batchToBatchStockDTO(Batch batch){
        return BatchStockDto.builder()
                .batchNumber(batch.getBatchNumber())
                .currentQuantity(batch.getQuantity())
                .due_date(formatter.format(batch.getDueDate()))
                .build();
    }

    public static BatchStockDto batchToBatchStockDTOComplete(Batch batch){
        return BatchStockDto.builder()
                .batchNumber(batch.getBatchNumber())
                .currentQuantity(batch.getQuantity())
                .due_date(formatter.format(batch.getDueDate()))
                .productType(batch.getProduct().getStorageType())
                .productId(Integer.parseInt(batch.getProduct().getId().toString()))
                .build();
    }

    public static Batch batchDtoToBatch(BatchDto batchDto) {
        LocalDateTime manufacturingDateTime = LocalDateTime.parse(batchDto.getManufacturingTime(), formatterHs);
        LocalDateTime dueDateTime = LocalDateTime.parse(batchDto.getDueDate(), formatterHs);

        return Batch.builder()
                .batchNumber(batchDto.getBatchNumber())
                .currentTemperature(batchDto.getCurrentTemperature())
                .minimumTemperature(batchDto.getMinimumTemperature())
                .quantity(batchDto.getInitialQuantity())
                .manufacturingDateTime(manufacturingDateTime)
                .dueDate(dueDateTime)
                .product(Product.builder().id(Long.valueOf(batchDto.getProductId())).build())
                .build();
    }

    public static BatchInsertionResponseDto batchInsertionRequestDtoToBatchInsertionResponseDto
            (BatchInsertionRequestDto requestDto){
        return BatchInsertionResponseDto.builder()
                .batchDto(requestDto.getInboundOrderRequestDto().getBatchStock())
                .build();
    }

    public static Batch updateBatchDtoToBatch(Batch existing, BatchDto batchDto){
        Batch newBatch = batchDtoToBatch(batchDto);
        newBatch.setId(existing.getId());
        return newBatch;
    }

    public static ListProductsBatchDto mapListProductsToListBatchDto(SectionDto sectorDto, Long productId,
                                                                     List<BatchStockDto> batchStockDtos) {
        return ListProductsBatchDto.builder()
                .section(sectorDto)
                .productId(productId)
                .batchStock(batchStockDtos)
                .build();
    }
}
