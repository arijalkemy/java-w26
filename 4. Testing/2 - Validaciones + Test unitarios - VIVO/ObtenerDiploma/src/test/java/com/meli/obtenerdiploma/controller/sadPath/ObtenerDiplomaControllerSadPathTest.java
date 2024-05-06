package com.meli.obtenerdiploma.controller.sadPath;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;

@WebMvcTest(controllers = ObtenerDiplomaController.class)
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerSadPathTest {
    @MockBean
    IObtenerDiplomaService obtenerDiplomaService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    public StudentDTO createDTO(){
        return new StudentDTO(
                1L,
                "Jose",
                "",
                0.0,
                new ArrayList<SubjectDTO>(Arrays.asList(
                        new SubjectDTO(
                                "Fisica",
                                10.0
                        ),
                        new SubjectDTO(
                                "Graficacion",
                                9.0
                        ),
                        new SubjectDTO(
                                "Circuitos",
                                6.0
                        )
                ))
        );
    }

}
