package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;


@RequiredArgsConstructor
@ExtendWith(MockitoExtension.class)
class ObetenerDiplomaApplicationTests {
	@Mock
	private static StudentDAO studentDao = new StudentDAO();
	@InjectMocks
	private ObtenerDiplomaService diplomaService;
	private StudentDTO student;
	List<SubjectDTO> subjects = new ArrayList<>();
	@BeforeEach
	private void setup(){
		// seteamos el usuario que probaremos, dejamos la lista de
		// //materias vacias asi dependiendo la prueba podremos probar los casos borde
		student = new StudentDTO();
		student.setId(1L);
		student.setStudentName("Juan Perez");
	}

	@Test
	@DisplayName("Juan tiene promedio 6.33")
	void TestObtenerDiplomaDebeMejorar(){
		String expectedMessage = "El alumno Juan Perez ha obtenido un promedio de "
				+ "6.33"
				+  ". Puedes mejorar.";
		//arrange
		SubjectDTO subjectOne = new SubjectDTO("matematica",9.0);
		SubjectDTO subjectTwo = new SubjectDTO("lengua", 0.0);
		SubjectDTO subjectThree = new SubjectDTO("fisica", 10.0);
		subjects.add(subjectOne);
		subjects.add(subjectTwo);
		subjects.add(subjectThree);
		student.setSubjects(subjects);
		//act
		when(studentDao.findById(1L)).thenReturn(student);
		StudentDTO result = diplomaService.analyzeScores(1L);
		//asserts
		Assertions.assertEquals(result.getAverageScore(), (double) 19/3);
		Assertions.assertEquals(result.getMessage(), expectedMessage);
	}

	@Test
	@DisplayName("Juan tiene promedio 10 y obtiene sus felicitaciones")
	void TestObtenerDiplomaSobresaliente(){
		//arrange
		String expectedMessage = "El alumno Juan Perez ha obtenido un promedio de "
				+ new DecimalFormat("#.##").format(10)
				+  ". Felicitaciones!";
		SubjectDTO subjectOne = new SubjectDTO("matematica",10.0);
		SubjectDTO subjectTwo = new SubjectDTO("lengua", 10.0);
		SubjectDTO subjectThree = new SubjectDTO("fisica", 10.0);
		subjects.add(subjectOne);
		subjects.add(subjectTwo);
		subjects.add(subjectThree);
		student.setSubjects(subjects);
		//act
		when(studentDao.findById(1L)).thenReturn(student);
		StudentDTO result = diplomaService.analyzeScores(1L);
		//asserts
		Assertions.assertEquals(result.getAverageScore(), 10);
		Assertions.assertEquals(result.getMessage(), expectedMessage);
	}
}
