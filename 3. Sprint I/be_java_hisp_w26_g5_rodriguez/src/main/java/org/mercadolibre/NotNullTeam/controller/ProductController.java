package org.mercadolibre.NotNullTeam.controller;

import lombok.RequiredArgsConstructor;
import org.mercadolibre.NotNullTeam.DTO.request.product.ProductFilterDTO;
import org.mercadolibre.NotNullTeam.DTO.response.product.FilterProductsResponse;
import org.mercadolibre.NotNullTeam.service.external.IProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final IProductService service;

    @GetMapping("/list")
    public ResponseEntity<FilterProductsResponse> getProductsFilters(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) String color,
            @RequestParam(required = false, defaultValue = "false") boolean has_promo,
            @RequestParam(required = false) Double min_price,
            @RequestParam(required = false) Double max_price) {

        ProductFilterDTO productFilterDTO = ProductFilterDTO
                .builder()
                .name(name)
                .type(type)
                .brand(brand)
                .color(color)
                .min_price(min_price)
                .max_price(max_price)
                .has_promo(has_promo)
                .build();

        FilterProductsResponse response = service.searchProducts(productFilterDTO);
        return ResponseEntity.ok(response);
    }
}
