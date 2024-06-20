package com.mercadolibre.pf_be_hisp_w26_t10_garcia.service.implementations;

import com.mercadolibre.pf_be_hisp_w26_t10_garcia.entity.UserAccount;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.exceptions.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.repository.IUserRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    public UserAccount findById(Long id) {
        Optional<UserAccount> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }else {
            throw new NotFoundException("User not found");
        }
    }
}
