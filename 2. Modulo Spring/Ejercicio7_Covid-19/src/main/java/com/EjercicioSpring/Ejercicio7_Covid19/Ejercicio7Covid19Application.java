package com.EjercicioSpring.Ejercicio7_Covid19;

import com.EjercicioSpring.Ejercicio7_Covid19.baseDeDatos.BaseDeDatos;
import com.EjercicioSpring.Ejercicio7_Covid19.entity.Persona;
import com.EjercicioSpring.Ejercicio7_Covid19.entity.Sintoma;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Ejercicio7Covid19Application {

	public static void main(String[] args) {
		cargarDatos();
		SpringApplication.run(Ejercicio7Covid19Application.class, args);
	}

	public static void cargarDatos() {
		BaseDeDatos bd = BaseDeDatos.getBaseDeDatos();
		List<Persona> personas = new ArrayList<>();
		List<Sintoma> sintomas = new ArrayList<>();

		// Llenar la lista de personas
		personas.add(new Persona(1, "Juan", "López", 35));
		personas.add(new Persona(2, "María", "García", 28));
		personas.add(new Persona(3, "Pedro", "Martínez", 42));
		personas.add(new Persona(4, "Ana", "Rodríguez", 25));
		personas.add(new Persona(5, "Luis", "Fernández", 30));
		personas.add(new Persona(6, "Laura", "Pérez", 38));
		personas.add(new Persona(7, "Carlos", "Sánchez", 94));
		personas.add(new Persona(8, "Sofía", "Díaz", 79));
		personas.add(new Persona(9, "Javier", "Gómez", 40));
		personas.add(new Persona(10, "Marta", "Hernández", 27));
		personas.add(new Persona(11, "Andrés", "Vázquez", 36));
		personas.add(new Persona(12, "Elena", "López", 31));
		personas.add(new Persona(13, "Pablo", "Ruiz", 65));
		personas.add(new Persona(14, "Carmen", "Martínez", 26));
		personas.add(new Persona(15, "Diego", "García", 34));
		personas.add(new Persona(16, "Paula", "Sánchez", 41));
		personas.add(new Persona(17, "Daniel", "Fernández", 32));
		personas.add(new Persona(18, "Lucía", "Díaz", 61));
		personas.add(new Persona(19, "Alejandro", "Gómez", 24));
		personas.add(new Persona(20, "Rocío", "Hernández", 73));


		// Llenar la lista de síntomas
		sintomas.add(new Sintoma(101, "Dolor de cabeza", "Moderado"));
		sintomas.add(new Sintoma(102, "Fiebre", "Alto"));
		sintomas.add(new Sintoma(103, "Tos seca", "Leve"));
		sintomas.add(new Sintoma(104, "Fatiga", "Moderado"));
		sintomas.add(new Sintoma(105, "Dificultad para respirar", "Alto"));
		sintomas.add(new Sintoma(106, "Dolor de garganta", "Leve"));
		sintomas.add(new Sintoma(107, "Congestión nasal", "Leve"));
		sintomas.add(new Sintoma(108, "Mareos", "Moderado"));

		bd.setPersonas(personas);
		bd.setSintomas(sintomas);
	}

}
