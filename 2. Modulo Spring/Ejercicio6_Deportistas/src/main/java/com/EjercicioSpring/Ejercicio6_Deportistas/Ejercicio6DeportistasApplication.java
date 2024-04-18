package com.EjercicioSpring.Ejercicio6_Deportistas;

import com.EjercicioSpring.Ejercicio6_Deportistas.baseDeDatos.BaseDeDatos;
import com.EjercicioSpring.Ejercicio6_Deportistas.entities.Deporte;
import com.EjercicioSpring.Ejercicio6_Deportistas.entities.Persona;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Ejercicio6DeportistasApplication {

	public static void main(String[] args) {
		cargarDatos();
		SpringApplication.run(Ejercicio6DeportistasApplication.class, args);
	}

	public static void cargarDatos() {
		List<Persona> personas = new ArrayList<>();
		List<Deporte> deportes = new ArrayList<>();

		// Agregar personas a la lista
		personas.add(new Persona("Juan", "López", 25));
		personas.add(new Persona("María", "García", 30));
		personas.add(new Persona("Pedro", "Martínez", 28));
		personas.add(new Persona("Ana", "Rodríguez", 35));
		personas.add(new Persona("Luis", "Fernández", 40));
		personas.add(new Persona("Sofía", "Pérez", 22));
		personas.add(new Persona("Carlos", "Ruiz", 33));
		personas.add(new Persona("Elena", "Sánchez", 27));
		personas.add(new Persona("Diego", "Díaz", 29));
		personas.add(new Persona("Laura", "Gómez", 31));
		personas.add(new Persona("Andrés", "Hernández", 26));
		personas.add(new Persona("Paula", "Torres", 24));
		personas.add(new Persona("Miguel", "Jiménez", 37));
		personas.add(new Persona("Lucía", "Morales", 39));
		personas.add(new Persona("Javier", "Álvarez", 34));
		// Continuar agregando más personas...

		// Agregar deportes a la lista
		deportes.add(new Deporte("Fútbol", "Principiante"));
		deportes.add(new Deporte("Baloncesto", "Intermedio"));
		deportes.add(new Deporte("Natación", "Avanzado"));
		deportes.add(new Deporte("Tenis", "Principiante"));
		deportes.add(new Deporte("Atletismo", "Intermedio"));
		deportes.add(new Deporte("Ciclismo", "Avanzado"));
		deportes.add(new Deporte("Voleibol", "Principiante"));
		deportes.add(new Deporte("Gimnasia", "Intermedio"));
		deportes.add(new Deporte("Boxeo", "Avanzado"));
		deportes.add(new Deporte("Karate", "Principiante"));
		deportes.add(new Deporte("Surf", "Intermedio"));
		deportes.add(new Deporte("Escalada", "Avanzado"));
		deportes.add(new Deporte("Yoga", "Principiante"));
		deportes.add(new Deporte("Pilates", "Intermedio"));
		deportes.add(new Deporte("Esquí", "Avanzado"));

		BaseDeDatos.getBaseDeDatos().setDeportes(deportes);
		BaseDeDatos.getBaseDeDatos().setPersonas(personas);
	}



}
