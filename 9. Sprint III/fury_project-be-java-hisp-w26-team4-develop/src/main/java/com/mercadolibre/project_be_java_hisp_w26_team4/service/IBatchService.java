package com.mercadolibre.project_be_java_hisp_w26_team4.service;

import com.mercadolibre.project_be_java_hisp_w26_team4.dtos.response.BatchResponseDto;

import java.util.List;

public interface IBatchService {
    List<BatchResponseDto> getBatchesByDueDate(int cantDays);
    List<BatchResponseDto> getBatchListByCategoryOrderByDueDate(int cantDays, String productTypeDescription, String order);
}
