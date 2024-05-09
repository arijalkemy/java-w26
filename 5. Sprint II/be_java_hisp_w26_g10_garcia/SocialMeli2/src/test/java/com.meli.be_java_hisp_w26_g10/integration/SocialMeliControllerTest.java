package com.meli.be_java_hisp_w26_g10.integration;

import com.api.socialmeli.BeJavaHispW26G10Application;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(classes = BeJavaHispW26G10Application.class)
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class SocialMeliControllerTest {

    @Autowired
    MockMvc mockMvc;

}
