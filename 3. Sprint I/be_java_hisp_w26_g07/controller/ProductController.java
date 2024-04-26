package org.example.be_java_hisp_w26_g07.controller;

import jakarta.validation.Valid;
import org.example.be_java_hisp_w26_g07.dto.PostDto;
import org.example.be_java_hisp_w26_g07.dto.PostDtoPromo;
import org.example.be_java_hisp_w26_g07.dto.PostRequestDto;
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

    @PostMapping("/products/promo-post")
    public ResponseEntity<?> addPromoPost(@RequestBody @Valid PostRequestDto post) {
        return new ResponseEntity<>(productService.createPostPromo(post), HttpStatus.OK);
    }

    @GetMapping("/products/promo-post/count/{user_id}")
    public ResponseEntity<?> getPromoPostCount(@PathVariable Integer user_id) {
        return new ResponseEntity<>(productService.getPromoPostCount(user_id),HttpStatus.OK);
    }

    @GetMapping("/products/promo-post/list/{userId}")
    public ResponseEntity<?> getPromoPostList(@PathVariable Integer userId, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(productService.getPromoPostList(userId,order),HttpStatus.OK);
    }
}
