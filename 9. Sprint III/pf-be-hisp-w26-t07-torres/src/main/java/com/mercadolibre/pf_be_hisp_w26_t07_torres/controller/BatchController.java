package com.mercadolibre.pf_be_hisp_w26_t07_torres.controller;

import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.batch.BatchStockDTO;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.batch.BatchStockListResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.batch.BatchTemperatureDTO;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.service.interfaces.IBatchService;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.util.enums.OrderEnum;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.util.enums.StorageTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fresh-products/batch")
public class BatchController {

    @Autowired
    private IBatchService batchService;

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

    @GetMapping("/list/temperature-difference")
    @PreAuthorize("hasRole('ROLE_REPRESENTATIVE')")
    public ResponseEntity<List<BatchTemperatureDTO>> getBatchesWithTemperatureDifference() {
        List<BatchTemperatureDTO> batches = batchService.getBatchesWithTemperatureDifference();
        return ResponseEntity.ok(batches);
    }

    @GetMapping("/list/low-stock")
    @PreAuthorize("hasRole('ROLE_REPRESENTATIVE')")
    public ResponseEntity<List<BatchStockDTO>> getBatchesLowStock() {
        List<BatchStockDTO> batches = batchService.getBatchesLowStock();
        return ResponseEntity.ok(batches);
    }
}
