package com.mercadolibre.final_project_java_hisp_w26_t1.service;

import com.mercadolibre.final_project_java_hisp_w26_t1.entity.User;
import com.mercadolibre.final_project_java_hisp_w26_t1.exceptions.ApiException;
import com.mercadolibre.final_project_java_hisp_w26_t1.repository.IUserRepository;
import com.mercadolibre.final_project_java_hisp_w26_t1.service.interfaces.IUserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mercadolibre.final_project_java_hisp_w26_t1.service.interfaces.IUserServiceInternal;

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

