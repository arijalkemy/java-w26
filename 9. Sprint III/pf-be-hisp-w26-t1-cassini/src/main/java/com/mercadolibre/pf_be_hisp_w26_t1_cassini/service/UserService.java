package com.mercadolibre.pf_be_hisp_w26_t1_cassini.service;

import com.mercadolibre.pf_be_hisp_w26_t1_cassini.entity.User;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.exceptions.ApiException;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.repository.IUserRepository;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.service.interfaces.IUserService;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.service.interfaces.IUserServiceInternal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
