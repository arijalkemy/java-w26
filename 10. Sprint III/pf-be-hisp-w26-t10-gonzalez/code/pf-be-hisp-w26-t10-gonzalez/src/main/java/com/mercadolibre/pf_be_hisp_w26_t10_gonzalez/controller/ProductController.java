package com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.controller;

import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.dtos.ProductUS6Dto;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.dtos.ProductsUS6RequestDto;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.dtos.ProductUS6Response;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.dtos.ProductsGeneralDto;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.entity.Product;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.service.IProductService;
import jakarta.websocket.server.PathParam;
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

    /**
     * @param idSeller id of the seller
     * @param products list of products to insert
     * @return {@link ProductUS6Response}
     */
    @PostMapping("/{idSeller}")
    public ResponseEntity<ProductUS6Response> createProduct(
            @PathVariable("idSeller") Integer idSeller,
            @RequestBody ProductsUS6RequestDto products
    ){
        return ResponseEntity.status(HttpStatus.OK).body(
                productService.insertProducts(products.getProducts(), idSeller));
    }


    /**
     * @param idSeller id of the seller to update
     * @param idProduct id of the product to update
     * @param product product to update
     * @return {@link ProductUS6Response}
     */
    @PutMapping("/{idSeller}/{idProduct}")
    public ResponseEntity<ProductUS6Response> updateProduct(
            @PathVariable("idSeller") Integer idSeller,
            @PathVariable("idProduct") Integer idProduct,
            @RequestBody ProductUS6Dto product
    ){
        return ResponseEntity.status(HttpStatus.OK).body(
                productService.updateProducts(product, idProduct, idSeller));
    }

    /**
     * Return a list of products by a price range
     * @param low low range of the price
     * @param high high range of the price
     * @return {@link List< Product >} list of products
     */
    @GetMapping("/prices")
    public ResponseEntity<?> findByPriceRanges(
           @PathParam("low") Double low,
           @PathParam("high") Double high
    ){
        return ResponseEntity.status(HttpStatus.OK)
                .body(productService.findProductByPriceRange(low, high));
    }

    /**
     * return a list of products by a keyword
     * @param keyword string that reprecents the keyword
     * @return {@link List< Product >} list of products
     */
    @GetMapping("/keyword/{keyword}")
    public ResponseEntity<?> findByKeyword(
            @PathVariable("keyword") String keyword
    ){
        return ResponseEntity.status(HttpStatus.OK)
                .body(productService.findByKeyword(keyword));
    }
}
