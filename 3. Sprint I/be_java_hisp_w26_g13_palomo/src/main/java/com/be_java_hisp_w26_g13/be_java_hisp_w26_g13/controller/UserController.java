package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.controller;

import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.repository.IPostRepository;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.service.IPostService;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUserService iUserService;

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followUser(@PathVariable("userId") Integer userId, @PathVariable("userIdToFollow") Integer userIdToFollow) {
        return ResponseEntity.status(HttpStatus.OK).body(iUserService.followUser(userId, userIdToFollow));
    }

    @GetMapping("")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(iUserService.retrieveAllUsers());
    }

    //US 0004: Obtener  un listado de todos los vendedores a los cuales sigue un determinado usuario
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<?> getFollowedSellersList(@PathVariable("userId") int userId, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(iUserService.getOrderedFollowedSellers(userId, order), HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollow(@PathVariable("userId") int userId, @PathVariable("userIdToUnfollow") int userIdToUnfollow) {
        return ResponseEntity.status(HttpStatus.OK).body(iUserService.unfollow(userId, userIdToUnfollow));
    }

    //metodo GET para el us-0003
    @GetMapping("/{userId}/followers/list")
    ResponseEntity<?> followersList(@PathVariable("userId") int userId, @RequestParam(required = false) String order) {
        return ResponseEntity.status(HttpStatus.OK).body(iUserService.getOrderedFollowersList(userId, order));
    }

    //metodo GET para el us-0002
    @GetMapping("/{userId}/followers/count")
    ResponseEntity<?> followersCount(@PathVariable("userId") int userId){
        return new ResponseEntity<>(iUserService.getFollowersCount(userId), HttpStatus.OK);
    }


}
