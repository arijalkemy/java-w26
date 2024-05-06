package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaControllerTest {
    //ejercicio 4
    @Mock
    IObtenerDiplomaService service;

    @InjectMocks
    ObtenerDiplomaController Controller;

@Test
@DisplayName("Diploma de un estudiante")
    void obtenerDiploma() {

        // arrange
        StudentDTO stu =  new StudentDTO(1L, "John Doe","message",8D,
            List.of(
                    new SubjectDTO("Math", 10D),
                    new SubjectDTO("Science", 9D),
                    new SubjectDTO("History", 8D)));

        when(service.analyzeScores(stu.getId())).thenReturn(stu);

        // act
        Controller.analyzeScores(stu.getId());

        // assert
       verify(service, atLeastOnce()).analyzeScores(stu.getId());

}







}