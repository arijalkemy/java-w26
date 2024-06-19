package com.mercadolibre.project_be_java_hisp_w26_t7.controller;

import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.batch.BatchStockResponseDTO;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.others.InboundorderRequestDTO;
import com.mercadolibre.project_be_java_hisp_w26_t7.service.interfaces.IInboundorderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fresh-products")
public class InboundorderController {

    private final IInboundorderService inboundorderService;

    public InboundorderController(@Autowired IInboundorderService inboundorderService) {
        this.inboundorderService = inboundorderService;
    }

    /**
     * US-code: ml-insert-batch-in-fulfillment-warehouse-01
     * <p>
     * Crea un nuevo lote en el almacén de cumplimiento con el stock de productos especificado.
     * Devuelve el nuevo lote con un código de estado "201 CREATED".
     *
     * @param inboundOrderRequestDTO El objeto que contiene la información del pedido entrante y los detalles del lote.
     * @return ResponseEntity que contiene el objeto BatchStockResponseDTO que representa la respuesta del nuevo lote
     * creado y el código de estado "201 CREATED".
     */
    @PostMapping("/inboundorder")
    @PreAuthorize("hasRole('ROLE_REPRESENTATIVE')")
    public ResponseEntity<BatchStockResponseDTO> createInboundorder(
            @RequestBody @Valid InboundorderRequestDTO inboundOrderRequestDTO
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                inboundorderService.saveInboundorder(inboundOrderRequestDTO)
        );
    }

    /**
     * US-code: ml-insert-batch-in-fulfillment-warehouse-01
     * <p>
     * En el caso de que el lote ya exista y deba ser actualizado, esta operación actualiza el stock del lote existente.
     * Devuelve el stock actualizado con un código de estado "201 CREATED".
     *
     * @param inboundOrderRequestDTO El objeto que contiene la información del pedido entrante y los detalles del lote.
     * @return BatchStockResponseDTO El objeto que representa la respuesta del lote actualizado.
     */
    @PutMapping("/inboundorder")
    @PreAuthorize("hasRole('ROLE_REPRESENTATIVE')")
    public ResponseEntity<BatchStockResponseDTO> updateInboundorder(
            @RequestBody @Valid InboundorderRequestDTO inboundOrderRequestDTO
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                inboundorderService.updateInboundorder(inboundOrderRequestDTO)
        );
    }
}
