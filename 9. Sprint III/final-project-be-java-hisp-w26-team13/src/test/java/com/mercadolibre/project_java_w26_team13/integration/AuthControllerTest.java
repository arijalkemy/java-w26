//package com.mercadolibre.project_java_w26_team13.integration;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.ObjectWriter;
//import com.fasterxml.jackson.databind.SerializationFeature;
//import com.mercadolibre.project_java_w26_team13.dtos.LoginRequestDto;
//import com.mercadolibre.project_java_w26_team13.dtos.RegisterRequestDto;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class AuthControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    private ObjectWriter writer;
//
//    @BeforeEach
//    public void setup() {
//        this.writer = new ObjectMapper()
//                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
//                .writer()
//                .withDefaultPrettyPrinter();
//    }
//
//    @Test
//    void invalidLoginTest() throws Exception {
//        LoginRequestDto loginRequestDto = new LoginRequestDto("nonExistingUser", "password");
//        String payloadJSON = writer.writeValueAsString(loginRequestDto);
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/auth/login")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(payloadJSON))
//                .andDo(print())
//                .andExpect(status().isUnauthorized())
//                .andExpect(content().contentTypeCompatibleWith("application/json"))
//                .andExpect(MockMvcResultMatchers
//                        .jsonPath("$.message")
//                        .value("Bad credentials"));
//    }
//
//    @Test
//    void registerTest() throws Exception {
//        RegisterRequestDto userToRegisterDto = new RegisterRequestDto("user1", "asd");
//        String payloadJSON = writer.writeValueAsString(userToRegisterDto);
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/auth/register")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(payloadJSON))
//                .andDo(print())
//                .andExpect(status().isInternalServerError())
//                .andExpect(content().contentTypeCompatibleWith("application/json"));
//    }
//}
