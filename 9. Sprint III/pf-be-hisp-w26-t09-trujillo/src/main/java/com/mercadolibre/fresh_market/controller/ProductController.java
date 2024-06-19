package com.mercadolibre.fresh_market.controller;

import com.mercadolibre.fresh_market.dtos.OperationResponseDTO;
import com.mercadolibre.fresh_market.dtos.ProductDetailDTO;
import com.mercadolibre.fresh_market.dtos.ProductStockDTO;
import com.mercadolibre.fresh_market.dtos.PurchaseOrderDTO;
import com.mercadolibre.fresh_market.service.IProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fresh-products")
public class ProductController {

    @Autowired
    private IProductService productService;

    /**
     * Retrieves the stock information for a specific product across all warehouses.
     * This method handles GET requests to the specified endpoint, calls the product service
     * to get the stock details, and returns the stock information as a ResponseEntity.
     *
     * @param idProduct The ID of the product to retrieve the stock for.
     * @return A ResponseEntity containing a ProductStockDTO object with the stock details
     *         of the specified product.
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
    public ResponseEntity<ProductStockDTO> getStockByProductAndWarehouse(@PathVariable Long idProduct)
    {
        ProductStockDTO productStockDTO = productService.getProductStock(idProduct);
        return ResponseEntity.ok(productStockDTO);
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
    public ResponseEntity<List<ProductDetailDTO>> getProducts(@RequestParam(required = false) String category)
    {
        if(category != null){
            return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProductsByCategory(category));
        } else{
            return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProducts());
        }
    }

    @Operation(summary = "Create a product list")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully retrieved operation resume",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ProductDetailDTO.class))}),
            @ApiResponse(responseCode = "403", description = "User has no permissions to modify the order", content = @Content)
    })
    @PostMapping("/{idSeller}")
    public ResponseEntity<OperationResponseDTO> postCreateProduct(@PathVariable Long idSeller, @RequestBody List<ProductDetailDTO> productsDetailDTO)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(productsDetailDTO, idSeller));
    }

    @Operation(summary = "Update a product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved operation resume",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ProductDetailDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Product not found", content = @Content),
            @ApiResponse(responseCode = "403", description = "User has no permissions to modify the order", content = @Content)
    })
    @PutMapping("/{idSeller}/{idProduct}")
    public ResponseEntity<OperationResponseDTO> postCreateProduct(@PathVariable Long idSeller,@PathVariable Long idProduct, @RequestBody ProductDetailDTO productDetailDTO)
    {
        return ResponseEntity.status(HttpStatus.OK).body(productService.updateProduct(idSeller, idProduct, productDetailDTO));
    }
}