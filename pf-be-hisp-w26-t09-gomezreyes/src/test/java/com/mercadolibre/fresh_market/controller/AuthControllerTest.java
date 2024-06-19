package com.mercadolibre.fresh_market.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.fresh_market.config.security.AuthService;
import com.mercadolibre.fresh_market.dtos.AuthDTO;
import com.mercadolibre.fresh_market.dtos.ResponseJWTDTO;
import com.mercadolibre.fresh_market.dtos.UserDTO;
import com.mercadolibre.fresh_market.model.User;
import com.mercadolibre.fresh_market.model.enums.Role;
import com.mercadolibre.fresh_market.repository.IUserRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AuthControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Mock
    private IUserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

    @Test
    public void testRegisterSuccessful() throws Exception {
        UserDTO userDto = new UserDTO();
        userDto.setFirstName("John");
        userDto.setLastName("Doe");
        userDto.setEmail("john.doe1@email.com");
        userDto.setPassword("password123");
        userDto.setAddress("123 Street");
        userDto.setRole(Role.WAREHOUSEMAN);

        String expected = writer.writeValueAsString(userDto);

        when(userRepository.findUserByEmail(userDto.getEmail())).thenReturn(null);

        when(passwordEncoder.encode(userDto.getPassword())).thenReturn("hashedPassword");

        MvcResult mvcResult = mockMvc.perform(post("/api/v1/fresh-products/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(userDto)))
                .andExpect(status().isCreated())
                .andReturn();

        String actual = mvcResult.getResponse().getContentAsString();

        assertEquals(expected, actual);
    }
}