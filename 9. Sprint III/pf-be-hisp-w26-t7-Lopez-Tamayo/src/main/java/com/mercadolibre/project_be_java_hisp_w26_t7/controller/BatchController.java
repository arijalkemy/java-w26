package com.mercadolibre.project_be_java_hisp_w26_t7.controller;

import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.batch.BatchStockListResponseDTO;
import com.mercadolibre.project_be_java_hisp_w26_t7.util.OrderEnum;
import com.mercadolibre.project_be_java_hisp_w26_t7.util.StorageTypeEnum;
import com.mercadolibre.project_be_java_hisp_w26_t7.service.interfaces.IBatchService;
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
   
    @Autowired
    private IBatchService batchService;

    /**
     * US-code: ml-check- batch-stock-due-date-01
     *
     * Obtiene todos los lotes próximos a vencer entre hoy y la cantidad de días posteriores.
     * El ordenamiento por fecha de vencimiento es opcional. Filtrar por categoría de producto es opcional.
     *
     * Parámetros opcionales:
     * - category: Categoría del producto (FS=Fresco, RF=Refrigerado, FF=Congelado).
     * - order: Orden de los resultados por fecha de vencimiento (date_asc, date_desc).
     *
     * Si no se encuentran lotes próximos a vencer, debe devolver un “404 Not Found”.
     *
     * @param cantDays La cantidad de días a partir de hoy para buscar lotes próximos a vencer.
     * @param category (Opcional) La categoría de producto para filtrar los lotes.
     * @param order (Opcional) El orden de los resultados por fecha de vencimiento.
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
    
        return ResponseEntity.status(HttpStatus.OK).body(batchService.findBatchesNearExpiry(cantDays, category, order, Integer.parseInt(userDetails.getUsername()) ));
    }

}
