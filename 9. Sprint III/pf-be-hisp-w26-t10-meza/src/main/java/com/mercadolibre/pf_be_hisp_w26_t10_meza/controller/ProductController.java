package com.mercadolibre.pf_be_hisp_w26_t10_meza.controller;

import com.mercadolibre.pf_be_hisp_w26_t10_meza.dtos.ProductsGeneralDto;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.dtos.product.ProductInfoDto;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.dtos.product.ProductLoadRequestDto;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.dtos.product.ProductLoadResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.service.IProductService;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller responsible for /fresh-products implementation.
 */
@RestController
@RequestMapping("/api/v1/fresh-products")
public class ProductController {

    @Autowired
    IProductService productService;

    /**
     * Get all data about item by warehause
     *
     * @param idProduct Item number to search
     * @return Data about quantities per warehouse
     */
    @PreAuthorize("hasRole('SUPERVISOR')")
    @GetMapping("/{idProduct}/warehouse/list")
    public ResponseEntity<?> getItemQtyByWh(@PathVariable Integer idProduct) {
        return new ResponseEntity<>(this.productService.getProductWh(idProduct), HttpStatus.OK);
    }

    /**
     * @return "List<Product>" List All Products
     */
    @GetMapping("/list")
    public ResponseEntity<List<ProductsGeneralDto>> getAllProducts(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(productService.getProducts());
    }


    @PostMapping("{idSeller}")
    public ResponseEntity<ProductLoadResponseDto> loadProduct(@RequestBody ProductLoadRequestDto productLoadRequestDto, @PathVariable("idSeller") Long idSeller) {
        return new ResponseEntity<>(productService.productRegister(productLoadRequestDto,idSeller), HttpStatus.CREATED);
    }

    @PutMapping("/{idSeller}/{idProduct}")
    public ResponseEntity<ProductLoadResponseDto> updateProducts(@RequestBody ProductInfoDto productInfoDto, @PathVariable("idSeller") Long idSeller, @PathVariable("idProduct") Integer idProduct) {
        return new ResponseEntity<>(productService.updateProduct(productInfoDto ,idSeller, idProduct), HttpStatus.CREATED);
    }

}
