package org.example._09concesionaria.util.findinobject;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class FindObjectUtil {
    public static <T> Optional<T> findByInteger(Integer prop, List<T> list, Function<T, Integer> functionRetriever) {
        return findObjectByProperty(prop, list, functionRetriever);
    }

    private static <T> Optional<T> findObjectByProperty(Integer prop, List<T> list, Function<T, Integer> functionRetriever) {
        return list.stream()
                .filter(o -> functionRetriever.apply(o).equals(prop))
                .findFirst();
    }

    public static <T> Optional<T> findByString(String prop, List<T> list, Function<T, String> functionRetriever) {
        return findObjectByProperty(prop, list, functionRetriever);
    }

    private static <T> Optional<T> findObjectByProperty(String prop, List<T> list, Function<T, String> functionRetriever) {
        return list.stream()
                .filter(o -> functionRetriever.apply(o).equals(prop))
                .findFirst();
    }
}
