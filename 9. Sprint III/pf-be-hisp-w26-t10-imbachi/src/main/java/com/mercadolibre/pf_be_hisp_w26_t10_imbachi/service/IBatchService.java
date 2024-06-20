package com.mercadolibre.pf_be_hisp_w26_t10_imbachi.service;

import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.dtos.BatchResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.dtos.BatchesCloseToExpireDto;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.dtos.UploadBatchRequestDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface IBatchService {
    List<BatchesCloseToExpireDto> getBatchesExpiringInDays(Integer days);
    List<BatchesCloseToExpireDto> findBatchesByDueDateAndCategory(Integer days, String category, String order);

    BatchResponseDto uploadBatchIntoStock(UploadBatchRequestDto uploadBatchRequestDto);

    BatchResponseDto updateBatchInStock(UploadBatchRequestDto uploadBatchRequestDto);
    List<BatchesCloseToExpireDto> getLowQuantityBatch(Integer quantity);

}
