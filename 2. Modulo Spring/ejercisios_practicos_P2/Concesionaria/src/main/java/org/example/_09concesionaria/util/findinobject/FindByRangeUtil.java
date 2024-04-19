package org.example._09concesionaria.util.findinobject;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindByRangeUtil {
    public static <T> List<T> filterByRange(
            List<T> list, Integer minValue, Integer maxValue,
            Function<T, Integer> functionRetriever
    ){
        return list.stream()
                .filter(Objects::nonNull) // Filtrar elementos nulos
                .filter(o -> {
                    Integer value = functionRetriever.apply(o);
                    return value != null &&
                            (minValue == null || value.compareTo(minValue) >= 0) &&
                            (maxValue == null || value.compareTo(maxValue) <= 0);
                })
                .collect(Collectors.toList());
    }
}
