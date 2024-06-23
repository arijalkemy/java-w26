package com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.controller;

import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.dto.response.ProductDetailResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.dto.response.ProductStockResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.model.UserEntity;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.service.interfaces.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final IProductService service;

    @GetMapping("/")
    public ResponseEntity<List<ProductDetailResponseDto>> searchProducts() {
        return ResponseEntity.ok(service.getProducts());
    }

    @GetMapping("/{idProduct}/batch/list")
    public ResponseEntity<?> getProductLocationById(@PathVariable
                                                    int idProduct,
                                                    @RequestParam(name = "order", required = false, defaultValue = "L")
                                                    String order) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        int managerId = ((UserEntity) authentication.getPrincipal()).getId();
        return new ResponseEntity<>(service.getProductLocationById(idProduct, managerId, order), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<ProductDetailResponseDto>> searchProductsByCategory(@RequestParam List<String> category) {
        return ResponseEntity.ok(service.getProductsByCategory(category));
    }

    @GetMapping("/{idProduct}/warehouse/list")
    public ResponseEntity<ProductStockResponseDTO> getTotalStockOfWarehouses(@PathVariable int idProduct){
        return ResponseEntity.ok(service.getTotalStockOfWarehouses(idProduct));
    }
}
