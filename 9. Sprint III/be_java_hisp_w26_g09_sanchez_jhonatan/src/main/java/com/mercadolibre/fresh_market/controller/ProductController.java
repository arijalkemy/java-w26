package com.mercadolibre.fresh_market.controller;

import com.mercadolibre.fresh_market.dtos.product.ProductDetailDTO;
import com.mercadolibre.fresh_market.dtos.ProductStockDTO;
import com.mercadolibre.fresh_market.dtos.PurchaseOrderDTO;
import com.mercadolibre.fresh_market.dtos.product.ProductReqDTO;
import com.mercadolibre.fresh_market.dtos.product.ProductResDTO;
import com.mercadolibre.fresh_market.service.IProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fresh-products")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    /**
     * Retrieves the stock information for a specific product across all warehouses.
     * This method handles GET requests to the specified endpoint, calls the product service
     * to get the stock details, and returns the stock information as a ResponseEntity.
     *
     * @param idProduct The ID of the product to retrieve the stock for.
     * @return A ResponseEntity containing a ProductStockDTO object with the stock details
     * of the specified product.
     */
    @Operation(summary = "Get stock by product and warehouse")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the stock information",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = PurchaseOrderDTO.class))}),
            @ApiResponse(responseCode = "403", description = "User has no permissions to modify the order", content = @Content)
    })
    @GetMapping("/{idProduct}/warehouse/list")
    public ResponseEntity<ProductStockDTO> getStockByProductAndWarehouse(@PathVariable Long idProduct) {
        return ResponseEntity.ok().body(productService.getProductStock(idProduct));
    }


    @Operation(summary = "Get product list")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the product list",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ProductDetailDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Product list not found", content = @Content),
            @ApiResponse(responseCode = "403", description = "User has no permissions to modify the order", content = @Content)
    })
    @GetMapping("/list")
    public ResponseEntity<List<ProductDetailDTO>> getProducts(@RequestParam(required = false) String category) {
        if (category == null)
            return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProducts());

        return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProductsByCategory(category));
    }


    @PostMapping("/{idSeller}")
    @Operation(summary = "Save a new product for a seller")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully created the product",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ProductResDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid input data", content = @Content),
            @ApiResponse(responseCode = "403", description = "User has no permissions to create a product for this seller", content = @Content),
            @ApiResponse(responseCode = "404", description = "Seller not found", content = @Content),
            @ApiResponse(responseCode = "409", description = "Products already exists", content = @Content)
    })
    public ResponseEntity<ProductResDTO> saveProductSeller(@PathVariable Long idSeller,
                                                           @RequestBody @Valid ProductReqDTO productReqDTO){
        ProductResDTO productResDTO = productService.createProducts(productReqDTO, idSeller);
        return ResponseEntity.status(productResDTO.getCode()).body(productResDTO);
    }

    @PutMapping("{idSeller}/{idProduct}")
    @Operation(summary = "Update an existing product for a seller")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated the product",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ProductResDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid input data", content = @Content),
            @ApiResponse(responseCode = "403", description = "User has no permissions to update the product for this seller", content = @Content),
            @ApiResponse(responseCode = "404", description = "Product or seller not found", content = @Content)
    })
    public ResponseEntity<ProductResDTO> updateProductSeller(@PathVariable Long idSeller,
                                                             @PathVariable Long idProduct,
                                                             @RequestBody @Valid ProductDetailDTO productDetailDTO){
        ProductResDTO productResDTO = productService.updateProduct(productDetailDTO, idSeller, idProduct);
        return ResponseEntity.status(productResDTO.getCode()).body(productResDTO);
    }

}