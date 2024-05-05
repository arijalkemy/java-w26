package com.api.socialmeli.controller;

import com.api.socialmeli.dto.PostDto;
import com.api.socialmeli.dto.PostPromoDto;
import com.api.socialmeli.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    // MCaldera - Se inyecta el servio correspondiente a la creacion de posts
    @Autowired
    IPostService postService;

    // MCaldera - Endpoint correspondiente a creacion de posts
    @PostMapping("/products/post")
    public ResponseEntity<?> NewPost(@RequestBody PostDto postDto){
        return new ResponseEntity(this.postService.publishPost(postDto), HttpStatus.OK);
    }


    /* US 0010 */
    @PostMapping("/products/promo-post")
    public ResponseEntity<?> addPromoPost(@RequestBody PostPromoDto postPromoDto){
        return new ResponseEntity<>(
                postService.publishPostPromo(postPromoDto),
                HttpStatus.OK
        );
    }

    /* US 0011 */
    @GetMapping("/products/promo-post/count")
    public ResponseEntity<?> getPostPromoCountBySellerId(@RequestParam("user_id") Integer user_id){
        return new ResponseEntity(
                postService.getCountOfProductsPromosBySellerId(user_id),
                HttpStatus.OK
        );
    }

    /* US 0012 */
    @GetMapping("/products/promo-post/list")
    public ResponseEntity<?> getPostPromoListBySellerId(@RequestParam("user_id") Integer user_id){
        return new ResponseEntity<>(
                postService.getPostPromosOfSellerById(user_id),
                HttpStatus.OK
        );
    }
}
