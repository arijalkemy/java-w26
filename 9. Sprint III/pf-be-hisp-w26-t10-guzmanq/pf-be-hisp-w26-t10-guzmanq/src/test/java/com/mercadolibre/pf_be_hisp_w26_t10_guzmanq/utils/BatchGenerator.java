package com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.utils;

import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.dtos.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public class BatchGenerator {

     public static BatchResponseDto getBatchResponse() {
         BatchResponseDto myResponse = new BatchResponseDto();
         List<BatchDto> myBatchList = getBatchDtoList();
         myResponse.setBatch_stock(myBatchList);
         return myResponse;
     }

     public static BatchResponseDto getBatchResponseUpdated(){
         BatchResponseDto myResponse = new BatchResponseDto();
         List<BatchDto> myBatchList = getBatchDtoListUpdated();
         myResponse.setBatch_stock(myBatchList);
         return myResponse;
     }

     private static List<BatchDto>  getBatchDtoList() {
        return  Arrays.asList(new BatchDto(1, 1, 32.1, 31.0, 4, 7, LocalDate.of(2024, 6, 17), LocalTime.of(9,0,0), LocalDate.of(2025, 6, 17)));

     }

    private static List<BatchDto>  getBatchDtoListUpdated() {
        return  Arrays.asList(new BatchDto(1, 1, 42.1, 41.0, 4, 7, LocalDate.of(2024, 6, 17), LocalTime.of(9,0,0), LocalDate.of(2025, 6, 17)));

    }

     public static UploadBatchRequestDto getBatchRequest() {
         UploadBatchRequestDto requestDto = new UploadBatchRequestDto();
         InboundOrderDto inboundOrderDto = new InboundOrderDto();
         SectionDto sectionDto = new SectionDto();

         sectionDto.setSectionCode(1);
         sectionDto.setWarehouseCode(1);

         inboundOrderDto.setOrderNumber(1020);
         inboundOrderDto.setOrderDate(LocalDate.of(2024, 6, 17));
         inboundOrderDto.setSectionDto(sectionDto);
         inboundOrderDto.setBatchDto(getBatchDtoList());

         requestDto.setInboundOrderDto(inboundOrderDto);
         return requestDto;
     }

     public static UploadBatchRequestDto getBatchUpdated() {
         UploadBatchRequestDto requestDto = new UploadBatchRequestDto();
         InboundOrderDto inboundOrderDto = new InboundOrderDto();
         SectionDto sectionDto = new SectionDto();

         sectionDto.setSectionCode(1);
         sectionDto.setWarehouseCode(1);

         inboundOrderDto.setOrderNumber(1020);
         inboundOrderDto.setOrderDate(LocalDate.of(2024, 6, 17));
         inboundOrderDto.setSectionDto(sectionDto);
         inboundOrderDto.setBatchDto(getBatchDtoListUpdated());

         requestDto.setInboundOrderDto(inboundOrderDto);
         return requestDto;
     }

}
