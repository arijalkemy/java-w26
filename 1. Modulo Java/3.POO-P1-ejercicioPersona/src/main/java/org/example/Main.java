package org.example;

public class Main {
    public static void main(String[] args) {
        //EJERCICIO 4
        Persona personaCoonstructorVacio = new Persona();
        Persona personaConstructorIncompleto = new Persona("Andres", 23, "1233123");
        Persona personaConstructorCompleto = new Persona("Juan", 24, "1233123", 70, 1.70);
        //Persona persona = new Persona("JUAN", 23); -> NO ES POSIBLE PORQUE EL CONSTRUCTOR NO EXISTE, INMEDIATAMENTE EL IDE RECONOCE QUE NO SE PUEDE RESOLVER ESTE CONSTRUCTOR
        System.out.println(personaConstructorCompleto.esMayorDeEdad() ? "Es mayor de edad" : "No es mayor de edad");

        System.out.println("------ DATOS DE LA PERSONA -----");
        System.out.println(personaConstructorCompleto.toString());
        System.out.println(personaConstructorCompleto.esMayorDeEdad() ? "Es mayor de edad" : "No es mayor de edad");
        try {
            switch (personaConstructorCompleto.calcularImc()) {
                case -1:
                    System.out.println("Analisis IMC: La persona esta por debajo de su peso ideal");
                    break;
                case 0:
                    System.out.println("Analisis IMC: La persona está en su peso ideal");
                    break;
                case 1:
                    System.out.println("Analisis IMC: La persona esta por encima de su peso ideal");
                    break;
            }

        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }

    }
}
