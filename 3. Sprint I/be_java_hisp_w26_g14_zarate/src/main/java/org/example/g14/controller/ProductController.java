package org.example.g14.controller;

import org.example.g14.dto.CreatePostDto;
import org.example.g14.dto.PostDto;
import org.example.g14.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    IPostService postService;

    @PostMapping("/post")
    public ResponseEntity<Void> createPost(
        @RequestBody CreatePostDto createPostDto
    ) {
        postService.add(createPostDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/followed/{user_id}/list")
    public ResponseEntity<List<PostDto>> getPostsFromFollowed(@PathVariable("user_id") int userId,
                                                              @RequestParam(required = false) String order){
        List<PostDto> posts = postService.getPostsFromFollowed(userId, order);
        return ResponseEntity.ok(posts);
    }

    @PostMapping("/promo-post")
    public ResponseEntity<?> createPostWithPromo(@RequestBody CreatePostDto postWithPromo){
        postService.createPostWithPromo(postWithPromo);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<?> getNumberOfPromoPost(@RequestParam int user_id){
        return new ResponseEntity<>(postService.getNumberOfPromoPost(user_id), HttpStatus.OK);
    }

    /*
        REQUERIMEINTO BONUS

        US0012: Obtener un resumen de los productos de un usuario
        GET /products/{user_id}/stats
        RESPONSE
            {
                "user_id": 234,
                "user_name": "vendedor1",
                "products_quantity": 45,
                "products_with_promo": 4,
                "date_first_product": 01-03-2005,
                "date_last_product":
                "max_price": 332.3,
                "min_price": 23.3,
                "average_price": 150.4,
                "total_published": 354.6,
                "total_published_with_discount" : 234.5
            }
        */

    @GetMapping("/{user_id}/stats")
    public ResponseEntity<?> getResume(@PathVariable int user_id){
        return new ResponseEntity<>(postService.getResume(user_id), HttpStatus.OK);
    }


}
