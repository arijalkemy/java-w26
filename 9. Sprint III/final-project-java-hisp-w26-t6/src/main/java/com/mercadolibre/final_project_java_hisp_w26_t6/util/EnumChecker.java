package com.mercadolibre.final_project_java_hisp_w26_t6.util;

import com.mercadolibre.final_project_java_hisp_w26_t6.exceptions.BadRequestException;
import org.apache.commons.lang3.EnumUtils;

public class EnumChecker {
    public static void isValidEnum(Class enumClass, String enumValue, String message) {
        if (enumValue != null && !EnumUtils.isValidEnum(enumClass, enumValue)){
            throw new BadRequestException(message);
        }
    }
}
