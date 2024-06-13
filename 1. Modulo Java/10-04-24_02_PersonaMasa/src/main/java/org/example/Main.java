package org.example;
// Ejercicio 3
public class Main {
    public static void main(String[] args) {
        // Aquí declararemos los objetos de tipo Persona
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Juan", 25, "12345678A");
        Persona persona3 = new Persona("Ana", 30, "87654321B", 65.0, 1.70);

        // Intento de creación con solo nombre y edad (no es posible con los constructores definidos)
        // Persona persona4 = new Persona("Carlos", 40); // Esto generará un error de compilación

        // Creación correcta con todos los parámetros
        Persona persona4 = new Persona("Luis", 28, "33445566C", 70.0, 1.75);

        // Ejercicio 6
        // Calcular el IMC de la última persona creada
        int imcResult = persona4.calcularIMC();
        switch (imcResult) {
            case -1:
                System.out.println("La persona tiene bajo peso.");
                break;
            case 0:
                System.out.println("La persona tiene un peso saludable.");
                break;
            case 1:
                System.out.println("La persona tiene sobrepeso.");
                break;
        }

        // Verificar si es mayor de edad
        if (persona4.esMayorDeEdad()) {
            System.out.println("La persona es mayor de edad.");
        } else {
            System.out.println("La persona es menor de edad.");
        }

        // Mostrar toda la información de la persona
        System.out.println(persona4);
    }
}

