package com.mercadolibre.pf_be_hisp_w26_t10_garcia.controller;


import com.mercadolibre.pf_be_hisp_w26_t10_garcia.dtos.ProductSellerRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.dtos.ProductUpdateRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.dtos.ProductsRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.entity.Product;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.service.implementations.ProductServiceImpl;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.service.implementations.SearchServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/fresh-products/")
public class FrescosController {

    @Autowired
    private SearchServiceImp searchServiceImp;

    @Autowired
    private ProductServiceImpl productServiceImpl;
    /**
     * US-03: supports filtered and unfiltered searches
     * @param idProduct
     * @param order
     * @return
     */
    @PreAuthorize("hasRole('SUPERVISOR')")
    @GetMapping("/{idProduct}/batch/list")
    public ResponseEntity<?> getProductBatches(@PathVariable Integer idProduct, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(searchServiceImp.searchProduct(idProduct, order), HttpStatus.OK);
    }

    /**
     * Create products seller´s products
     * @param idSeller
     * @param products
     * @return
     */
    @PreAuthorize("hasRole('SELLER')")
    @PostMapping("/products/{idSeller}")
    public ResponseEntity<?> addProduct(@PathVariable Long idSeller, @RequestBody ProductsRequestDTO products) {
        return new ResponseEntity<>(productServiceImpl.saveProducts(products, idSeller), HttpStatus.CREATED);
    }

    /**
     * updates a vendor's product
     * @param idSeller
     * @param idProduct
     * @param product
     * @return
     */
    @PreAuthorize("hasRole('SELLER')")
    @PutMapping("/{idSeller}/{idProduct}")
    public ResponseEntity<?> updateProduct(@PathVariable Long idSeller, @PathVariable Integer idProduct, @RequestBody ProductSellerRequestDTO product ) {
        return new ResponseEntity<>(productServiceImpl.update(idProduct, idSeller, product), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('SELLER')")
    @PutMapping("/{idSeller}")
    public ResponseEntity<?> updatesProduct(@PathVariable Long idSeller, @RequestBody ProductUpdateRequestDTO products ) {
        return new ResponseEntity<>(productServiceImpl.updateProducts(products, idSeller), HttpStatus.OK);
    }

    /**
     * List the products of a seller
     * @param idSeller
     * @return
     */
    @GetMapping("/seller/list/{idSeller}")
    public ResponseEntity<?> getFescos(@PathVariable Long idSeller) {
        return new ResponseEntity<>(productServiceImpl.findProductBySellerId(idSeller), HttpStatus.OK);
    }


}
