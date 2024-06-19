package com.mercadolibre.pf_be_hisp_w26_t01_coro.unit.service;

import com.mercadolibre.pf_be_hisp_w26_t01_coro.entity.User;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.exceptions.ApiException;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.repository.IUserRepository;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.service.UserService;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.utils.UserBuilder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private  IUserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    @Test
    void searchByEmail_Ok(){
        //arrange
        String email = "jgual@gmail.com";
        User u = new User();
        u.setEmail("jgual@gmail.com");
        when(userRepository.findByEmail(email)).thenReturn(Optional.of(u));
        //act
        User result = userService.searchByEmail(email);

        //Assertions
        Assertions.assertEquals(email,result.getEmail());
    }

    @Test
    void searchByEmail_NotFound(){
        //arrange
        String email = "jgual@gmail.com";

        when(userRepository.findByEmail(email)).thenReturn(Optional.empty());

        //Assertions
        Assertions.assertThrows(ApiException.class, () -> userService.searchByEmail(email));
    }

    @Test
    void searchUserByIdCorrectly(){

        User user = UserBuilder.getUser();
        Mockito.when(userRepository.findById(1)).thenReturn(Optional.of(user));

        Assertions.assertEquals(user,userService.searchUserById(1));
    }

    @Test
    void searchUserByIdAndNotFound(){
        Integer userId = 1;
        Mockito.when(userRepository.findById(1)).thenReturn(Optional.empty());
        Assertions.assertThrows(ApiException.class,() -> userService.searchUserById(userId));
    }
    @Test
    void searchByEmailOrNUll_ReturnsUserWhenEmailExists() {
        String email = "test@gmail.com";
        User user = new User();
        user.setEmail(email);

        when(userRepository.findByEmail(email)).thenReturn(Optional.of(user));

        User result = userService.searchByEmailOrNUll(email);

        Assertions.assertEquals(email, result.getEmail());
    }

    @Test
    void searchByEmailOrNUll_ReturnsNullWhenEmailDoesNotExist() {
        String email = "test@gmail.com";

        when(userRepository.findByEmail(email)).thenReturn(Optional.empty());

        User result = userService.searchByEmailOrNUll(email);

        Assertions.assertNull(result);
    }

    @Test
    void saveUser_EncodesPasswordAndSavesUser() {
        User user = new User();
        user.setPassword("password");

        when(userRepository.save(user)).thenReturn(user);
        when(passwordEncoder.encode(user.getPassword())).thenReturn("encodedPassword");

        User result = userService.saveUser(user);

        Assertions.assertNotEquals("password", result.getPassword());
        Assertions.assertEquals(user, result);
    }
}
