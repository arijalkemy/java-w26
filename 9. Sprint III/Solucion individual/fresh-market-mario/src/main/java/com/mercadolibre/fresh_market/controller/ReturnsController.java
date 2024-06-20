package com.mercadolibre.fresh_market.controller;

import com.mercadolibre.fresh_market.dtos.*;
import com.mercadolibre.fresh_market.service.IReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fresh-products/returns")
public class ReturnsController {

    @Autowired
    IReturnService returnService;

    @PostMapping("")
    public ResponseEntity<ResponseCreateReturnDTO> createReturn(@RequestBody RequestReturnDTO requestReturnDTO) {
        ResponseCreateReturnDTO responseCreateReturnDTO = returnService.createReturn(requestReturnDTO);
        return ResponseEntity.ok(responseCreateReturnDTO);
    }

    @GetMapping("")
    public ResponseEntity<List<ResponseReturnsDTO>> getAllreturns(@RequestParam(required = false, defaultValue = "ALL") String status) {
        List<ResponseReturnsDTO> returns = returnService.getAllReturnsByStatus(status);
        return ResponseEntity.ok(returns);
    }

    @PutMapping("/{returnId}")
    public ResponseEntity<ResponseUpdateReturnStatusDTO> updateReturnStatus(@PathVariable Long returnId, @RequestBody RequestUpdateReturnStatusDTO requestUpdateReturnStatusDTO) {
        ResponseUpdateReturnStatusDTO responseUpdateReturnStatusDTO = returnService.updateReturnStatus(returnId, requestUpdateReturnStatusDTO);
        return ResponseEntity.ok(responseUpdateReturnStatusDTO);
    }

    @GetMapping("/{returnId}")
    public ResponseEntity<ResponseReturnsDTO> getReturnById(@PathVariable Long returnId) {
        ResponseReturnsDTO responseReturnsDTO = returnService.getReturnById(returnId);
        return ResponseEntity.ok(responseReturnsDTO);
    }
}