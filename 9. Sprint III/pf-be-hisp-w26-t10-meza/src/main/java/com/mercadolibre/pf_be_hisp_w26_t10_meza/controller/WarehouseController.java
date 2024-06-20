package com.mercadolibre.pf_be_hisp_w26_t10_meza.controller;

import com.mercadolibre.pf_be_hisp_w26_t10_meza.dtos.product.ProductLoadRequestDto;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.dtos.product.ProductLoadResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.dtos.warehouse.WarehouseInfoDto;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.dtos.warehouse.WarehouseResponseRegisterDto;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.entity.Warehouse;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.service.IWarehouseService;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.service.implementations.WarehouseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

    @Autowired
    IWarehouseService warehouseService;

    @PostMapping("/register")
    public ResponseEntity<WarehouseResponseRegisterDto> registerWarehouse(@RequestBody WarehouseInfoDto warehouseInfoDto) {
        return new ResponseEntity<>(warehouseService.registerWarehouse(warehouseInfoDto), HttpStatus.CREATED);
    }

    @GetMapping("/{idWarehouse}")
    public ResponseEntity<?> getOneWarehouse(@PathVariable Integer idWarehouse) {
        return new ResponseEntity<>(warehouseService.findOneWarehouse(idWarehouse), HttpStatus.OK);
    }


}
