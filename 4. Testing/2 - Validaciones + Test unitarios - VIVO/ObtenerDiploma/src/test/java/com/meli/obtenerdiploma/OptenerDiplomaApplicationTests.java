package com.meli.obtenerdiploma;

import com.fasterxml.jackson.core.JsonParseException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class OpetenerDiplomaApplicationTestsEjercicio_1 {

	@Autowired
	IStudentRepository studentRepository;

	@Mock
	IStudentDAO studentDAO;

	@BeforeEach
	void setUp(){
		MockitoAnnotations.openMocks(this);
	}

	@Test
	@DisplayName("Test findAll when file exists")
	void testFindAllWhenFileExists() throws IOException {
		// Call the method under test
		Set<StudentDTO> result = studentRepository.findAll();

		// Assert that the result is not null or empty, or apply specific assertions based on your expectations
		System.out.println(result.size());
		assertNotNull(result);
		assertFalse(result.isEmpty());
	}

	@Test
	@DisplayName("Test findAll when file does not exist")
	void testFindAllWhenFileDoesNotExist() throws IOException {
		// Mock behavior when file does not exist
		when(studentRepository.findAll()).thenThrow(FileNotFoundException.class);

		// Call the method under test
		assertThrows(FileNotFoundException.class, () -> studentRepository.findAll());
	}

	@Test
	@DisplayName("Test findAll when JSON is malformed")
	void testFindAllWhenMalformedJSON() throws IOException {
		// Mock behavior when JSON is malformed
		when(studentRepository.findAll()).thenThrow(JsonParseException.class);

		// Call the method under test
		assertThrows(JsonParseException.class, () -> studentRepository.findAll());
	}

//	@Test
//	@DisplayName("Validate studentDAO/findById/{id}: it should returns a Student StudentDTO")
//	public void setStudentDAOGetStudentByIdTest(){
//		StudentDTO studentFromDAO = new StudentDTO();
//		when(studentDAO.findById(1L)).thenReturn(studentFromDAO);
//
//		StudentDTO studentLocal = new StudentDTO();
//		studentLocal.setStudentName("Juan");
//		assertEquals(studentFromDAO.getStudentName(), "Juan");
//	}
}