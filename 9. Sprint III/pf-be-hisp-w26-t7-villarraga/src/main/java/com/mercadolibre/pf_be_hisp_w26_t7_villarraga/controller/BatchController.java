package com.mercadolibre.pf_be_hisp_w26_t7_villarraga.controller;

import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.batch.BatchStockListResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.service.interfaces.IBatchService;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.util.enums.OrderEnum;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.util.enums.StorageTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fresh-products/batch")
public class BatchController {

    private final IBatchService batchService;

    public BatchController(@Autowired IBatchService batchService) {
        this.batchService = batchService;
    }

    /**
     * US-code: ml-check- batch-stock-due-date-01
     * <p>
     * Obtiene todos los lotes próximos a vencer entre hoy y la cantidad de días posteriores.
     * El ordenamiento por fecha de vencimiento es opcional. Filtrar por categoría de producto es opcional.
     * <p>
     * Parámetros opcionales:
     * - category: Categoría del producto (FS=Fresco, RF=Refrigerado, FF=Congelado).
     * - order: Orden de los resultados por fecha de vencimiento (date_asc, date_desc).
     * <p>
     * Si no se encuentran lotes próximos a vencer, debe devolver un “404 Not Found”.
     *
     * @param cantDays La cantidad de días a partir de hoy para buscar lotes próximos a vencer.
     * @param category (Opcional) La categoría de producto para filtrar los lotes.
     * @param order    (Opcional) El orden de los resultados por fecha de vencimiento.
     * @return ResponseEntity con un BatchStockListResponseDTO que contiene la lista de lotes próximos a vencer.
     */
    @GetMapping("/list/due-date/{cantDays}")
    @PreAuthorize("hasRole('ROLE_REPRESENTATIVE')")
    public ResponseEntity<BatchStockListResponseDTO> getBatchesNearExpiry(
            @PathVariable Integer cantDays,
            @RequestParam(required = false) StorageTypeEnum category,
            @RequestParam(required = false) OrderEnum order,
            @AuthenticationPrincipal UserDetails userDetails
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(batchService.findBatchesNearExpiry(cantDays, category, order, Integer.parseInt(userDetails.getUsername())));
    }

    /**
     * calcular el promedio de temperatura en el que se encuentra en batch
     * @param sectionId id de la seccion a consultar
     * @return
     */
    @PreAuthorize("hasRole('ROLE_REPRESENTATIVE')")
    @GetMapping("/section/{sectionId}/temperature-average")
    public ResponseEntity<?> getBatchAverage(@PathVariable Long sectionId) {
        return ResponseEntity.status(HttpStatus.OK).body(batchService.getBatchAverage(sectionId));
    }
}
