package com.mercadolibre.project_java_w26_team13.controller;

import com.mercadolibre.project_java_w26_team13.service.IBatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BatchController {

    @Autowired
    IBatchService batchService;

    @GetMapping("/api/v1/fresh-products/{idProduct}/warehouse/list")
    public ResponseEntity<?> getProductStockByWarehouse(@PathVariable long idProduct,
                                                        @RequestHeader("Authorization") String authorizationHeader){
        return ResponseEntity.ok().body(batchService.getProductStockByWarehouse(idProduct, authorizationHeader));
    }

    @GetMapping("/api/v1/fresh-products/batch/list/due-date/{cantDays}")
    public ResponseEntity<?> getBatchesDueDate(@PathVariable Integer cantDays,
                                               @RequestHeader("Authorization") String authorizationHeader,
                                               @RequestParam(value = "category", required = false) String category,
                                               @RequestParam(value = "order", required = false) String order) {
        return ResponseEntity.ok(batchService.getBatchesDueDateByCategory(cantDays,authorizationHeader, category, order));
    }

    @GetMapping("/api/v1/fresh-products/{idProduct}/batch/list")
    public ResponseEntity<?> getBatchesByProduct(@PathVariable Long idProduct,
                                                @RequestHeader("Authorization") String authorizationHeader,
                                                @RequestParam(required = false) String order) {
        return ResponseEntity.ok().body(batchService.searchBatchesByProduct(idProduct, order, authorizationHeader));
    }
}
