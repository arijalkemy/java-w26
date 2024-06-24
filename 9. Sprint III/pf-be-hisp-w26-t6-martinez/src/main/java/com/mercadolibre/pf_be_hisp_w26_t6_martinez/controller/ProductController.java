package com.mercadolibre.pf_be_hisp_w26_t6_martinez.controller;

import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.ProductDto.ProductsResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.SectionDto.ListProductsBatchDto;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.WarehouseDto.ProductByWarehouseDto;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.services.product.IProductService;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/fresh-products/")
@Validated
public class ProductController {

    private final String NON_NUMBER_ERROR =  "El id del producto debe ser un número positivo.";

    @Autowired
    IProductService productService;

    @PreAuthorize("hasAuthority('BUYER')")
    @GetMapping("/list")
    public ResponseEntity<ProductsResponseDto> listProducts(@RequestParam(required = false) String category) {
        return new ResponseEntity<>( productService.getAllProductsByCategory(category), HttpStatus.OK);
    }

    // REQ 3 - ml-check-product-location-in-warehouse-01
    @PreAuthorize("hasAuthority('SUPERVISOR')")
    @GetMapping("/{productId}/batch/list")
    public ResponseEntity<ListProductsBatchDto> listProductsOfBatches(
            @Positive(message = NON_NUMBER_ERROR)
            @PathVariable Long productId,
            @RequestParam(required = false) String order
    ) {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ListProductsBatchDto response = this.productService.listBatchsByProductId(productId, username, order);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // REQUERIMIENTO 4 - ml-check-product-stock-in-warehouses-04
    @PreAuthorize("hasAuthority('SUPERVISOR')")
    @GetMapping("/{idProduct}/warehouse/list")
    public ResponseEntity<ProductByWarehouseDto> listProductQuantitiesForAllWarehouses(
            @Positive(message = NON_NUMBER_ERROR)
            @PathVariable Long idProduct){
        ProductByWarehouseDto allStock = productService.getTotalStockByProduct(idProduct);
        return new ResponseEntity<>(allStock, HttpStatus.OK);
    }

}
