package com.javabootcamp.socialmeli.controller;


import com.javabootcamp.socialmeli.dto.FollowedSellersDto;
import com.javabootcamp.socialmeli.dto.SellerWithFollowersDTO;
import com.javabootcamp.socialmeli.enums.OrderType;
import com.javabootcamp.socialmeli.dto.ResponseDto;
import com.javabootcamp.socialmeli.service.UserService;

import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

    @GetMapping("/")
    public ResponseEntity<?> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
    }

    @GetMapping("{userId}/followers/count")
    public ResponseEntity<?> getFollowerCount(@PathVariable Integer userId){
        return ResponseEntity.ok(userService.countFollowersById(userId));
    }

    @DeleteMapping("{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollow(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow){
        return new ResponseEntity<>(userService.deleteFollower(userId,userIdToUnfollow), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<SellerWithFollowersDTO> getFollowersOfSeller(@PathVariable("userId") int userId,@RequestParam(required = false) OrderType order){

        SellerWithFollowersDTO response;
        if(Objects.isNull(order)){
            response = userService.searchFollowersById(userId);
        }
        else{
            response = userService.searchFollowersById(userId,order);
        }
        return ResponseEntity.status(200).body(response);
    }

    @PostMapping(path = "{userId}/follow/{userToFollow}")
    public ResponseEntity<ResponseDto> followUser(@PathVariable Integer userId, @PathVariable Integer userToFollow) {
        return ResponseEntity.ok(userService.addFollower(userId, userToFollow));
    }

    @GetMapping(path = "/{userId}/followed/list")
    public ResponseEntity<FollowedSellersDto> getFollowedByUserId(@PathVariable Integer userId, @RequestParam(required = false) OrderType order) {

        FollowedSellersDto response;
        if(Objects.isNull(order)){
            response = userService.searchFollowedById(userId);
        }
        else{
            response = userService.searchFollowedById(userId,order);
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);


    }
}
