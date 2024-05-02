package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class OpetenerDiplomaApplicationTestsEjercicio_1 {

	@Mock
	IStudentRepository studentRepository;

	@Mock
	IStudentDAO studentDAO;

	@BeforeEach
	void setUp(){
		MockitoAnnotations.openMocks(this);
	}

	@Test
	@DisplayName("Validate studentRepository.findAll: it should returns a Set of StudentDTO")
	public void studentRepositoryappyPathTest() {
		// Init configuration for the test
		Set<StudentDTO> emptyStudentSet = new HashSet<>();
		when(studentRepository.findAll()).thenReturn(emptyStudentSet);

		// Assert configuration
		Set<StudentDTO> result = studentRepository.findAll();
		System.out.println("------------- Size of the set: " + result.size());
		assertEquals(emptyStudentSet, result);
	}
}