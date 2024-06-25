package com.mercadolibre.pf_be_hisp_w26_t4_aquino.controller;

import com.mercadolibre.pf_be_hisp_w26_t4_aquino.dtos.request.InboundOrderRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t4_aquino.model.User;
import com.mercadolibre.pf_be_hisp_w26_t4_aquino.service.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.http.HttpStatus;
import com.mercadolibre.pf_be_hisp_w26_t4_aquino.dtos.response.WarehouseProductStockDTO;
import com.mercadolibre.pf_be_hisp_w26_t4_aquino.dtos.response.ProductLocationDto;
import com.mercadolibre.pf_be_hisp_w26_t4_aquino.service.IFreshProductService;
import com.mercadolibre.pf_be_hisp_w26_t4_aquino.util.BatchOrder;
import java.util.List;
import com.mercadolibre.pf_be_hisp_w26_t4_aquino.dtos.request.PurchaseOrderRequestDTO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/fresh_products")
@RequiredArgsConstructor
@Validated
public class FreshProductController {

    private final IBatchService batchService;
    private final IFreshProductService freshProductService;
    private final IProductService productService;
    private final IProductOrderService productOrderService;

    @GetMapping("/batch/list/due-date/{cantDays}")
    @PreAuthorize("hasAuthority('manager')")
    public ResponseEntity<?> getBatchListByDueDate(@PathVariable int cantDays) {
        return new ResponseEntity<>(batchService.getBatchesByDueDate(cantDays), HttpStatus.OK);
    }

    @GetMapping("/batch/list/due-date2/{cantDays}")
    @PreAuthorize("hasAuthority('manager')")
    public ResponseEntity<?> getBatchListByCategoryOrderByDueDate(@PathVariable int cantDays,
            @RequestParam(required = true) String category,
            @RequestParam(required = false, defaultValue = "date_asc") String order) {

        return new ResponseEntity<>(batchService.getBatchListByCategoryOrderByDueDate(cantDays, category, order), HttpStatus.OK);
    }

    @GetMapping("/{prodId}/batch/list")
    public ResponseEntity<List<ProductLocationDto>> getProductLocationsByType(
            @PathVariable Long prodId,
            @AuthenticationPrincipal User user,
            @RequestParam(defaultValue = "L") BatchOrder order
    ) {
        return ResponseEntity
                .ok(freshProductService.getProductLocationsByType(user, order, prodId));
    }

    /**
     * Find all products response entity.
     * Also, can filter by category
     *
     * @param category the product category
     * @return the response entity with the list of products
     */
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('BUYER')")
    ResponseEntity<?> findAllProducts(@RequestParam(required = false) String category){
        return new ResponseEntity<>(productService.searchAllProducts(category), HttpStatus.OK);
    }

    /**
     * Find order by id response entity.
     *
     * @param idOrder the id order
     * @return the response entity with the order
     */
    @GetMapping("/orders/{idOrder}")
    ResponseEntity<?> findOrderById(@PathVariable Long idOrder){
        return new ResponseEntity<>(productOrderService.getAllByPurchaseOrderId(idOrder), HttpStatus.OK);
    }

    /**
     * Update order response entity.
     *
     * @param idOrder the id order
     * @param body   the body
     * @return the response entity
     */
    @PreAuthorize("hasAuthority('BUYER')")
    @PutMapping("/orders/{idOrder}")
    ResponseEntity<?> updateOrder(@PathVariable Long idOrder,
                                  @RequestBody Map<String, @Valid PurchaseOrderRequestDTO> body){
        return new ResponseEntity<>
                (productOrderService.updateOrder(idOrder, body.get("purchase_order")), HttpStatus.OK);
    }

    /**
     * Create new order.
     *
     * @param purchaseOrderDTO the purchase order dto
     * @return the purchase order dto
     */
    @PreAuthorize("hasAuthority('BUYER')")
    @PostMapping("/orders")
    ResponseEntity<?> saveOrder(@RequestBody @Valid Map<String, @Valid PurchaseOrderRequestDTO> purchaseOrderDTO){
        return new ResponseEntity<>(productOrderService.saveOrder(purchaseOrderDTO.get("purchase_order")), HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('MANAGER')")
    @GetMapping("/{idProduct}/warehouse/list")
    public ResponseEntity<WarehouseProductStockDTO> getWarehouseProductStock(@PathVariable Long idProduct) {
        return ResponseEntity.ok(productService.searchProductStockInWarehouses(idProduct));
    }

    @PreAuthorize("hasAuthority(String.valueOf(Role.MANAGER))")
    @PostMapping("/inboundorder")
    ResponseEntity<?> createInboundOrder(@Valid @RequestBody InboundOrderRequestDTO inboundOrder,
                                         @AuthenticationPrincipal User user) throws Exception {
        return ResponseEntity.ok().body(freshProductService.addInboundOrder(inboundOrder, user));
    }

    @PreAuthorize("hasAuthority(String.valueOf(Role.MANAGER))")
    @PutMapping("/inboundorder")
    ResponseEntity<?> updateInboundOrder(@Valid @RequestBody InboundOrderRequestDTO inboundOrder,
                                         @AuthenticationPrincipal User user) throws Exception {
        return ResponseEntity.ok().body(freshProductService.updateInboundOrder(inboundOrder, user));
    }


    @GetMapping("/batches")
    public ResponseEntity<?> getBatchesByDueDate(Pageable pageable) {
        return new ResponseEntity<>(batchService.getBatches(pageable), HttpStatus.OK);
    }

}
