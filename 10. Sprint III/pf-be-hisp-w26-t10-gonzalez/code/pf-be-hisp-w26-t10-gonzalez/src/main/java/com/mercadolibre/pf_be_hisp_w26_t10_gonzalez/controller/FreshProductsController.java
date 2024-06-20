package com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.controller;

import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.dtos.*;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.dtos.order.PurchaseOrderRequestBodyDto;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.entity.Product;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.service.IProductService;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.service.implementations.ShoppingCartServiceImpl;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.service.implementations.BatchServiceImpl;
import jakarta.validation.Valid;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.service.implementations.FrescosServiceImpl;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fresh-products/")
public class FreshProductsController {

    @Autowired
    FrescosServiceImpl frescosService;
    @Autowired
    BatchServiceImpl batchService;


    ShoppingCartServiceImpl shoppingCartService;
    public FreshProductsController(@Autowired ShoppingCartServiceImpl shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping("batch/list/due-date/{cantDays}")
    public ResponseEntity<?> getBatchExpiringInDaysOrdered(@PathVariable Integer cantDays, @RequestParam(required = false) String category, @RequestParam(required = false) String order) {
        return ResponseEntity.status(HttpStatus.OK).body(batchService.findBatchesByDueDateAndCategory(cantDays, category, order));
    }

    @PutMapping("/orders/{idOrder}")
    public ResponseEntity<?> modifyOrder(
        @PathVariable("idOrder") Integer idOrder,
        @RequestBody PurchaseOrderRequestBodyDto purchaseOrder
    ){
        return new ResponseEntity<>(shoppingCartService
                .modifyPurchaseOrder(idOrder, purchaseOrder),
                HttpStatus.OK
        );
    }

    @PostMapping("inboundorder")
    public ResponseEntity<BatchResponseDto> addBatchIntoStock(@RequestBody @Valid UploadBatchRequestDto uploadBatchRequestDto) {
        return new ResponseEntity<BatchResponseDto>(batchService.uploadBatchIntoStock(uploadBatchRequestDto), HttpStatus.CREATED);
    }

    @PutMapping("inboundorder")
    public ResponseEntity<BatchResponseDto> updateBatchStock(@RequestBody @Valid UploadBatchRequestDto uploadBatchRequestDto){
        return new ResponseEntity<BatchResponseDto>(batchService.updateBatchInStock(uploadBatchRequestDto), HttpStatus.CREATED);
    }

    /**
     * US-2-ISSUE-6 View products from cart
     * @param idOrder
     * @return
     */
    @GetMapping("/orders/{idOrder}")
    public ResponseEntity<?> getProductsFromCart(@PathVariable("idOrder") Integer idOrder) {
        return new ResponseEntity<>(frescosService.getProductsFromShoppingCart(idOrder), HttpStatus.OK);
    }

    /**
     * US-2-ISSUE-5
     *Implementacion del controlador para crear nuevas ordenes
     */
    @PostMapping("/orders")
    public ResponseEntity<?> saveOrder(@RequestBody PurchaseOrderDto order){
        return new ResponseEntity<>(frescosService.createOrder(order), HttpStatus.CREATED);
    }
}



