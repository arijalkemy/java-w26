package com.mercadolibre.pf_be_hisp_w26_t6_martinez.util;

import com.mercadolibre.pf_be_hisp_w26_t6_martinez.exceptions.BadRequestException;
import org.apache.commons.lang3.EnumUtils;

public class EnumChecker {
    public static void isValidEnum(Class enumClass, String enumValue, String message) {
        if (enumValue != null && !EnumUtils.isValidEnum(enumClass, enumValue)){
            throw new BadRequestException(message);
        }
    }
}
