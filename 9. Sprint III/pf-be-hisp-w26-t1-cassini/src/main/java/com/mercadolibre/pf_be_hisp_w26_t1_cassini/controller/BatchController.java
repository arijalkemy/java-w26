package com.mercadolibre.pf_be_hisp_w26_t1_cassini.controller;


import com.mercadolibre.pf_be_hisp_w26_t1_cassini.Enum.CategoryEnum;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.Enum.OrderTypeEnum;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.authentication.AuthenticationService;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.dtos.*;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.enums.BatchOrderType;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.enums.OrderBatchEnum;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.service.interfaces.IBatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fresh-products/batch")
@RequiredArgsConstructor
public class BatchController {
    private final IBatchService batchService;
    private final AuthenticationService authenticationService;

    @GetMapping("/list/due-date/{cantDays}")
    public ResponseEntity<BatchStockResponseDTO> GetProductCloseToExpiration(@PathVariable Integer cantDays,
                                                                             @RequestParam(required = false) CategoryEnum category,
                                                                             @RequestParam(required = false) OrderTypeEnum order){
        return ResponseEntity.status(HttpStatus.OK).body(batchService
                .getBatchesCloseToExpiration(cantDays, category,order));
    }

    @GetMapping("/{idProduct}/list")
    public ResponseEntity<?> getProductLocation(@PathVariable Integer idProduct,
                                                @RequestParam(name="order",required = false) BatchOrderType batchOrderType){

        String managerEmail = authenticationService.getLogMail();
        return new ResponseEntity<>(batchService.getProductLocation(managerEmail, idProduct,batchOrderType), HttpStatus.OK);
    }

    @GetMapping("{idProduct}/wrongTemperature/list")
    public ResponseEntity<BatchWrongTemperatureRespDTO> GetBatchesWrongTemperature(@PathVariable Integer idProduct,
                                                                                   @RequestParam(required = false) OrderBatchEnum order){
        String managerEmail = authenticationService.getLogMail();
        return ResponseEntity.status(HttpStatus.OK).body(batchService.getBatchesWrongTemperature(idProduct,
                managerEmail,order));
    }

    @PutMapping("{idBatch}")
    public ResponseEntity<BatchStockDTO> updateBatchTemperature(@PathVariable Integer idBatch,
                                                                @RequestBody BatchUpdateTemperatureReqDTO batchUpdateTemperatureReqDTO){
        String email = authenticationService.getLogMail();

        return ResponseEntity.status(HttpStatus.OK).body(batchService.updateBatchTemperature(idBatch,
                batchUpdateTemperatureReqDTO,
                email));
    }
}
