package com.bootcamp.JPAImplementation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaImplementationApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaImplementationApplication.class, args);
	}

}
/*
Nos interesa poder llevar el registro de todos los Cursos brindados en la institución.
Cada curso lleva un nombre, un docente a cargo y varios mentores. De los docentes y mentores interesa su nombre y apellido,
así como también su dirección de correo electrónico.

 */
