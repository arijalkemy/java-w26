package com.group03.sprint2.controller;

import com.group03.sprint2.dto.SellerNumberOfFollowersDTO;
import com.group03.sprint2.dto.response.BuyerResponseDTO;
import com.group03.sprint2.dto.response.MessageResponseDTO;
import com.group03.sprint2.dto.response.SellerResponseDTO;
import com.group03.sprint2.service.IUsersService;
import com.group03.sprint2.service.implementation.UsersServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.group03.sprint2.utils.Constants.MSG_VALIDATION_ID_POSITIVE;

@Validated
@RestController
@RequestMapping("/users")
public class UsersController {

    private final IUsersService usersService;
  
    public UsersController(UsersServiceImpl usersService) {
        this.usersService = usersService;

    }

    /**
     * Permite que un usuario pueda seguir a un vendedor en especifico.
     * @param userId
     * @param userIdToFollow
     * @return Devuelve un status code 200.
     */
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<MessageResponseDTO> followUser(@PathVariable @Positive(message = MSG_VALIDATION_ID_POSITIVE) Integer userId,
                                                         @PathVariable @Positive(message = MSG_VALIDATION_ID_POSITIVE) Integer userIdToFollow) {
        return ResponseEntity.ok().body(usersService.followUser(userId, userIdToFollow));
    }

    /**
     * Obtiene el resultado de la cantidad de usuarios que siguen a un determinado vendedor.
     * @param userId
     * @return Devuelve un objeto con la cantidad de de usuarios que sigue el vendedor.
     */
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<SellerNumberOfFollowersDTO> getFollowersCount(@PathVariable @Positive(message = MSG_VALIDATION_ID_POSITIVE) Integer userId) {
        SellerNumberOfFollowersDTO sellerNumberOfFollowersDTO = usersService.getNumberOfFollowers(userId);
        return new ResponseEntity<SellerNumberOfFollowersDTO>(sellerNumberOfFollowersDTO, HttpStatus.OK);
    }

    /**
     * Obtiene un listado de todos los usuarios que siguen a un determinado vendedor.
     * En caso de que reciba un parametro "order" como query param, la lista se ordenará alfabeticamente ascendente o
     * descendente segun corresponda.
     * @param userId
     * @param order
     * @return Devuelve una lista de usuarios que sigue a un vendedor.
     */
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<SellerResponseDTO> getFollowersList(@PathVariable @Positive(message = MSG_VALIDATION_ID_POSITIVE) Integer userId,
                                                              @RequestParam(required = false) String order) {
        SellerResponseDTO sellerResponseDTO = usersService.showSellerFollowers(userId, order);
        return ResponseEntity.ok().body(sellerResponseDTO);
    }

    /**
     * Obtiene un listado de todos los vendedores a los cuales sigue un determinado usuario.
     * En caso de que reciba un parametro "order" como query param, la lista se ordenará alfabeticamente ascendente o
     * descendente segun corresponda.
     * @param userId
     * @param order
     * @return Devuelve una lista de usuarios a los cuales sigue un usuario.
     */
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<BuyerResponseDTO> getFollowedList(@PathVariable @Positive(message = MSG_VALIDATION_ID_POSITIVE) Integer userId,
                                                            @RequestParam(required = false) String order) {
        return ResponseEntity.ok().body(usersService.showBuyerFollowed(userId, order));
    }

    /**
     * Permite que un usuario pueda dejar de seguir a un vendedor en especifico.
     * @param userId
     * @param userIdToUnfollow
     * @return Devuelve un status code 200.
     */
    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<MessageResponseDTO> unfollowUser(@PathVariable @Positive(message = MSG_VALIDATION_ID_POSITIVE) Integer userId,
                                          @PathVariable @Positive(message = MSG_VALIDATION_ID_POSITIVE) Integer userIdToUnfollow) {
        return ResponseEntity.ok().body(usersService.unfollowUser(userId, userIdToUnfollow));
    }
}
