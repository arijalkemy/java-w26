package controller;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.verification.AtLeast;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    @Mock
    private IObtenerDiplomaService obtDiplomaServiceMock;

    @InjectMocks
    private ObtenerDiplomaController obtenerDiplomaControllerUnderTest;

    @Test
    @DisplayName("Dado un id se llama al metodo analyzeScores del servicio")
    public void analyzeScoresTest() {
        Long studentId = 1L;

        obtenerDiplomaControllerUnderTest.analyzeScores(studentId);

        verify(obtDiplomaServiceMock, atLeastOnce()).analyzeScores(studentId);
    }
}
