package com.company;

public class Main {

    public static void main(String[] args) {
	    Persona personaNull = new Persona();
	    Persona personaConNombreEdadYDNI = new Persona("Juancito Perez", 23, "12345678");
	    Persona personaConTodo = new Persona("Juancito Perez", 10, "12345678", 800, 1.89);

	    int imc = personaConTodo.calcularIMC();

        System.out.println("IMC de la persona: " + (imc == 0 ? "Peso saludable" : (imc == 1 ? "Sobrepeso" : "Bajo peso")));
        System.out.println("Es mayor de edad? " + personaConTodo.esMayorDeEdad());
        System.out.println("======== INFO DE LA PERSONA =========");
        System.out.println(personaConTodo.toString());
    }

}
