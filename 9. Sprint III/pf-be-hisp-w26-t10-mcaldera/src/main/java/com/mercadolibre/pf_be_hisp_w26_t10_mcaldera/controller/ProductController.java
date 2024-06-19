package com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.controller;

import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.dtos.ProductInfoDto;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.dtos.ProductListDto;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.dtos.ProductsGeneralDto;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.service.IProductService;
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
    public ResponseEntity<List<ProductsGeneralDto>> getAllProducts() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(productService.getProducts());
    }

    /**
     * Create new products
     *
     * @param idSeller       Seller identifier
     * @param productListDto Products list
     * @return Response
     */
    @PreAuthorize("hasRole('SELLER')")
    @PostMapping("/{idSeller}")
    public ResponseEntity<?> createProductCrud(@PathVariable String idSeller, @RequestBody ProductListDto productListDto) {
        return new ResponseEntity<>(productService.createProductCrud(productListDto, idSeller), HttpStatus.OK);
    }

    /**
     * Modify products
     *
     * @param idSeller       Seller identifier
     * @param idProduct      Product identifier
     * @param productInfoDto Object
     * @return Response
     */
    @PreAuthorize("hasRole('SELLER')")
    @PutMapping("/{idSeller}/{idProduct}")
    public ResponseEntity<?> changeProductInfo(@PathVariable String idSeller, @PathVariable Integer idProduct, @RequestBody ProductInfoDto productInfoDto) {
        return new ResponseEntity<>(productService.changeProduct(idSeller, idProduct, productInfoDto), HttpStatus.OK);
    }

    /**
     * Get all products
     *
     * @return Response object
     */
    @PreAuthorize("hasRole('SELLER')")
    @GetMapping("/list-items-seller")
    public ResponseEntity<?> getAllProductSeller() {
        return new ResponseEntity<>(productService.getAllProductSellerInfo(), HttpStatus.OK);
    }

    /**
     * Remove products
     *
     * @param idSeller  Seller identifier
     * @param idProduct Product identifier
     * @return Response
     */
    @PreAuthorize("hasRole('SUPERVISOR')")
    @DeleteMapping("/{idSeller}/delete/{idProduct}")
    public ResponseEntity<?> removeProductBySeller(@PathVariable String idSeller, @PathVariable Integer idProduct) {
        return new ResponseEntity<>(productService.removeProductsBySeller(idSeller, idProduct), HttpStatus.ACCEPTED);
    }

}
