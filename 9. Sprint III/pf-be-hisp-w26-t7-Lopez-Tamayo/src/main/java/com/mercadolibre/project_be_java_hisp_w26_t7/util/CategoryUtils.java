package com.mercadolibre.project_be_java_hisp_w26_t7.util;

import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.enums.Category;

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
