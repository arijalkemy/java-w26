package org.example.be_java_hisp_w26_g07.controller;

import jakarta.validation.Valid;
import org.example.be_java_hisp_w26_g07.dto.PostDiscountDto;
import org.example.be_java_hisp_w26_g07.dto.PostDto;
import org.example.be_java_hisp_w26_g07.dto.PostRequestDto;
import org.example.be_java_hisp_w26_g07.dto.UserProductsPromotion;
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
    public ResponseEntity<PostDiscountDto> addDiscountPost(@RequestBody @Valid PostDiscountDto postDiscountDto) {
        return new ResponseEntity<>(productService.createPostWithDiscount(postDiscountDto), HttpStatus.OK);
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<?> getDiscountPostBySeller(@RequestParam Integer user_id) {
        return new ResponseEntity<>(productService.getQuantityProductsPromotion(user_id), HttpStatus.OK);
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<?> getDiscountPostListBySeller(@RequestParam Integer user_id) {
        return new ResponseEntity<>(productService.getListProductsPromotionsBySeller(user_id), HttpStatus.OK);
    }





}
