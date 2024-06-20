package com.mercadolibre.fresh_market.service.impl;

import com.mercadolibre.fresh_market.config.security.AuthService;
import com.mercadolibre.fresh_market.exceptions.EntityNotFound;
import com.mercadolibre.fresh_market.exceptions.UnauthorizedAccessException;
import com.mercadolibre.fresh_market.model.User;
import com.mercadolibre.fresh_market.model.enums.Role;
import com.mercadolibre.fresh_market.repository.IUserRepository;


import com.mercadolibre.fresh_market.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;
    private final AuthService authService;

    public UserServiceImpl(IUserRepository userRepository, AuthService authService) {
        this.userRepository = userRepository;
        this.authService = authService;
    }


    public User getUserByEmail(String email) {

        return userRepository.findUserByEmail(email)
                .orElseThrow(() ->
                        new EntityNotFound("The user with username: " + email + " was not found."));
    }

    /**
     * Validates that a user is a seller and authorized to perform actions.
     * Retrieves the user from the repository based on the provided user ID.
     *
     * @author jsanchezpimi
     * @param userId the ID of the user to validate as a seller.
     * @return the validated {@link User} object.
     * @throws EntityNotFound              if no user is found with the provided ID.
     * @throws UnauthorizedAccessException if the user is not a seller or is not authorized to perform the action.
     */
    @Override
    @Transactional(readOnly = true)
    public User validateUserSeller(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFound("User not found"));

        if (user.getRole() == null || !user.getRole().equals(Role.SELLER))
            throw new UnauthorizedAccessException("User is not a seller");

        Long userIdAuth = authService.getUserId();

        if (userIdAuth == null || !userIdAuth.equals(userId))
            throw new UnauthorizedAccessException("User is not authorized to perform this action");

        return user;
    }

}
