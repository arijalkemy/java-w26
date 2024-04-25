package org.example.be_java_hisp_w26_g07.controller;

import jakarta.validation.Valid;
import org.example.be_java_hisp_w26_g07.dto.*;
import org.example.be_java_hisp_w26_g07.service.interfaces.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/promo-post")
    public ResponseEntity<?> createPromoPost(@RequestBody @Valid PromoPostReqDto post) {
        SuccessResponseDto successResponseDto = productService.createPromoPost(post);
        return new ResponseEntity<>(successResponseDto, HttpStatus.OK);
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<?> getPromoPostsBySellerId(@RequestParam Integer user_id) {
        PromoPostResDto successResponseDto = productService.getPromoPostsBySellerId(user_id);
        return new ResponseEntity<>(successResponseDto, HttpStatus.OK);
    }
}
