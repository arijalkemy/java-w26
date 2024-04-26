package com.api.socialmeli.controller;

import com.api.socialmeli.dto.PostDto;
import com.api.socialmeli.dto.PostPromoDTO;
import com.api.socialmeli.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    // MCaldera - Se inyecta el servio correspondiente a la creacion de posts
    @Autowired
    IPostService postService;

    // MCaldera - Endpoint correspondiente a creacion de posts
    @PostMapping("/post")
    public ResponseEntity<?> NewPost(@RequestBody PostDto postDto){
        return new ResponseEntity<>(this.postService.publishPost(postDto), HttpStatus.OK);
    }

    /*
    US 0006 and US009: Se agrega la función en el controlador para direccionar el endpoint 6 y 9 de la API
    */
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> getPostsByFollowed(@PathVariable Integer userId, @RequestParam(required = false) String order) {
        return ResponseEntity.ok().body(postService.getPostsByFollowed(userId, order));
    }

    /*
    US 0010: Endpoint para llevar a cabo la publicación de un nuevo producto en promoción
    */
    @PostMapping("/promo-post")
    public ResponseEntity<?> NewPromoPost(@RequestBody PostPromoDTO postPromoDTODto){
        return new ResponseEntity(this.postService.publishPromoPost(postPromoDTODto), HttpStatus.OK);
    }

    /*
    US 0011: Endpoint para obtener la cantidad de productos en promoción de un determinado vendedor
    */
    @GetMapping("/promo-post/count")
    public ResponseEntity<?> getSellersCountProductsPromo(@RequestParam Integer user_id){
        return ResponseEntity.status(HttpStatus.OK).body(postService.SellersCountProductsPromo(user_id));
    }

    /*
    US 0012: Endpoint para obtener un listado de todos los productos en promoción de un determinado vendedor
    */
    @GetMapping("/promo-post/list")
    public ResponseEntity<?> GetSellersCountPromo(@RequestParam Integer userId){
        return ResponseEntity.status(HttpStatus.OK).body(postService.GetSellersProductsPromo(userId));
    }

}
