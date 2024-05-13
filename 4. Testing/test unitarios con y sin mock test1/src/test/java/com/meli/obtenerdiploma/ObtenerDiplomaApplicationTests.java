package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ObtenerDiplomaApplicationTests {

	private StudentRepository studentRepository;
	private StudentDAO studentDAO;

	@BeforeEach
	public void setUp() {
		studentRepository = new StudentRepository();
		studentDAO = new StudentDAO();
	}

	@Test
	@DisplayName("agregar alumno")
	public void agregarAlumno() {
		StudentDTO arturo = new StudentDTO();
		SubjectDTO	subjectDTO = new SubjectDTO();
		List<SubjectDTO> subjectDTOList = new ArrayList<>();
		subjectDTOList.add(subjectDTO);

		subjectDTO.setName("mate");
		subjectDTO.setScore(8.0);

		arturo.setStudentName("arturo");
		arturo.setSubjects(subjectDTOList);

		studentDAO.save(arturo);

		Assertions.assertEquals(21, arturo.getId());
	}

	@Test
	@DisplayName("buscar alumno por id")
	public void buscarAlumnoPorId() {
		StudentDTO studentDTO = studentDAO.findById(17L);
		Assertions.assertEquals(17, studentDTO.getId());
	}

	@Test
	@DisplayName("actualizar un alumono con nombre")
	public void actualizarAlumnoConNombre() {
		StudentDTO arturo = new StudentDTO();

		arturo.setStudentName("luis arturo lopez");
		arturo.setId(17L);

		studentDAO.save(arturo);

		Assertions.assertEquals(17, arturo.getId());
	}

	@Test
	@DisplayName("eliminar alumno")
	public void eliminarAlumno() {
		boolean resultadoElimonacion = studentDAO.delete(17L);
		Assertions.assertTrue(resultadoElimonacion);
	}
}