package org.example.sprint1.controller;

import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.example.sprint1.dto.CountPromoPostsDTO;
import org.example.sprint1.dto.RequestPostDTO;
import org.example.sprint1.dto.RequestPromoPostDTO;
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

    @Validated
    @PostMapping("/promo-post")
    public ResponseEntity<Void> addPromoPost(@Valid @RequestBody RequestPromoPostDTO postDTO, BindingResult result){
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

    @GetMapping ("/promo-post/count")
    ResponseEntity<CountPromoPostsDTO> countPromoPosts(@RequestParam("user_id")int userId){
        return new ResponseEntity<CountPromoPostsDTO>(postService.countPromoPosts(userId), HttpStatus.OK);
    }

}
