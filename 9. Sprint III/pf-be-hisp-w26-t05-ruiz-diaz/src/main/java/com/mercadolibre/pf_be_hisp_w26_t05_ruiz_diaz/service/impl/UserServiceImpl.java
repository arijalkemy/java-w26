package com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.service.impl;

import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.exceptions.error.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.model.UserEntity;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.repository.interfaces.IUserRepository;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.service.interfaces.IUserServiceInternal;
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
