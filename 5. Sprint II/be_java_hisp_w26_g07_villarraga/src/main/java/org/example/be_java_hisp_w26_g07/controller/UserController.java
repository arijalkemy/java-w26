package org.example.be_java_hisp_w26_g07.controller;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.example.be_java_hisp_w26_g07.dto.SuccessResponseDto;
import org.example.be_java_hisp_w26_g07.dto.users.CountFollowersResponseDto;
import org.example.be_java_hisp_w26_g07.dto.users.FollowedResponseDto;
import org.example.be_java_hisp_w26_g07.dto.users.FollowersResponseDto;
import org.example.be_java_hisp_w26_g07.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/users")
public class UserController {
    private final IUserService userService;

    public UserController(@Autowired IUserService userService) {
        this.userService = userService;
    }

    /**
     * US 0001
     * Controlador: Poder realizar la acción de “Follow” (seguir) a un determinado vendedor
     *
     * @param userId         usuario
     * @param userIdToFollow vendedor a seguir
     */
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> follow(
            @PathVariable @NotNull(message = "El  id no puede estar vacío.")
            @Positive(message = "El id debe ser mayo a cero") Integer userId,
            @PathVariable @NotNull(message = "El  id no puede estar vacío.")
            @Positive(message = "El id debe ser mayo a cero") Integer userIdToFollow
    ) {
        return new ResponseEntity<>(userService.userFollowSeller(userId, userIdToFollow), HttpStatus.NO_CONTENT);
    }

    /**
     * US 0002
     * Controlador: Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor
     *
     * @param userId usuario
     */
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<CountFollowersResponseDto> numberOfSellersFollowed(
            @PathVariable @NotNull(message = "El  id no puede estar vacío.")
            @Positive(message = "El id debe ser mayo a cero") Integer userId
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getNumberOfSellersFollowed(userId));
    }

    /**
     * US 0003
     * Controlador: Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)
     *
     * @param userId usuario
     * @param order  tipo de orden (opcional)
     */
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<FollowersResponseDto> listOfFollowersSellesrs(
            @PathVariable @NotNull(message = "El  id no puede estar vacío.")
            @Positive(message = "El id debe ser mayo a cero") Integer userId,
            @RequestParam(required = false) String order
    ) {
        return new ResponseEntity<>(userService.findFollowersByOrder(userId, order), HttpStatus.OK);
    }

    /**
     * US 0004
     * Controlador: Obtener  un listado de todos los vendedores a los cuales sigue un determinado usuario
     * (¿A quién sigo?)
     *
     * @param userId usuario
     * @param order  tipo de orden (opcional)
     */
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<FollowedResponseDto> followedList(
            @PathVariable @NotNull(message = "El  id no puede estar vacío.")
            @Positive(message = "El id debe ser mayo a cero") Integer userId,
            @RequestParam(required = false) String order
    ) {
        return new ResponseEntity<>(userService.findFollowedUsers(userId, order), HttpStatus.OK);
    }

    /**
     * US 0007
     * Controlador: Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.
     *
     * @param userId           usuario
     * @param userIdToUnfollow vendedor para dejar de seguir
     */
    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<SuccessResponseDto> unfollow(
            @PathVariable @NotNull(message = "El  id no puede estar vacío.")
            @Positive(message = "El id debe ser mayo a cero") Integer userId,
            @PathVariable @NotNull(message = "El  id no puede estar vacío.")
            @Positive(message = "El id debe ser mayo a cero") Integer userIdToUnfollow
    ) {
        SuccessResponseDto responseDto = userService.unfollow(userId, userIdToUnfollow);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
