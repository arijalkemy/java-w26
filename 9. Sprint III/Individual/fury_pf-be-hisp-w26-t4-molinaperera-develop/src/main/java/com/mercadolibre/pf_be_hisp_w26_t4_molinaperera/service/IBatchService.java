package com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.service;

import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.dtos.response.BatchResponseDto;

import java.util.List;

public interface IBatchService {
    List<BatchResponseDto> getBatchesByDueDate(int cantDays);
    List<BatchResponseDto> getBatchListByCategoryOrderByDueDate(int cantDays, String productTypeDescription, String order);
}
