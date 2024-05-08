package com.javabootcamp.socialmeli.controller;


import com.javabootcamp.socialmeli.dto.response.FollowedSellersDto;
import com.javabootcamp.socialmeli.dto.response.SellerWithFollowersDTO;
import com.javabootcamp.socialmeli.enums.OrderType;
import com.javabootcamp.socialmeli.dto.response.ResponseDto;
import com.javabootcamp.socialmeli.service.UserService;

import java.util.Objects;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
    public ResponseEntity<?> getFollowerCount(
            @PathVariable
            @Positive(message = "El id debe ser mayor a cero.")
            Integer userId){
        return ResponseEntity.ok(userService.countFollowersById(userId));
    }

    @DeleteMapping("{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollow(
            @PathVariable
            @Positive(message = "El id del usuario debe ser mayor a cero.")
            Integer userId,
            @PathVariable
            @Positive(message = "El id del vendedor debe ser mayor a cero.")
            Integer userIdToUnfollow){
        return new ResponseEntity<>(userService.deleteFollower(userId,userIdToUnfollow), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<SellerWithFollowersDTO> getFollowersOfSeller(
            @PathVariable("userId")
            @Positive(message = "El id debe ser mayor a cero.")
            int userId,
            @RequestParam(required = false) OrderType order){

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
    public ResponseEntity<ResponseDto> followUser(

            @PathVariable
            @Positive(message = "El id del usuario debe ser mayor a cero.")
            Integer userId,
            @PathVariable
            @Positive(message = "El id del vendedor debe ser mayor a cero.")
            Integer userToFollow) {
        return ResponseEntity.ok(userService.addFollower(userId, userToFollow));
    }

    @GetMapping(path = "/{userId}/followed/list")
    public ResponseEntity<FollowedSellersDto> getFollowedByUserId(
            @PathVariable
            @Positive(message = "El id debe ser mayor a cero.")
            Integer userId,
            @RequestParam(required = false) OrderType order) {

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
