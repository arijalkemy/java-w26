package com.mercadolibre.fresh_market.service.impl;

import com.mercadolibre.fresh_market.exceptions.EntityNotFound;
import com.mercadolibre.fresh_market.model.User;
import com.mercadolibre.fresh_market.repository.IUserRepository;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    
    public User getUserByEmail(String email) {

        Optional<User> optionalUser = userRepository.findUserByEmail(email);
        
        if (!optionalUser.isPresent()) {
            throw new EntityNotFound("The user with username: " + email + " was not found.");
        }


        return optionalUser.get();
    }

}
