package com.mercadolibre.project_java_w26_team13.controller;

import com.mercadolibre.project_java_w26_team13.dtos.request.BatchStockDto;
import com.mercadolibre.project_java_w26_team13.dtos.request.OrderRequestDto;
import com.mercadolibre.project_java_w26_team13.service.IOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    private IOrderService orderService;

    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/api/v1/fresh-products/inboundorder")
    public ResponseEntity<?> registerBatch(@RequestBody OrderRequestDto orderRequestDto, @RequestHeader("Authorization") String authorizationHeader) {
        List<BatchStockDto> batchStockDtoList = orderService.registerBatch(orderRequestDto, authorizationHeader);
        return new ResponseEntity<>(batchStockDtoList, HttpStatus.CREATED);
    }

    @PutMapping("/api/v1/fresh-products/inboundorder")
    public ResponseEntity<?> updateInboundOrder(@RequestBody OrderRequestDto orderRequestDto, @RequestHeader("Authorization") String authorizationHeader) {
        return new ResponseEntity<>(orderService.updateInboundOrder(orderRequestDto, authorizationHeader), HttpStatus.OK);
    }

}
