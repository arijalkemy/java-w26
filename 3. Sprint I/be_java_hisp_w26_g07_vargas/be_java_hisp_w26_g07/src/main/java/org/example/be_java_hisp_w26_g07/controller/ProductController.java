package org.example.be_java_hisp_w26_g07.controller;

import jakarta.validation.Valid;
import org.example.be_java_hisp_w26_g07.dto.CountPromoResponseDto;
import org.example.be_java_hisp_w26_g07.dto.PostDto;
import org.example.be_java_hisp_w26_g07.dto.PostRequestDto;
import org.example.be_java_hisp_w26_g07.dto.PromoRequestDto;
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
    public ResponseEntity<Void> addPromoPost(@RequestBody @Valid PromoRequestDto promoRequestDto) {
        productService.createPromoPost(promoRequestDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("promo-post/count")
    public ResponseEntity<CountPromoResponseDto> getNumberOfPromotions(@RequestParam(name = "user_id") String userId) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getNumberOfPromotions(userId));
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<List<PostDto>> getPromotions(@RequestParam(name = "user_id") String userId) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getPromotions(userId));
    }

    @GetMapping("/postsByUser")
    public ResponseEntity<List<PostDto>> getPosts(@RequestParam(name = "user_id") String userId) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getPosts(userId));
    }

    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPosts() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProducts());
    }

    @GetMapping("/filter/color/{color}")
    public ResponseEntity<List<PostDto>> getProductsFilteredByColor(@PathVariable String color) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProductsFilteredByColor(color));
    }

    @GetMapping("/filter/category/{category}")
    public ResponseEntity<List<PostDto>> getProductsFilteredByCategory(@PathVariable String category) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProductsFilteredByCategory(category));
    }

    @GetMapping("/filter/price/{price}")
    public ResponseEntity<List<PostDto>> getProductsWithAPriceLowerThan(@PathVariable String price) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProductsWithAPriceLowerThan(price));
    }

    @GetMapping("/filter/price/{since}/{to}")
    public ResponseEntity<List<PostDto>> getProductsWithPricesBetween(
            @PathVariable String since, @PathVariable String to
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProductsWithPricesBetween(since, to));
    }

    @GetMapping("/filter/discount/{discount}")
    public ResponseEntity<List<PostDto>> getDiscountedProductsFrom(@PathVariable String discount) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getDiscountedProductsFrom(discount));
    }

}
