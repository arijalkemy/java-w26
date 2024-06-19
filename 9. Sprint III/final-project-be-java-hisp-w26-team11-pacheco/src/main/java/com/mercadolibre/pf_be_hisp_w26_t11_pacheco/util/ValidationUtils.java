package com.mercadolibre.pf_be_hisp_w26_t11_pacheco.util;

import com.mercadolibre.pf_be_hisp_w26_t11_pacheco.model.Batch;
import com.mercadolibre.pf_be_hisp_w26_t11_pacheco.model.Section;

import java.util.List;

public class ValidationUtils {
    public int getTotalQuantityAvailable(List<Batch> batches, Section section) {
        int currentStockQuantity = batches.stream()
                .map(Batch::getCurrentQuantity)
                .reduce(0, Integer::sum);

        return section.getCapacity() - currentStockQuantity;
    }
}
