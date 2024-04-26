package org.mercadolibre.NotNullTeam.mapper;

import org.mercadolibre.NotNullTeam.DTO.request.product.ProductDTO;
import org.mercadolibre.NotNullTeam.DTO.response.product.MainProductResponse;
import org.mercadolibre.NotNullTeam.model.Post;
import org.mercadolibre.NotNullTeam.model.Product;

import java.util.List;

public class ProductMapper {

    public static ProductDTO productToProductDto(Product product) {
        return new ProductDTO(product.getId(),
                product.getName(),
                product.getType(),
                product.getBrand(),
                product.getColor(),
                product.getNotes());
    }

    public static Product productDtoToProduct(ProductDTO productDTO) {
        return new Product(productDTO.getProduct_id(),
                productDTO.getProduct_name(),
                productDTO.getType(),
                productDTO.getBrand(),
                productDTO.getColor(),
                productDTO.getNotes());
    }

    public static MainProductResponse postToMainProductResponse(Post post) {
        return MainProductResponse
                .builder()
                .id(post.getId())
                .name(post.getProduct().getName())
                .price(post.getPrice())
                .has_promo(post.getHasPromo())
                .discount(post.getDiscount())
                .build();
    }

    public static List<MainProductResponse> postToMainProductResponse(List<Post> posts) {
        return posts.stream().map(ProductMapper::postToMainProductResponse).toList();
    }
}
