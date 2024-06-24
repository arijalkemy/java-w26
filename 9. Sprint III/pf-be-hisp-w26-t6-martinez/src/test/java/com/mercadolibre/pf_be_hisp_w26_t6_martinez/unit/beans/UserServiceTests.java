package com.mercadolibre.pf_be_hisp_w26_t6_martinez.unit.beans;

import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.UserDto.RegisterUserDto;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.entity.User;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.exceptions.ConflictException;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.repository.IUsersRepository;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.services.user.IUsersService;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.services.user.UserServiceImpl;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.util.UserRoles;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UserServiceTests {

    @Mock
    IUsersRepository usersRepository;

    @InjectMocks
    UserServiceImpl userService;

    User user;
    RegisterUserDto registerUserDto;


    @BeforeEach
    public void setup(){
        user = User.builder()
                .userRole(UserRoles.SUPERVISOR)
                .username("testRegister")
                .name("testRegister")
                .hashedPassword("$2a$10$Ensyjesz9McAic6jcrkw/eNXhiyIoY.TM1rr.jEs1lVorraF07ACu") //12345
                .build();

       registerUserDto = RegisterUserDto.builder()
                .username(user.getUsername())
                .name(user.getName())
                .password("12345")
                .rol(UserRoles.SUPERVISOR)
                .build();
    }

    @Test
    @DisplayName("User registration Test - Good Case")
    public void registerUserGoodCase(){
        RegisterUserDto registerUserDto = RegisterUserDto.builder()
                                                .username(user.getUsername())
                                                .name(user.getName())
                                                .password("12345")
                                                .rol(UserRoles.SUPERVISOR)
                                                .build();

        Mockito.when(usersRepository.findByUsername(user.getUsername())).thenReturn(null);
        Mockito.when(usersRepository.save(any(User.class))).thenReturn(null);

        // Call the service method to test
        userService.register(registerUserDto);

        // Verify that save was called once
        verify(usersRepository, times(1)).save(any(User.class));

    }

    @Test
    @DisplayName("User registration Test - Bad Case")
    public void registerUserBadCase(){
        Mockito.when(usersRepository.findByUsername(user.getUsername())).thenReturn(user);
        Assertions.assertThrows(ConflictException.class, () -> userService.register(registerUserDto));
    }
}
