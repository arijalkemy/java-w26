package com.meli.obtenerdiploma.controller;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTests {

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
