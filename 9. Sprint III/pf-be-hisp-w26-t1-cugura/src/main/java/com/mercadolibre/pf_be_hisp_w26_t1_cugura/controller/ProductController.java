package com.mercadolibre.pf_be_hisp_w26_t1_cugura.controller;

import com.mercadolibre.pf_be_hisp_w26_t1_cugura.authentication.AuthenticationService;
import com.mercadolibre.pf_be_hisp_w26_t1_cugura.dtos.ApiResponse;
import com.mercadolibre.pf_be_hisp_w26_t1_cugura.dtos.ProductDTO;
import com.mercadolibre.pf_be_hisp_w26_t1_cugura.dtos.ProductResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t1_cugura.enums.BatchOrderType;
import com.mercadolibre.pf_be_hisp_w26_t1_cugura.enums.OperationResponse;
import com.mercadolibre.pf_be_hisp_w26_t1_cugura.service.interfaces.IBatchService;
import com.mercadolibre.pf_be_hisp_w26_t1_cugura.service.interfaces.IProductService;
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

    @PostMapping
    public ResponseEntity<ApiResponse> postProduct(@RequestBody ProductDTO productDTO){
        productService.createProduct(productDTO);
        return ResponseEntity.ok(new ApiResponse(OperationResponse.CREATE,"Producto creado con éxito",201));
    }

    @PostMapping("/batch")
    public ResponseEntity<ApiResponse> postListProduct(@RequestBody List<ProductDTO> listOfProducts){
        productService.createBatchProducts(listOfProducts);
        return new ResponseEntity<>(new ApiResponse(OperationResponse.CREATE,"Producto creado con éxito",201),
            HttpStatus.CREATED);
    }
    
    @PutMapping("/{idProduct}")
    public ResponseEntity<ApiResponse> putProduct(
        @PathVariable("idProduct") Integer id,
        @RequestBody ProductDTO productDTO){
            productService.modifyProduct(id,productDTO);
            return ResponseEntity.ok(new ApiResponse(OperationResponse.UPDATE,"Producto modificado con éxito",200));
    }

    @DeleteMapping("/{idProduct}")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable("idProduct") Integer id){
        productService.deleteProduct(id);
        return ResponseEntity.ok(new ApiResponse(OperationResponse.DELETE,"Se ha borrado el producto con éxito",200));
    }
}
