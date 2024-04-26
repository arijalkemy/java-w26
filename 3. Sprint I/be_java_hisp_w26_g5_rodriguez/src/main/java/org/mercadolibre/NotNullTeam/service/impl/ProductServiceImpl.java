package org.mercadolibre.NotNullTeam.service.impl;

import lombok.RequiredArgsConstructor;
import org.mercadolibre.NotNullTeam.DTO.request.product.ProductFilterDTO;
import org.mercadolibre.NotNullTeam.DTO.response.product.MainProductResponse;
import org.mercadolibre.NotNullTeam.mapper.ProductMapper;
import org.mercadolibre.NotNullTeam.model.Post;
import org.mercadolibre.NotNullTeam.service.external.IProductService;
import org.mercadolibre.NotNullTeam.service.internal.IPostServiceInternal;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.mercadolibre.NotNullTeam.util.ProductFilter.*;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {

    private final IPostServiceInternal postServiceInternal;

    @Override
    public List<MainProductResponse> searchProducts(ProductFilterDTO productFilterDTO) {
        List<Post> posts = postServiceInternal.findAll();

        if (posts.isEmpty()) return new ArrayList<>();

        List<Post> listFiltered = posts
                .stream()
                .filter(byName(productFilterDTO))
                .filter(byType(productFilterDTO))
                .filter(byBrand(productFilterDTO))
                .filter(byColor(productFilterDTO))
                .filter(byMinPrice(productFilterDTO))
                .filter(byMaxPrice(productFilterDTO))
                .toList();

        if (listFiltered.isEmpty()) return ProductMapper.postToMainProductResponse(posts);
        else return ProductMapper.postToMainProductResponse(listFiltered);
    }
}
