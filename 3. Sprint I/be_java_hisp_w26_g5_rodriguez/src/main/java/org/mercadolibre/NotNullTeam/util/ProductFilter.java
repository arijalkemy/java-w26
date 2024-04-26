package org.mercadolibre.NotNullTeam.util;

import org.mercadolibre.NotNullTeam.DTO.request.product.ProductFilterDTO;
import org.mercadolibre.NotNullTeam.DTO.response.brand.BrandBasicResponse;
import org.mercadolibre.NotNullTeam.DTO.response.type.TypeBasicResponse;
import org.mercadolibre.NotNullTeam.mapper.BrandMapper;
import org.mercadolibre.NotNullTeam.mapper.TypeMapper;
import org.mercadolibre.NotNullTeam.model.Post;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class ProductFilter {

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

    public static Predicate<Post> byPromo(ProductFilterDTO productFilterDTO) {
         return post -> !productFilterDTO.isHas_promo() || post.getHasPromo();
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

    public static Predicate<Post> byProperty(Function<Post, String> propertyExtractor,
                                             String value) {
        return post -> value == null || propertyExtractor.apply(post).equalsIgnoreCase(value);
    }

    public static Predicate<Post> byPrice(Function<Post, Double> priceExtractor, Double value,
                                          BiFunction<Double, Double, Boolean> comparator) {
        return post -> value == null || comparator.apply(priceExtractor.apply(post), value);
    }


    public static List<BrandBasicResponse> getBrands(List<Post> posts) {
        return getProperties(posts,
                post -> post.getProduct().getBrand(),
                BrandMapper::toBrandBasicResponse);
    }

    public static List<TypeBasicResponse> getTypes(List<Post> posts) {
        return getProperties(posts,
                post -> post.getProduct().getType(),
                TypeMapper::toTypeBasicResponse);
    }

    private static <T> List<T> getProperties(List<Post> posts,
                                             Function<Post, String> propertyExtractor,
                                             BiFunction<String, List<Post>, T> mapper) {
        List<String> propertyNames = posts.stream().map(propertyExtractor).distinct().toList();

        return propertyNames
                .stream()
                .map(propertyName -> mapper.apply(propertyName, posts))
                .toList();
    }

}
