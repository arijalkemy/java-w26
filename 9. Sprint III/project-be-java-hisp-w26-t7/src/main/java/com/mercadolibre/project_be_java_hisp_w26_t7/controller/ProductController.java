package com.mercadolibre.project_be_java_hisp_w26_t7.controller;

import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.product.LocationForProductDTO;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.product.ProductResponseDTO;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.warehouse.StockQuantityResponseDto;
import com.mercadolibre.project_be_java_hisp_w26_t7.service.interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fresh-products")
public class ProductController {

    @Autowired
    private IProductService productService;

    /**
     * US-code: ml-add-products-to-cart-01
     * <p>
     * Obtener una lista de productos según la categoría especificada o todos los productos si no se proporciona
     * ninguna categoría.
     * <p>
     * Parámetro de categoría:
     * - FS: Fresco
     * - RF: Refrigerado
     * - FF: Congelado
     * <p>
     * Si la lista de productos no existe para la categoría especificada, se devuelve un código de estado
     * "404 Not Found".
     *
     * @param category (Opcional) La categoría de los productos que se desean obtener.
     * @return Un ResponseEntity que contiene la lista de productos y un código de estado correspondiente.
     */
    @GetMapping("/list")
    @PreAuthorize("hasRole('ROLE_BUYER')")
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts(@RequestParam(required = false) String category) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProducts(category));
    }

    /**
     * US-code: ml-check-product-location-in-warehouse-01
     * <p>
     * Obtener una lista de lotes que contienen el producto especificado. La lista puede estar ordenada por lote,
     * cantidad actual o fecha de vencimiento, según el parámetro de orden.
     * <p>
     * Parámetros de orden:
     * - L: Ordenado por lote.
     * - C: Ordenado por cantidad actual.
     * - F: Ordenado por fecha de vencimiento.
     * <p>
     * Si la lista de lotes no existe para el producto especificado, se devuelve un código de estado "404 Not Found".
     *
     * @param idProduct El identificador del producto del cual se desea obtener la lista de lotes.
     * @param order     (Opcional) El parámetro de orden para ordenar la lista de lotes. Puede ser 'L', 'C' o 'F'.
     * @return Un ResponseEntity que contiene la lista de lotes y un código de estado correspondiente.
     */
    @GetMapping("/{idProduct}/batch/list")
    @PreAuthorize("hasRole('ROLE_REPRESENTATIVE')")
    public ResponseEntity<LocationForProductDTO> getBatchListByProduct(
            @PathVariable
            Long idProduct,
            @RequestParam(required = false) String order
    ) {
        LocationForProductDTO response = productService.checkLocationForProduct(idProduct, order);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    /**
     * US-code: ml-check- product-stock in-warehouses-01
     * <p>
     * Obtener la cantidad total de stock de un producto por cada warehouse.
     * <p>
     * Si el producto no existe en ningún warehouse, debe devolver un “404 Not Found”.
     *
     * @param idProduct El ID del producto para el cual se desea obtener la cantidad de stock.
     * @return ResponseEntity que contiene un StockQuantityResponseDto con la cantidad total de stock para cada almacén.
     */
    @GetMapping("/{idProduct}/warehouse/list")
    @PreAuthorize("hasRole('ROLE_BUYER')")
    public ResponseEntity<StockQuantityResponseDto> getStockQuantityForEachWarehouse(
            @PathVariable Long idProduct) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.findStockQuantityForEachWarehouse(idProduct));
    }
}
