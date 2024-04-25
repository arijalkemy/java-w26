package org.example.be_java_hisp_w26_g07.controller;

import org.example.be_java_hisp_w26_g07.dto.CountFollowersResponseDto;
import org.example.be_java_hisp_w26_g07.dto.FollowedResponseDto;
import org.example.be_java_hisp_w26_g07.dto.FollowersResponseDto;
import org.example.be_java_hisp_w26_g07.dto.SuccessResponseDto;
import org.example.be_java_hisp_w26_g07.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final IUserService userService;

    public UserController(@Autowired IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> follow(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) {
        return new ResponseEntity<>(userService.userFollowSeller(userId, userIdToFollow), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<CountFollowersResponseDto> numberOfSellersFollowed(@PathVariable String userId) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getNumberOfSellersFollowed(userId));
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<FollowersResponseDto> getFollowersList(@PathVariable Integer userId,
                                                                        @RequestParam(required = false) String order) {
        return new ResponseEntity<>(userService.findFollowersByOrder(userId, order), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<FollowedResponseDto> getFollowedList(@PathVariable Integer userId,
                                                             @RequestParam String order) {
        return new ResponseEntity<>(userService.findFollowedUsers(userId, order), HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<SuccessResponseDto> unfollow(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow) {
        SuccessResponseDto responseDto = userService.unfollow(userId, userIdToUnfollow);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
