package com.viajescuidados.viajescuidados.controller;

import com.viajescuidados.controllers.PersonasController;
import com.viajescuidados.services.PersonasService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PersonaControllerTest {

    @Mock
    PersonasService personasService;

    @InjectMocks
    PersonasController personasController;



}
