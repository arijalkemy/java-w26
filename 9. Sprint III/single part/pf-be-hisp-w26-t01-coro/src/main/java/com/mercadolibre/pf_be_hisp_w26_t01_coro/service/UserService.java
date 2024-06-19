package com.mercadolibre.pf_be_hisp_w26_t01_coro.service;

import com.mercadolibre.pf_be_hisp_w26_t01_coro.entity.User;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.exceptions.ApiException;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.repository.IUserRepository;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.service.interfaces.IUserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.service.interfaces.IUserServiceInternal;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService, IUserServiceInternal{
    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

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

    @Override
    public User searchByEmailOrNUll(String email) {
        return userRepository.findByEmail(email)
                .orElse(null);
    }

    @Override
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User u = userRepository.save(user);
        return u;
    }
}
