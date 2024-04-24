package com.sprint.socialmeli.controller;

import com.sprint.socialmeli.dto.post.PostPromoDTO;
import com.sprint.socialmeli.dto.post.PromoCountResponseDTO;
import com.sprint.socialmeli.service.post.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("products/promo-post")
public class PromoController {

    @Autowired
    IPostService postService;


    // US0010
    @PostMapping()
    public ResponseEntity<?> createPostWithPromo(@RequestBody PostPromoDTO promo) {
        this.postService.createPostWithPromo(promo);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // US0011
    @GetMapping("/count")
    public ResponseEntity<PromoCountResponseDTO> countPromos(@RequestParam Integer userId) {
        PromoCountResponseDTO promoCountResponseDTO = this.postService.getPromosCountById(userId);
        return new ResponseEntity<>(promoCountResponseDTO, HttpStatus.OK);
    }

    //TODO: Arreglar esta retornando directamente el post y tiene que ser un usuario y adentro los post promos
    // US0012
    @GetMapping("/list")
    public ResponseEntity<?> listPromos(@RequestParam Integer userId) {

        return new ResponseEntity<>(postService.getPromosListById(userId), HttpStatus.OK);
    }


}
