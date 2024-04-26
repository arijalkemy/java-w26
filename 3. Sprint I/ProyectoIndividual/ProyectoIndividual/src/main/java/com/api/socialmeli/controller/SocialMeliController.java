package com.api.socialmeli.controller;
import java.util.List;
import com.api.socialmeli.service.ISellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.api.socialmeli.service.IPostService;

import com.api.socialmeli.entity.Buyer;
import com.api.socialmeli.service.IBuyerService;

@RestController
public class SocialMeliController {

    @Autowired
    IBuyerService buyerService;

    @Autowired
    private ISellerService iSellerService;

    @Autowired
    private IPostService postService;

    @GetMapping("/users")
    public ResponseEntity<List<Buyer>> getAll(){
        return new ResponseEntity<List<Buyer>>(buyerService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<Buyer> followUser(@PathVariable Integer userId, @PathVariable Integer userIdToFollow){
        return new ResponseEntity<Buyer>(buyerService.followUser(userId, userIdToFollow), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<?> getCountOfSellerFollowers(@PathVariable Integer userId){
        return new ResponseEntity<>(iSellerService.getCountOfSellerFollowers(userId), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<?> getFollowersOfSeller(
        @PathVariable("userId") int userId,
        @RequestParam(name = "order", defaultValue = "", required = false) String order)
    {
        return new ResponseEntity<>(iSellerService.getFollowersOfSeller(userId, order), HttpStatus.OK);
    }


    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<?> getPostsByFollowed(@PathVariable Integer userId, @RequestParam(required = false) String order) {
        return ResponseEntity.ok().body(postService.getPostsByFollowed(userId, order));
    }

    //Se realiza la función del controller para direccionar el endpoint 4 y el respectivo 8 del API
    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<?> getFollowedListById(@PathVariable Integer userId,@RequestParam(required = false) String order){
        return ResponseEntity.status(HttpStatus.OK).body(buyerService.getFollowedListByUser(userId,order));
    }


    /*
    US 0007: endpoint
    */
    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollowUser(@PathVariable Integer userId,
                                          @PathVariable Integer userIdToUnfollow){
        buyerService.unfollowUser(userId,userIdToUnfollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
