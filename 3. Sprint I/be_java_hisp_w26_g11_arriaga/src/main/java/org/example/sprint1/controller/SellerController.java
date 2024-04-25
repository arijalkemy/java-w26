package org.example.sprint1.controller;

import jakarta.validation.Valid;
import org.example.sprint1.dto.ResponsePromoCountDTO;
import org.example.sprint1.dto.RequestPostDTO;
import org.example.sprint1.dto.ResponsetPostPromoDTO;
import org.example.sprint1.dto.ResponsePostDTO;
import org.example.sprint1.entity.Seller;
import org.example.sprint1.exception.BadRequestException;
import org.example.sprint1.service.seller.ISellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class SellerController {

    @Autowired
    ISellerService postService;

    @Validated
    @PostMapping("/post")
    public ResponseEntity<Void> addPost(@Valid @RequestBody RequestPostDTO postDTO, BindingResult result){
        if(result.hasErrors()){
            throw new BadRequestException("Bad Request");
        }
        postService.addPost(postDTO);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/list")
    public ResponseEntity<List<Seller>> getAllSellers(){
        return new ResponseEntity<>(postService.getSellers(), HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<ResponsePostDTO> getPostsFromFollowingWithTwoWeeksOld(
            @PathVariable int userId,
            @RequestParam Optional<String> order
    ) {
        return new ResponseEntity<>(postService.getPostsFromFollowingWithTwoWeeksOld(userId, order), HttpStatus.OK);
    }

    @PostMapping("/promo-post")
    ResponseEntity<?>  addPromoPost(@RequestBody ResponsetPostPromoDTO postDTO){
        postService.addPost(postDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/promo-post/count")
    ResponseEntity<ResponsePromoCountDTO> getPromoPostCount(@RequestParam("user_id") int userId){
        return new ResponseEntity<>(postService.getPromoPostCount(userId), HttpStatus.OK);
    }

}
