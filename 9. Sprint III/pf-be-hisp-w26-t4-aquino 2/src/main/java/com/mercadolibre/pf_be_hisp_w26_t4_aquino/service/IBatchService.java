package com.mercadolibre.pf_be_hisp_w26_t4_aquino.service;

import com.mercadolibre.pf_be_hisp_w26_t4_aquino.dtos.response.BatchResponseDto;

import java.util.List;
import org.springframework.data.domain.Pageable;

public interface IBatchService {
    List<BatchResponseDto> getBatchesByDueDate(int cantDays);
    List<BatchResponseDto> getBatchListByCategoryOrderByDueDate(int cantDays, String productTypeDescription, String order);
    List<BatchResponseDto> getBatches(Pageable pageable);
}
