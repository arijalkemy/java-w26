package com.mercadolibre.sprint_3_team_12.controller;

import com.mercadolibre.sprint_3_team_12.enums.Category;
import com.mercadolibre.sprint_3_team_12.service.IBatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fresh-products/")
public class BatchController {
    /**To req 3, req 4 and req 5
     *
     */
    @Autowired
    IBatchService batchService;

    /**
     * Get a Batches for a determinated Warehouse (Prepared to different Warehouse, for this example only warehouse 1).
     *
     * @Param cantDays. Days to expire.
     * @return ResponseBatchDueDTO contain a list of BatchDueDTO.
     * @throws ApiExpection Error:"Not Found",
     *  Message: "No se encontraron productos con las características solicitadas",
     *  Status code: 404);
     *
     */
    @GetMapping("/batch/list/due-date/{cantDays}")
    ResponseEntity<?> getDueBatchesByDays(@PathVariable Integer cantDays){
        return new ResponseEntity<>(batchService.getDueBatchesByDays(cantDays), HttpStatus.OK);
    }
    @GetMapping("{idProduct}/batch/list")
    ResponseEntity<?> getWareHouse(@PathVariable long idProduct, @RequestParam(required = false) String order){
        return  ResponseEntity.ok(batchService.getWarehouseStockByProductIDOrdered(idProduct,order));
    }

    @GetMapping("{idProduct}/warehouse/list")
    ResponseEntity<?> getAllWarehouseStock(@PathVariable long idProduct){
        return ResponseEntity.ok(batchService.getAllWarehousesByProductID(idProduct));
    }

    /**
     * US 05 (Leonardo):
     * ml-check-batch-stock-due-date-01. Consult the products in stock that are about to expire
     * in a certain warehouse, between today and the number of days after ordered by expiration date.
     * That belong to a certain product category.
     * @param cantDays Number of days until expiration.
     * @param category Category of the products.
     * @param order Order of the results (ascending or descending).
     * @return ResponseEntity with the list of product batches nearing expiration.
     */
    @GetMapping("/batch/list/due-date/f/{cantDays}")
    public ResponseEntity<?> getDueBatchesByDaysAndCategory(
            @PathVariable Integer cantDays,
            @RequestParam Category category,
            @RequestParam String order) {
        return new ResponseEntity<>(batchService.getDueBatchesByDaysAndCategory(cantDays, category, order), HttpStatus.OK);
    }

}
