package com.mercadolibre.project_be_java_hisp_w26_t7.controller;

import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.others.TotalPriceResponseDTO;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.product.ProductResponseDTO;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.product.PurchaseOrderRequestDTO;
import com.mercadolibre.project_be_java_hisp_w26_t7.service.interfaces.IOrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fresh-products/orders")
@PreAuthorize("hasRole('ROLE_BUYER')")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    /**
     * US-code: ml-add-products-to-cart-01
     * <p>
     * Crea una orden con la lista de productos que componen la PurchaseOrder. Calcula el precio final
     * y lo devuelve junto con el código de estado "201 CREADO".
     * Si un producto no tiene stock, notifica la situación devolviendo un error por producto, no a nivel de orden.
     *
     * @param purchaseOrderRequestDTO El objeto PurchaseOrderRequestDTO que contiene los detalles de la orden de compra.
     * @return ResponseEntity que contiene el objeto TotalPriceResponseDTO que representa el precio total calculado y
     * el código de estado "201 CREADO".
     */
    @PostMapping
    public ResponseEntity<TotalPriceResponseDTO> createProductList(
            @RequestBody @Valid PurchaseOrderRequestDTO purchaseOrderRequestDTO
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.saveProductList(purchaseOrderRequestDTO));
    }

    /**
     * US-code: ml-add-products-to-cart-01
     * <p>
     * Muestra los productos en la orden especificada por su identificador.
     *
     * @param idOrder El identificador de la orden.
     * @return ResponseEntity que contiene una lista de objetos ProductResponseDTO representando los productos en la
     * orden y el código de estado "200 OK".
     */
    @GetMapping("/{idOrder}")
    public ResponseEntity<List<ProductResponseDTO>> getProductsByOrder(@PathVariable Long idOrder) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.findProductsByOrder(idOrder));
    }

    /**
     * US-code: ml-add-products-to-cart-01
     * <p>
     * Modificar una orden existente de tipo carrito.
     *
     * @param purchaseOrderRequestDTO El objeto PurchaseOrderRequestDTO que contiene los detalles de la orden de compra.
     * @param idOrder                 El identificador de la orden que se va a modificar.
     * @return ResponseEntity que contiene un TotalPriceResponseDTO con el precio total calculado y el código de
     * estado "201 Creado".
     */
    @PutMapping("/{idOrder}")
    public ResponseEntity<TotalPriceResponseDTO> updateProductList(
            @RequestBody @Valid PurchaseOrderRequestDTO purchaseOrderRequestDTO, @PathVariable Long idOrder
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                orderService.updateProductList(idOrder, purchaseOrderRequestDTO)
        );
    }

}
