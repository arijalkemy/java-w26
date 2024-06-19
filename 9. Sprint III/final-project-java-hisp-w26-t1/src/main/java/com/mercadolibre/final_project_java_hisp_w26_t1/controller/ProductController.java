package com.mercadolibre.final_project_java_hisp_w26_t1.controller;

import com.mercadolibre.final_project_java_hisp_w26_t1.authentication.AuthenticationService;
import com.mercadolibre.final_project_java_hisp_w26_t1.dtos.ProductResponseDTO;
import com.mercadolibre.final_project_java_hisp_w26_t1.enums.BatchOrderType;
import com.mercadolibre.final_project_java_hisp_w26_t1.service.interfaces.IBatchService;
import com.mercadolibre.final_project_java_hisp_w26_t1.service.interfaces.IProductService;
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
