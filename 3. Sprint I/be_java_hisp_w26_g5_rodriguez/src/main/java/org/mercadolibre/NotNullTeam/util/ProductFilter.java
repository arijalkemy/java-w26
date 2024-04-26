package org.mercadolibre.NotNullTeam.util;

import org.mercadolibre.NotNullTeam.DTO.request.product.ProductFilterDTO;
import org.mercadolibre.NotNullTeam.model.Post;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class ProductFilter {

    public static Predicate<Post> byProperty(Function<Post, String> propertyExtractor,
                                             String value) {
        return post -> value == null || propertyExtractor.apply(post).equalsIgnoreCase(value);
    }

    public static Predicate<Post> byPrice(Function<Post, Double> priceExtractor, Double value,
                                          BiFunction<Double, Double, Boolean> comparator) {
        return post -> value == null || comparator.apply(priceExtractor.apply(post), value);
    }

    public static Predicate<Post> byName(ProductFilterDTO productFilterDTO) {
        return byProperty(post -> post.getProduct().getName(), productFilterDTO.getName());
    }

    public static Predicate<Post> byType(ProductFilterDTO productFilterDTO) {
        return byProperty(post -> post.getProduct().getType(), productFilterDTO.getType());
    }

    public static Predicate<Post> byBrand(ProductFilterDTO productFilterDTO) {
        return byProperty(post -> post.getProduct().getBrand(), productFilterDTO.getBrand());
    }

    public static Predicate<Post> byColor(ProductFilterDTO productFilterDTO) {
        return byProperty(post -> post.getProduct().getColor(), productFilterDTO.getColor());
    }

    public static Predicate<Post> byMinPrice(ProductFilterDTO productFilterDTO) {
        return byPrice(Post::getPrice,
                productFilterDTO.getMin_price(),
                (postPrice, minPrice) -> postPrice >= minPrice);
    }

    public static Predicate<Post> byMaxPrice(ProductFilterDTO productFilterDTO) {
        return byPrice(Post::getPrice,
                productFilterDTO.getMax_price(),
                (postPrice, maxPrice) -> postPrice <= maxPrice);
    }

}
