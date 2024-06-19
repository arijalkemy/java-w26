package com.mercadolibre.final_project_java_h_w26_t10.service;

import com.mercadolibre.final_project_java_h_w26_t10.dtos.BatchResponseDto;
import com.mercadolibre.final_project_java_h_w26_t10.dtos.BatchesCloseToExpireDto;
import com.mercadolibre.final_project_java_h_w26_t10.dtos.UploadBatchRequestDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface IBatchService {
    List<BatchesCloseToExpireDto> getBatchesExpiringInDays(Integer days);
    List<BatchesCloseToExpireDto> findBatchesByDueDateAndCategory(Integer days, String category, String order);

    BatchResponseDto uploadBatchIntoStock(UploadBatchRequestDto uploadBatchRequestDto);

    BatchResponseDto updateBatchInStock(UploadBatchRequestDto uploadBatchRequestDto);

}
