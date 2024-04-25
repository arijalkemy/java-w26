package org.example.be_java_hisp_w26_g07.controller;

import jakarta.validation.Valid;
import org.example.be_java_hisp_w26_g07.dto.*;
import org.example.be_java_hisp_w26_g07.service.interfaces.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/post")
    public ResponseEntity<PostDto> addPost(@RequestBody @Valid PostRequestDto post) {
        return new ResponseEntity<>(productService.createPost(post), HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> getLatestPost(@PathVariable Integer userId, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(productService.findProductByFollow(userId, order), HttpStatus.OK);
    }

    //EJERCICIOS INDIVIDUALES

    @PostMapping("promo-post")
    public ResponseEntity<PostPromoRequestDto> addPostWithPromo(@RequestBody @Valid PostPromoRequestDto postPromo) {
        return new ResponseEntity<>(productService.createPostWithPromo(postPromo), HttpStatus.OK);
    }

    @GetMapping("promo-post/count")
    public ResponseEntity<PromoPostCountResponseDto> getCountOfPromoByUser(@RequestParam Integer user_id) {
        return new ResponseEntity<>(productService.getPromoCountByUser(user_id), HttpStatus.OK);
    }

    //BONUS INDIVIDUAL

    //ENCONTRAR PRODUCTOS EN DESCUENTO MAYOR O IGUAL AL SOLICITADO DE LOS USUARIOS QUE SIGUE
    @GetMapping("promo-post/promos/user/{userId}")
    public ResponseEntity<List<ProductResponseDto>> getPromosByUser(@PathVariable Integer userId, @RequestParam Double discount) {
        return new ResponseEntity<>(productService.findProductsWithDiscountByFollowers(discount,userId), HttpStatus.OK);
    }

    //ENCONTRAR PRODUCTOS EN DESCUENTO MAYOR O IGUAL AL SOLICITADO DE TODOS LOS USUARIOS
    @GetMapping("promo-post/promos")
    public ResponseEntity<List<ProductResponseDto>> getPromos(@RequestParam Double discount) {
        return new ResponseEntity<>(productService.findProductsWithDiscount(discount), HttpStatus.OK);
    }

    @GetMapping("name/{name}")
    public ResponseEntity<List<ProductResponseDto>> getProductByName(@PathVariable String name) {
        return new ResponseEntity<>(productService.findProductsByNameProduct(name), HttpStatus.OK);
    }
}
