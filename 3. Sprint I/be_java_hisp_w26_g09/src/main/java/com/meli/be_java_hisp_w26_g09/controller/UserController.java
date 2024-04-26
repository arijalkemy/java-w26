package com.meli.be_java_hisp_w26_g09.controller;

import com.meli.be_java_hisp_w26_g09.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<?> getFollowersList(@PathVariable Integer userId,
                                              @RequestParam(required = false) String order) {
        if (order == null || order.isEmpty())
            return ResponseEntity.ok(userService.getFollowersById(userId));

        return ResponseEntity.ok(userService.getFollowersByIdOrdered(userId, order));
    }


    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<?> getFollowedList(@PathVariable Integer userId,
                                             @RequestParam(required = false) String order) {
        if (order == null || order.isEmpty())
            return ResponseEntity.ok(userService.getFollowedById(userId));

        return ResponseEntity.ok(userService.getFollowedByIdOrdered(userId, order));
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> postFollow(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.follow(userId, userIdToFollow));
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollowUser(@PathVariable int userId, @PathVariable int userIdToUnfollow) {
        return ResponseEntity.ok(userService.unfollowUser(userId, userIdToUnfollow));
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<?> getFollowedCount(@PathVariable Integer userId) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.getFollowedCount(userId));
    }
}
