package com.mercadolibre.project_java_w26_team13.util;

import com.mercadolibre.project_java_w26_team13.exceptions.ExceptionsFactory;

public class Helper {
    public static String validateCategoryFilter(String categoryFilter) {
        switch (categoryFilter) {
            case "FS":
                return "Fresco";
            case "RF":
                return "Refrigerado";
            case "FF":
                return "Congelado";
            default:
                throw ExceptionsFactory.notFoundException("Invalid category: " + categoryFilter);
        }
    }
}
