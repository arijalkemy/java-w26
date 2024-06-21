package com.mercadolibre.pf_be_hisp_w26_t1_cassini.util;

import com.mercadolibre.pf_be_hisp_w26_t1_cassini.dtos.BatchWrongTemperatureDTO;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.entity.Batch;

import java.util.Comparator;
import java.util.List;

public class OrderBatch {
    public static  List<Batch> orderBatchListByQuantity (List < Batch > batchList) {
        return batchList.stream()
                .sorted(Comparator.comparing(Batch::getCurrentQuantity))
                .toList();

    }
    public static  List<Batch> orderBatchListByDueDate (List < Batch > batchList) {
        return batchList.stream()
                .sorted(Comparator.comparing(Batch::getDueDate))
                .toList();
    }
    public static  List<BatchWrongTemperatureDTO> orderBatchListByBatchNum (List<BatchWrongTemperatureDTO> batchList) {
        return batchList.stream()
                .sorted(Comparator.comparing(BatchWrongTemperatureDTO::getBatch_number))
                .toList();
    }
    public static  List<BatchWrongTemperatureDTO> orderBatchListByBatchQuantity (List<BatchWrongTemperatureDTO> batchList) {
        return batchList.stream()
                .sorted(Comparator.comparing(BatchWrongTemperatureDTO::getCurrent_quantity))
                .toList();
    }

    public static  List<BatchWrongTemperatureDTO> orderBatchListByTemperatureDifference(List<BatchWrongTemperatureDTO> batchList) {
        return batchList.stream()
                .sorted(Comparator.comparing(BatchWrongTemperatureDTO::getDegrees_above_minimum).reversed())
                .toList();
    }
    public static  List<Batch> orderBatchListByBatchNumber (List < Batch > batchList) {
        return batchList.stream()
                .sorted(Comparator.comparing(Batch::getId))
                .toList();
    }

}
