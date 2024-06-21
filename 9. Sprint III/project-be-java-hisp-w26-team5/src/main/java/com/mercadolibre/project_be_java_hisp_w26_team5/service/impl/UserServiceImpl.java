package com.mercadolibre.project_be_java_hisp_w26_team5.service.impl;

import com.mercadolibre.project_be_java_hisp_w26_team5.exceptions.error.NotFoundException;
import com.mercadolibre.project_be_java_hisp_w26_team5.model.UserEntity;
import com.mercadolibre.project_be_java_hisp_w26_team5.repository.interfaces.IUserRepository;
import com.mercadolibre.project_be_java_hisp_w26_team5.service.interfaces.IUserServiceInternal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserServiceInternal {

    final IUserRepository userRepository;

    @Override
    public UserEntity findUserById(Integer id) {
        return userRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("User: " + id));
    }
}
