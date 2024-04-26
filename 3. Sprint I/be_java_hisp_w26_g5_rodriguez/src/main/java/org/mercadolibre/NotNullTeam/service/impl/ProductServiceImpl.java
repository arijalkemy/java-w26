package org.mercadolibre.NotNullTeam.service.impl;

import lombok.RequiredArgsConstructor;
import org.mercadolibre.NotNullTeam.DTO.request.product.ProductFilterDTO;
import org.mercadolibre.NotNullTeam.DTO.response.product.FilterProductsResponse;
import org.mercadolibre.NotNullTeam.DTO.response.product.FiltersResponse;
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
    public FilterProductsResponse searchProducts(ProductFilterDTO productFilterDTO) {
        List<Post> posts = postServiceInternal.findAll();

        List<Post> listFiltered = posts
                .stream()
                .filter(byName(productFilterDTO))
                .filter(byType(productFilterDTO))
                .filter(byBrand(productFilterDTO))
                .filter(byColor(productFilterDTO))
                .filter(byPromo(productFilterDTO))
                .filter(byMinPrice(productFilterDTO))
                .filter(byMaxPrice(productFilterDTO))
                .toList();

        long amountWithPromo = listFiltered.stream().filter(Post::getHasPromo).count();

        FiltersResponse filtersResponse = FiltersResponse
                .builder()
                .brands(getBrands(listFiltered))
                .types(getTypes(listFiltered))
                .has_promo(amountWithPromo)
                .build();

        return FilterProductsResponse
                .builder()
                .filters(filtersResponse)
                .products(ProductMapper.postToMainProductResponse(listFiltered))
                .build();
    }

}
