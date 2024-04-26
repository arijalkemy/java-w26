package org.example.be_java_hisp_w26_g07.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
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

    @PostMapping("/promo-post")
    public ResponseEntity<PostDto> addPromoPost(@RequestBody @Valid PromotionPostDto post) {
        return new ResponseEntity<>(productService.createPromotionPost(post), HttpStatus.OK);
    }


    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoPostCountDto> findPromotionCountById(@RequestParam Integer user_id) {
        return new ResponseEntity<>(productService.findListPromotionCountById(user_id), HttpStatus.OK);
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<List<PostDto>> getPostById(@RequestParam Integer user_id) {
        return new ResponseEntity<>(productService.findListPromotionById(user_id), HttpStatus.OK);
    }

    @GetMapping("/price")
    public ResponseEntity<List<PostDto>> getProductsBetweenPrice(@RequestParam @Positive Double min,
                                                                 @RequestParam @Positive Double max) {
        return new ResponseEntity<>(productService.findProductsBetweenPrice(min, max), HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<List<CategoryProductsDto>> getCategoryProducts() {
        return new ResponseEntity<>(productService.findCategoryProducts(), HttpStatus.OK);
    }
}
