package com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.controller;

import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.dtos.BatchResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.dtos.PurchaseOrderDto;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.dtos.UploadBatchRequestDto;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.dtos.order.PurchaseOrderRequestBodyDto;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.service.implementations.BatchServiceImpl;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.service.implementations.FrescosServiceImpl;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.service.implementations.ShoppingCartServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
