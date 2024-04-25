package org.example.g14.utils;

import org.example.g14.dto.CreatePostDto;

import java.util.Arrays;
import java.util.Objects;

public class Validation {

    public static boolean isAnyNull(Object... objects) {

        return Arrays.stream(objects).anyMatch(Objects::isNull);
    }

    public static boolean isValid(CreatePostDto dto) {

        if (isAnyNull(
            dto.getIdUser(), dto.getDate(), dto.getProduct(), dto.getCategory(), dto.getPrice(), dto.getProduct()
        )) {
            return false;
        }

        if (isAnyNull(
            dto.getProduct().getId(), dto.getProduct().getName(), dto.getProduct().getType(),
            dto.getProduct().getBrand(), dto.getProduct().getColor(), dto.getProduct().getNotes()
        )) {
            return false;
        }

        if (dto.getHasPromo() == Boolean.TRUE) {
            //noinspection RedundantIfStatement
            if (dto.getDiscount() == null || dto.getDiscount() <= 0 || dto.getDiscount() > 1) {
                return false;
            }
        }

        return true;
    }
}
