package com.testing.obtenerdiploma_integracion;

import com.testing.obtenerdiploma_integracion.controller.ObtenerDiplomaController;
import com.testing.obtenerdiploma_integracion.controller.StudentController;
import com.testing.obtenerdiploma_integracion.exception.ObtenerDiplomaException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ObtenerdiplomaIntegracionApplicationTests {

	@Autowired
	private ObtenerDiplomaController obtenerDiplomaController;

	@Autowired
	private StudentController studentController;

	@Test
	void contextLoads() {
		Assertions.assertNotNull(obtenerDiplomaController);
		Assertions.assertNotNull(studentController);
	}

}
