package bootcamp.sprint.grupo02.sprintI.controller;

import bootcamp.sprint.grupo02.sprintI.dto.response.FollowersListResponseDTO;
import org.springframework.http.HttpStatus;
import bootcamp.sprint.grupo02.sprintI.dto.response.SellerFollowersResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.sprint.grupo02.sprintI.dto.response.FollowedListResponseDTO;
import bootcamp.sprint.grupo02.sprintI.service.BuyerService;
import bootcamp.sprint.grupo02.sprintI.service.SellerService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    
    private final BuyerService buyerService;
    private final SellerService sellerService;

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<Void> postFollowUser(@PathVariable int userId, @PathVariable int userIdToFollow) {
        buyerService.followUser(userId, userIdToFollow);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<FollowersListResponseDTO> getFollowersList(@PathVariable int userId){
        return ResponseEntity.status(HttpStatus.OK).body(
          sellerService.getFollowersList(userId)
        );
    }

    @GetMapping(value = "/{userId}/followers/list", params = "order" )
    public ResponseEntity<FollowersListResponseDTO> getFollowersList(@PathVariable int userId, @RequestParam String order){
        return ResponseEntity.status(HttpStatus.OK).body(
          sellerService.getFollowersList(userId, order)
        );
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<SellerFollowersResponseDTO> getSellerWithNumberOfFollowers(@PathVariable int userId){
        return ResponseEntity.ok(this.sellerService.calculateFollowersCount(userId));
    }


    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<FollowedListResponseDTO> getSellersFollowed(@PathVariable int userId) {
        return ResponseEntity.ok(buyerService.searchBuyerFollows(userId));
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<Void> postUnfollowUser(@PathVariable int userId, @PathVariable int userIdToUnfollow) {
        buyerService.UnfollowUser(userId, userIdToUnfollow);
        return ResponseEntity.ok().build();
    }
    
    @GetMapping(value = "/{userId}/followed/list", params = "order")
    public ResponseEntity<FollowedListResponseDTO> getSellersFollowed(@PathVariable int userId, @RequestParam String order) {
        return ResponseEntity.ok(buyerService.searchBuyerFollows(userId, order));
    }

}
