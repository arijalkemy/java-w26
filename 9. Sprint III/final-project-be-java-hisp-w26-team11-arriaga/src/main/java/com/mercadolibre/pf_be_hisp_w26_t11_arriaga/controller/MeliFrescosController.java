package com.mercadolibre.pf_be_hisp_w26_t11_arriaga.controller;

import com.mercadolibre.pf_be_hisp_w26_t11_arriaga.dto.frescos.*;
import com.mercadolibre.pf_be_hisp_w26_t11_arriaga.dto.frescos.BatchSearchStockResponseDTO;

import com.mercadolibre.pf_be_hisp_w26_t11_arriaga.dto.frescos.PurchaseRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t11_arriaga.model.ProductType;
import com.mercadolibre.pf_be_hisp_w26_t11_arriaga.dto.frescos.*;
import com.mercadolibre.pf_be_hisp_w26_t11_arriaga.dto.frescos.ProductBatchesResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t11_arriaga.dto.frescos.ProductSimpleResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t11_arriaga.exceptions.BadRequestException;
import com.mercadolibre.pf_be_hisp_w26_t11_arriaga.service.IMeliFrescosService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Validated
public class MeliFrescosController {

    @Autowired
    IMeliFrescosService service;

    /**
     * Crea una nueva orden de entrada.
     *
     * @param inboundOrderRequestDTO Objeto que contiene la información de la orden de entrada a crear.
     * @return ResponseEntity<InboundOrderResponseDTO> Objeto que contiene la respuesta HTTP, incluyendo la información de la orden de entrada creada.
     */
    @PostMapping("/fresh-products/inboundorder")
    public ResponseEntity<InboundOrderResponseDTO> createInboundOrder(@RequestBody InboundOrderRequestDTO inboundOrderRequestDTO) {
        // Implementación del método
        return new ResponseEntity<>(service.createInboundOrder(inboundOrderRequestDTO), HttpStatus.CREATED);
    }

    /**
     * Actualiza una orden de entrada existente.
     *
     * @param inboundOrderRequestDTO Objeto que contiene la información de la orden de entrada a actualizar.
     * @return ResponseEntity<InboundOrderResponseDTO> Objeto que contiene la respuesta HTTP, incluyendo la información de la orden de entrada actualizada.
     */
    @PutMapping("/fresh-products/inboundorder")
    public ResponseEntity<InboundOrderResponseDTO> updateInboundOrder(@RequestBody @Valid InboundOrderRequestDTO inboundOrderRequestDTO) {
        // Implementación del método
        return new ResponseEntity<>(service.updateInboundOrder(inboundOrderRequestDTO), HttpStatus.CREATED);
    }

    /**
     * Requerimiento 2: Listar todos los productos y listarlos por categoria
     * @param acronym
     * @return List<ProductSimpleResponseDTO>
     * @throws com.mercadolibre.pf_be_hisp_w26_t11_arriaga.exceptions.NotFoundException
     */

    @GetMapping("/products/list")
    public ResponseEntity<List<ProductSimpleResponseDTO>> listProducts(@RequestParam Optional<String> acronym) {
        return new ResponseEntity<>(
                service.listProducts(acronym),
                HttpStatus.OK
        );
    }


    /**
     * Requerimiento 2: Registrar una orden de Venta nueva
     * @param purchaseRequestDTO
     * @return ResponseEntity<PurchaseReponseDTO>
     * @throws BadRequestException
     */
    @PostMapping("/fresh-products/orders")
    public ResponseEntity<PurchaseResponseDTO> registerOrder(@Valid @RequestBody PurchaseRequestDTO purchaseRequestDTO) {
        if (purchaseRequestDTO == null || purchaseRequestDTO.getPurchaseOrder() == null) {
            throw new BadRequestException("The request payload is empty.");
        }

        return new ResponseEntity<>(service.registerPurchaseOrder(purchaseRequestDTO), HttpStatus.CREATED);
    }

    /**
     * Requerimiento 2: Liastar los productos que hay en determinada orden de compra
     * @param orderId
     * @return List<ProductSimpleResponseDTO>
     * @throws com.mercadolibre.pf_be_hisp_w26_t11_arriaga.exceptions.NotFoundException
     */
    @GetMapping("/fresh-products/orders/{orderId}")
    public ResponseEntity<List<ProductSimpleResponseDTO>> listOrderProducts(@PathVariable Integer orderId) {
        return new ResponseEntity<>(
                service.listProductsFromOrder(orderId),
                HttpStatus.OK
        );
    }

    /**
     * Requerimiento 2: Actualizar una orden de Venta nueva
     * @param purchaseRequestDTO
     * @return purchaseResponseDTO
     * @throws BadRequestException
     */
    @PutMapping("/fresh-products/orders")
    public ResponseEntity<PurchaseResponseDTO> updateOrder(@Valid @RequestBody PurchaseRequestDTO purchaseRequestDTO) {
        if (purchaseRequestDTO == null || purchaseRequestDTO.getPurchaseOrder() == null) {
            throw new BadRequestException("The request payload is empty.");
        }

        return new ResponseEntity<>(service.updatePurchaseOrder(purchaseRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping("/fresh-products/{productId}/batch/list")
    public ResponseEntity<ProductBatchesResponseDTO> listBatchesOfProduct(@PathVariable Integer productId, @RequestParam(required = false) String order) {
        ProductBatchesResponseDTO response = service.listBatchesOfProduct(productId, Optional.ofNullable(order));
        return ResponseEntity.ok(response);
    }



    @GetMapping("/fresh-products/{idProduct}/warehouse/list")
    public ResponseEntity<?> listProductStockByWarehouse(@PathVariable Integer idProduct) {
        return ResponseEntity.ok(service.listProductStockByWarehouse(idProduct));
    }

    @GetMapping("/fresh-products/batch/list/due-date/{cantDays}")
    public BatchSearchStockResponseDTO listOrderedDueDateProducts(
            @PathVariable @Min(value = 0, message = "El numero de días debe ser positivo") Integer cantDays,
            @RequestParam(required = false) @Pattern(regexp = "FS|RF|FF", message = "Categoria invalida. Bebe ser: FS, RF, FF.") String category,
            @RequestParam(required = false) @Pattern(regexp = "date_asc|date_desc", message = "Orden invalido. Debe ser: date_asc, date_desc.") String order) {
        BatchSearchStockResponseDTO response = service.listOrderedDueDateProducts(
                cantDays, Optional.ofNullable(category), Optional.ofNullable(order));
        return ResponseEntity.ok(response).getBody();
    }


    @GetMapping("/fresh-products/inboundorder/{inboundorderId}")
    public ResponseEntity<List<BatchStockInboundOrderResponseDto>> getInboundOrder(@PathVariable Integer inboundorderId) {
        return new ResponseEntity<>(service.getInboudOrder(inboundorderId), HttpStatus.OK);
    }

    @GetMapping("fresh-products/warehouse/{warehouseId}")
    public ResponseEntity<RepresentativeResponseDTO> getRepresentativeByWarehouseCode(@PathVariable Integer warehouseId) {
        return new ResponseEntity<>(service.getRepresentativeByCodeWarehouse(warehouseId), HttpStatus.OK);
    }
}
