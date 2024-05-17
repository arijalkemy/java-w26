package com.example.sprint1.controller;

import com.example.sprint1.exception.NotFoundException;
import com.example.sprint1.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUserService userService;

    /**
     * Get all users
     * @return
     */
    @GetMapping()
    public ResponseEntity<?> getAllUsers(){
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    /**
     * US 001
     * Endpoint that implements that follows a certain seller
     * @param userID
     * @param userIdToFollow
     * @return
     */
    @PostMapping("/{userID}/follow/{userIdToFollow}")
    public ResponseEntity<?> postNewFollower(@PathVariable Integer userID, @PathVariable Integer userIdToFollow){
        userService.addFollower(userID,userIdToFollow);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * US 0002
     * Gets the quantity of users that follow a seller
     * @param userId
     * @return
     */
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<?> getFollowersCount(@PathVariable Integer userId){
        return new ResponseEntity<>(userService.getFollowerCount(userId),HttpStatus.OK);
    }

    /**
     * This method is used to get the list of followers that the user have and package it into a FolloweRListDto object
     * @param userId - The id of the user
     * @return - A FollowerListDto object that contains the list of followers that the user have
     */
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<?> getFollowerList(@PathVariable Integer userId, @RequestParam(required = false) String order){
        return new ResponseEntity<>(userService.getFollowerList(userId, order), HttpStatus.OK);
    }

    /**
     * US 0004, US 0008
     * List of all the sellers that follow some user
     * Sort alphabetically, ascending and descending
     * @param userId
     * @param order
     * @return
     */
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<?> getFollowedList(@PathVariable Integer userId, @RequestParam(value = "order", required = false) String order){
        return new ResponseEntity<>(userService.getFollowedList(userId, order), HttpStatus.OK);
    }

    /**
     * US 0007 Unfollow - Allows a user to stop following another user
     * @param userId - The ID of the user who initiates the unfollow operation
     * @param userIdToUnfollow - The ID of the user who is to be unfollowed
     * @return ResponseEntity<?> HTTP No Content indicating that the unfollow operation was successful.
     */
    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> setUnfollow(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow) {
        userService.setUnfollow(userId, userIdToUnfollow);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
