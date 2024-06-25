package com.mercadolibre.pf_be_hisp_w26_t4_aquino.runner;

import com.mercadolibre.pf_be_hisp_w26_t4_aquino.model.User;
import com.mercadolibre.pf_be_hisp_w26_t4_aquino.repository.IUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class LoadInitialUsers {

    IUserRepository userRepository;
    PasswordEncoder passwordEncoder;

    public LoadInitialUsers(IUserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public CommandLineRunner registerUsers() {
        return args -> {
            User manager = userRepository.findById(1L).orElseThrow();
            User buyer = userRepository.findById(2L).orElseThrow();

            manager.setPassword(passwordEncoder.encode("manager"));
            buyer.setPassword(passwordEncoder.encode("buyer"));

            userRepository.save(manager);
            userRepository.save(buyer);
        };
    }
}
