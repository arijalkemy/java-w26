package com.mercadolibre.pf_be_hisp_w26_t10_garcia.service;

import com.mercadolibre.pf_be_hisp_w26_t10_garcia.dtos.BatchResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.dtos.BatchesCloseToExpireDto;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.dtos.UploadBatchRequestDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBatchService {
    List<BatchesCloseToExpireDto> getBatchesExpiringInDays(Integer days);
    List<BatchesCloseToExpireDto> findBatchesByDueDateAndCategory(Integer days, String category, String order);

    BatchResponseDto uploadBatchIntoStock(UploadBatchRequestDto uploadBatchRequestDto);

    BatchResponseDto updateBatchInStock(UploadBatchRequestDto uploadBatchRequestDto);

}
