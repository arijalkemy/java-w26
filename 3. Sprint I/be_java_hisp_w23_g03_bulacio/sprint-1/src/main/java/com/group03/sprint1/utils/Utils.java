package com.group03.sprint1.utils;

import com.group03.sprint1.entity.Publication;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    public static boolean isNull(Object obj) {
        return obj == null;
    }

    public static boolean isNotNull(Object obj) {
        return obj != null;
    }

    public static List<Publication> searchProductByName(List<Publication> publications, String productName){
        if (isNotNull(productName)) {
            return publications.stream().filter(p ->
                            p.getProduct().getProductName().toLowerCase().contains(productName.toLowerCase()))
                    .collect(Collectors.toList());
        }
        return publications;
    }
    public static List<Publication> getPublicationsInRange(List<Publication> publications,
                                                           Double minTotal,
                                                           Double maxTotal){
        if (Utils.isNotNull(minTotal)) {
            publications = publications.stream().filter(p ->
                    p.calculateTotalPrice() > minTotal
            ).collect(Collectors.toList());
        }

        if (Utils.isNotNull(maxTotal)) {
            publications = publications.stream().filter(p ->
                    p.calculateTotalPrice() < maxTotal
            ).collect(Collectors.toList());
        }

        return publications;
    }

    public static List<Publication> sortPublicationsByTotalPrice(List<Publication> publications, String order) {
            if (Utils.isNotNull(order)) {
                if (order.equals(Constants.TOTAL_PRICE_ORDER_ASCENDANT) ||
                        order.equals(Constants.PRICE_ORDER_DESCENDANT)) {
                    publications = publications.stream()
                            .sorted((p1, p2) -> {
                                int comparison = Comparator.comparing(Publication::calculateTotalPrice).compare(p1, p2);
                                return order.equals(Constants.TOTAL_PRICE_ORDER_ASCENDANT) ? comparison : -comparison;
                            })
                            .collect(Collectors.toList());
                }
            }
            return publications;
    }
}
