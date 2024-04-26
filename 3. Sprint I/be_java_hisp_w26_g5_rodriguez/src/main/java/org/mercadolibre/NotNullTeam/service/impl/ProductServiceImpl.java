package org.mercadolibre.NotNullTeam.service.impl;

import lombok.RequiredArgsConstructor;
import org.mercadolibre.NotNullTeam.DTO.request.product.ProductFilterDTO;
import org.mercadolibre.NotNullTeam.DTO.response.brand.BrandBasicResponse;
import org.mercadolibre.NotNullTeam.DTO.response.product.FilterProducts;
import org.mercadolibre.NotNullTeam.mapper.BrandMapper;
import org.mercadolibre.NotNullTeam.mapper.ProductMapper;
import org.mercadolibre.NotNullTeam.model.Post;
import org.mercadolibre.NotNullTeam.service.external.IProductService;
import org.mercadolibre.NotNullTeam.service.internal.IPostServiceInternal;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.mercadolibre.NotNullTeam.util.ProductFilter.*;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {

    private final IPostServiceInternal postServiceInternal;

    @Override
    public FilterProducts searchProducts(ProductFilterDTO productFilterDTO) {
        List<Post> posts = postServiceInternal.findAll();

        List<Post> listFiltered = posts
                .stream()
                .filter(byName(productFilterDTO))
                .filter(byType(productFilterDTO))
                .filter(byBrand(productFilterDTO))
                .filter(byColor(productFilterDTO))
                .filter(byMinPrice(productFilterDTO))
                .filter(byMaxPrice(productFilterDTO))
                .toList();

        return FilterProducts
                .builder()
                .brands(getBrands(listFiltered))
                .products(ProductMapper.postToMainProductResponse(listFiltered))
                .build();
    }

    private List<BrandBasicResponse> getBrands(List<Post> posts) {
        List<String> brandNames = posts
                .stream()
                .map(post -> post.getProduct().getBrand())
                .distinct()
                .toList();

        return brandNames
                .stream()
                .map(brand -> BrandMapper.toBrandBasicResponse(brand, posts))
                .toList();
    }
}
