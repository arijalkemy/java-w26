package com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.controller;

import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.dto.request.InboundOrderRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.enums.TypeProduct;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.model.UserEntity;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.service.interfaces.IBatchService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/batches")
@RequiredArgsConstructor
public class BatchController {

    private final IBatchService batchService;

    @GetMapping("/batch/list/due-date/{cantDays}")
    public ResponseEntity<?> getBatchInfoDueDate(@PathVariable int cantDays,
                                                 @RequestParam(value = "category", required = false, defaultValue = "All") String category,
                                                 @RequestParam(value = "order", required = false, defaultValue = "date_asc") String order) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        int managerId = ((UserEntity) authentication.getPrincipal()).getId();
        return new ResponseEntity<>(batchService.getBatchStockByProductId(cantDays, managerId, category, order), HttpStatus.OK);
    }

    @PostMapping("/inboundorder")
    public ResponseEntity<?> createInboundOrder(
            @RequestBody @Valid InboundOrderRequestDTO inboundOrderRequestDTO
    ) {
        return new ResponseEntity<>(
                batchService.createInboundOrder(inboundOrderRequestDTO),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/inboundorder")
    public ResponseEntity<?> updateInboundOrder(
            @RequestBody @Valid InboundOrderRequestDTO inboundOrderRequestDTO
    ) {
        return new ResponseEntity<>(
                batchService.updateInboundOrder(inboundOrderRequestDTO),
                HttpStatus.CREATED
        );
    }
}
