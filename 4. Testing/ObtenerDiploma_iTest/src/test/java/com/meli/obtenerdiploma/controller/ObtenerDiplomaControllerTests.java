package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTests {
/*
Ejercicio 1
Se requiere crear los tests de integración necesarios para cubrir el comportamiento de la capa
de los controladores ObtenerDiplomaController y StudentController. Tener en cuenta múltiples
escenarios, incluidos las validaciones, mensajes de error y Excepciones.

 Ejercicio 2
Luego de finalizados los ejercicios (y prácticas) anteriores verificar que se haya obtenido una
cobertura de líneas (coverage) superior al 80%. De no alcanzarse ese nivel, revisar tanto los
Tests de Unidad (con y sin Mocks) como los Tests de Integración hasta que se logre el estándar requerido.
 */
    @Mock
    IObtenerDiplomaService service;

    @InjectMocks
    ObtenerDiplomaController controller;

    @Test
    public void obtenerDiploma() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // act
        controller.analyzeScores(stu.getId());

        // assert
        verify(service, atLeastOnce()).analyzeScores(stu.getId());
    }

}
