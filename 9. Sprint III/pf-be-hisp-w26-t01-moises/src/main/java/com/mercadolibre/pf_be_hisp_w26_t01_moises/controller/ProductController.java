package com.mercadolibre.pf_be_hisp_w26_t01_moises.controller;

import com.mercadolibre.pf_be_hisp_w26_t01_moises.authentication.AuthenticationService;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.dtos.ProductResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.enums.BatchOrderType;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.service.interfaces.IBatchService;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.service.interfaces.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fresh-products")
@RequiredArgsConstructor
public class ProductController {

    private final IProductService productService;

    private final AuthenticationService authenticationService;

    private final IBatchService batchService;

    @GetMapping("/{idProduct}/batch/list")
    public ResponseEntity<?> getProductLocation(@PathVariable Integer idProduct,
                                                @RequestParam(name="order",required = false) BatchOrderType batchOrderType){

        String managerEmail = authenticationService.getLogMail();
        return new ResponseEntity<>(batchService.getProductLocation(managerEmail, idProduct,batchOrderType), HttpStatus.OK);
    }

    @GetMapping(path = "/list")
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {
        return new ResponseEntity<>(productService.getAll(), HttpStatusCode.valueOf(200));
    }

    @GetMapping(path = "/list",params = {"category"})
    public ResponseEntity<List<ProductResponseDTO>> getAllProductsByCategory(@RequestParam("category") String category) {
        return new ResponseEntity<>(productService.getAllByCategory(category), HttpStatusCode.valueOf(200));
    }

}
