package com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.controller;

import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.service.IShoppingCartService;
import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.service.IWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller responsible for /warehouse implementation.
 */
@RestController
@RequestMapping("/api/v1/fresh-products")
public class WarehouseController {
    @Autowired
    IWarehouseService warehouseService;
    IShoppingCartService shoppingCartService;

    /**
     * Get all data about item by warehause
     *
     * @param idWarehouse Item number to search
     * @return Data about quantities per warehouse
     */
//    @PreAuthorize("hasRole('SUPERVISOR')")
//    @GetMapping("/warehouse/{idWarehouse}/sales/inbound_order")
//    public ResponseEntity<?> getCantInboundOrderForMonth(@PathVariable Integer idWarehouse) {
//        return new ResponseEntity<>(this.warehouseService.getCantInboundOrderForMonth(idWarehouse), HttpStatus.OK);
//    }

    /**
     * Get all data about item by warehause
     *
     * @param idWarehouse Item number to search
     * @return Data about quantities per warehouse
     */
//    @PreAuthorize("hasRole('SUPERVISOR')")
//    @GetMapping("/warehouse/{idWarehouse}/sales/products")
//    public ResponseEntity<?> getTotalProductsSalesForMonth(@PathVariable Integer idWarehouse) {
//        return new ResponseEntity<>(this.shoppingCartService.getTotalProductsSalesForMonth(idWarehouse), HttpStatus.OK);
//    }

    /**
     * Get all data about item by warehause
     *
     * @param idWarehouse Item number to search
     * @return Data about quantities per warehouse
     */
//    @PreAuthorize("hasRole('SUPERVISOR')")
//    @GetMapping("/warehouse/{idWarehouse}/sales/collected-Total")
//    public ResponseEntity<?> getTotalSalesForMonth(@PathVariable Integer idWarehouse) {
//        return new ResponseEntity<>(this.shoppingCartService.getTotalSalesForMonth(idWarehouse), HttpStatus.OK);
//    }
}
