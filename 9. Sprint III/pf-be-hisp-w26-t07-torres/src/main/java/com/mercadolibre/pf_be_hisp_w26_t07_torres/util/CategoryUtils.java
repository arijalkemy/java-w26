package com.mercadolibre.pf_be_hisp_w26_t07_torres.util;

import com.mercadolibre.pf_be_hisp_w26_t07_torres.util.enums.Category;

import java.util.Arrays;

public class CategoryUtils {
    public static boolean categoryExists(String category) {
        for (Category c : Category.values()) {
            if (c.name().equals(category)) {
                return true;
            }
        }
        return false;
    }

    public static Category getCategory(String category) {
        return Arrays.stream(Category.values()).filter(c -> c.name().equals(category)).findFirst().orElse(Category.FS);
    }
}
