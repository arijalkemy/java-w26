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
	StudentDAO studentDao = new StudentDAO();
	@InjectMocks
	private ObtenerDiplomaService diplomaService;
	private StudentDTO student;

	@BeforeEach
	private void setup(){
		// seteamos el usuario que probaremos
		List<SubjectDTO> subjects = new ArrayList<>();
		SubjectDTO subjectOne = new SubjectDTO("matematica",9.0);
		SubjectDTO subjectTwo = new SubjectDTO("lengua", 0.0);
		SubjectDTO subjectThree = new SubjectDTO("fisica", 10.0);
		subjects.add(subjectOne);
		subjects.add(subjectTwo);
		subjects.add(subjectThree);
		student = new StudentDTO();
		student.setId(1L);
		student.setStudentName("Juan Perez");
		student.setSubjects(subjects);

	}

	@Test
	@DisplayName("Juan tiene promedio 6.33")
	void TestObtenerDiplomaService(){

		//arrange
		when(studentDao.findById(1L)).thenReturn(student);
		//act
		StudentDTO result = diplomaService.analyzeScores(1L);
		//asserts

		Assertions.assertEquals(result.getAverageScore(), (double) 19/3);

	}

}
