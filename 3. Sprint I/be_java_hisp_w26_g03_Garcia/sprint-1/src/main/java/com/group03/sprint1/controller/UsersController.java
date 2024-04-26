package com.group03.sprint1.controller;

import com.group03.sprint1.dto.PublicationDTO;
import com.group03.sprint1.dto.SellerFollowersDTO;
import com.group03.sprint1.dto.response.BuyerResponseDTO;
import com.group03.sprint1.dto.response.SellerResponseDTO;
import com.group03.sprint1.service.IUsersService;
import com.group03.sprint1.service.implementation.UsersServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final IUsersService usersService;
  
    public UsersController(UsersServiceImpl usersService) {
        this.usersService = usersService;

    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followUser(@PathVariable Integer userId,
                                        @PathVariable Integer userIdToFollow) {
        usersService.followUser(userId, userIdToFollow);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<SellerFollowersDTO> getFollowersCount(@PathVariable Integer userId) {
        SellerFollowersDTO sellerFollowersDTO= usersService.getFollowers(userId);
        return new ResponseEntity<SellerFollowersDTO>(sellerFollowersDTO, HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<SellerResponseDTO> getFollowersList(@PathVariable Integer userId,
                                                              @RequestParam(required = false) String order) {
        SellerResponseDTO sellerResponseDTO = usersService.showSellerFollowers(userId, order);
        return ResponseEntity.ok().body(sellerResponseDTO);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<BuyerResponseDTO> getFollowedList(@PathVariable Integer userId,
                                                            @RequestParam(required = false) String order) {
        return ResponseEntity.ok().body(usersService.showBuyerFollowed(userId, order));
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollowUser(@PathVariable Integer userId,
                                          @PathVariable Integer userIdToUnfollow) {
        usersService.unfollowUser(userId, userIdToUnfollow);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{userId}/delete_post/{postId}")
    public ResponseEntity<String> deletePostOfSeller(@PathVariable Integer userId,
                                                    @PathVariable Integer postId){
        return ResponseEntity.ok().body(usersService.deletePostOfSeller(userId, postId));
    }

    @PutMapping("/{userId}/update_post/{postId}")
    public ResponseEntity<String> updatePostOfSeller(@PathVariable Integer userId,
                                                             @PathVariable Integer postId,
                                                             @RequestBody PublicationDTO publicationDTO){
        return ResponseEntity.ok().body(usersService.updatePostOfSeller(userId, postId, publicationDTO));
    }
}
