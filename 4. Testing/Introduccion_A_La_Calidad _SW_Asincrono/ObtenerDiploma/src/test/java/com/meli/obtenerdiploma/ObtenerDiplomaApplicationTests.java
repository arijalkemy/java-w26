package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ObetenerDiplomaApplicationTests {
	private ObtenerDiplomaService service;
	@BeforeEach
	public void setUp(){
		service = new ObtenerDiplomaService();
	}
	@Test
	public void dadoEstudianteValido_cuandoAnalizaPuntajes_entoncesElPromedioCorrectoYMensaje() {
		//Arrange (Dado)
		StudentDTO student = new StudentDTO();
		student.setStudentName("Juan");
		student.setSubjects(Arrays.asList(
				new SubjectDTO("Cálculo", 8.0),
				new SubjectDTO("Literatura", 9.0)
		));
		//When (Cuando)
		student = service.analyzeScores(student);

		//Assert(then)
		assertEquals(8.5,student.getAverageScore(), "El promedio de las notas no es correcto");
		assertEquals("El alumno Juan ha obtenido un promedio de 8,5. Puedes mejorar.", student.getMessage(), "El mensaje no coincide con lo esperado");

	}
}