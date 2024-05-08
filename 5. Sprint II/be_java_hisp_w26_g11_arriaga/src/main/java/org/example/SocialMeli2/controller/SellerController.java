package org.example.SocialMeli2.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.example.SocialMeli2.dto.RequestPostDTO;
import org.example.SocialMeli2.dto.ResponsePostDTO;
import org.example.SocialMeli2.entity.Seller;
import org.example.SocialMeli2.service.seller.ISellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@Validated
public class SellerController {

    @Autowired
    ISellerService postService;

    @PostMapping("/post")
    public ResponseEntity<Void> addPost(@Valid @RequestBody RequestPostDTO postDTO){
        postService.addPost(postDTO);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/list")
    public ResponseEntity<List<Seller>> getAllSellers(){
        return new ResponseEntity<>(postService.getSellers(), HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<ResponsePostDTO> getPostsFromFollowingWithTwoWeeksOld(
            @Min(value = 1, message = "El id debe ser mayor a cero") @PathVariable int userId,
            @RequestParam(required = false) String order
    ) {
        return new ResponseEntity<>(postService.getPostsFromFollowingWithTwoWeeksOld(userId, order), HttpStatus.OK);
    }

}
