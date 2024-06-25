package com.mercadolibre.pf_be_hisp_w26_t07_torres.util;

import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.batch.BSResponseDTO;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ProductUtil {

    public static final Set<String> listOrder = Set.of("L", "C", "F");

    public static Boolean orderValidation(String order) {
        if (order == null) {
            return true;
        }
        return listOrder.contains(order.toUpperCase());
    }

    public static List<BSResponseDTO> getProductBatchByOrder(List<BSResponseDTO> responseList, String order) {

        if (order == null) return responseList;

        return switch (order) {
            case "L" -> responseList.stream()
                    .sorted(Comparator.comparing(BSResponseDTO::getId))
                    .collect(Collectors.toList());
            case "C" -> responseList.stream()
                    .sorted(Comparator.comparing(BSResponseDTO::getCurrentQuantity))
                    .collect(Collectors.toList());
            case "F" -> responseList.stream()
                    .sorted(Comparator.comparing(BSResponseDTO::getDueDate))
                    .collect(Collectors.toList());
            default -> responseList;
        };
    }
}
