package controller;


import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    @Mock
    private IObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    private ObtenerDiplomaController obtenerDiplomaController;

    StudentDTO student = new StudentDTO(2L, "Cristina", "Felicitaciones", 50D,
                                     List.of(new SubjectDTO("Matematicas", 9.5D),
                        new SubjectDTO("biologia", 9.5D),
                        new SubjectDTO("politica", 9.5D)));

   @Test
    void shouldAnalizeScore(){
       when(obtenerDiplomaService.analyzeScores(1L)).thenReturn(student);
       StudentDTO response =  obtenerDiplomaController.analyzeScores(1L);
       Assertions.assertEquals(response, student);
   }


}
