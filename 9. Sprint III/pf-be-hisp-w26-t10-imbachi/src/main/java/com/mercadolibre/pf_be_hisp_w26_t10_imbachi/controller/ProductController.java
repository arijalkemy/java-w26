package com.mercadolibre.pf_be_hisp_w26_t10_imbachi.controller;

import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.dtos.NewProductDto;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.dtos.ProductsGeneralDto;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.entity.Product;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.service.IProductService;
import jakarta.validation.Valid;
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

    @PostMapping("/product")
    public ResponseEntity<?> createNewProduct(@RequestBody @Valid NewProductDto product){
        return  ResponseEntity.status(HttpStatus.CREATED).body(productService.saveProduct(product));
    }

}
