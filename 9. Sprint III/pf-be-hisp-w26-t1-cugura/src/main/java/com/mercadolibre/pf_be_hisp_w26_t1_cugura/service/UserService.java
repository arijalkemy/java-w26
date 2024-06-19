package com.mercadolibre.pf_be_hisp_w26_t1_cugura.service;

import com.mercadolibre.pf_be_hisp_w26_t1_cugura.entity.User;
import com.mercadolibre.pf_be_hisp_w26_t1_cugura.exceptions.ApiException;
import com.mercadolibre.pf_be_hisp_w26_t1_cugura.repository.IUserRepository;
import com.mercadolibre.pf_be_hisp_w26_t1_cugura.service.interfaces.IUserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mercadolibre.pf_be_hisp_w26_t1_cugura.service.interfaces.IUserServiceInternal;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService, IUserServiceInternal{
    private final IUserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public User searchUserById(Integer id) {
        return userRepository
                .findById(id)
                .orElseThrow(
                        () -> new ApiException("Not Found", "No se encontro el usuario",404));
    }

    @Override
    public User searchByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(()-> new ApiException("Not Found","No existe un usuario con el email espeificado.",404));

    }
}

