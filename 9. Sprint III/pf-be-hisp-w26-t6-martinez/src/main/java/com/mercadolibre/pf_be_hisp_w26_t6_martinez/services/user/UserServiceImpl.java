package com.mercadolibre.pf_be_hisp_w26_t6_martinez.services.user;

import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.UserDto.RegisterUserDto;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.entity.User;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.exceptions.ConflictException;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.repository.IUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUsersService{

    @Autowired
    IUsersRepository usersRepository;



    @Override
    public void register(RegisterUserDto registerUserDto) {

        User user = usersRepository.findByUsername(registerUserDto.getUsername());
        if (user != null) throw new ConflictException("User: " + user.getUsername() + " already exists");

        String hashedPassword = hashPassword(registerUserDto.getPassword());

        user = User.builder()
                .userRole(registerUserDto.getRol())
                .username(registerUserDto.getName())
                .hashedPassword(hashedPassword)
                .name(registerUserDto.getName())
                .build();

        usersRepository.save(user);
    }

    private String hashPassword(String password){
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        return bcrypt.encode(password);
    }
}
