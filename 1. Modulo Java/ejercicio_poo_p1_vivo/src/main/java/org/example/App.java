package org.example;

public class App {
    public static void main( String[] args ) {
        // 4)
        Persona personaUno = new Persona();
        Persona personaDos = new Persona("Jose", 16, "39001122");
        Persona personaTres = new Persona("Jose", 18, "40112233", 60, 1.70);
        // Persona personaCuatro = new Persona("Juan", 17); - Esta sentencia da un error ya que no existe un constructor definido para ese número de parámetros

        // 6)
        System.out.println("Los datos completos de la persona son: " + personaTres.toString());

        int imc = personaTres.calcularIMC();
        switch (imc) {
            case -1:
                System.out.println("Según el Índice de Masa Corporal (IMC), la persona tiene bajo peso.");
                break;
            case 1:
                System.out.println("Según el Índice de Masa Corporal (IMC), la persona tiene sobrepeso.");
                break;
            case 0:
                System.out.println("Según el Índice de Masa Corporal (IMC), la persona tiene peso saludable.");
                break;
        }

        boolean esMayorDeEdad = personaTres.esMayorDeEdad();
        if(esMayorDeEdad) {
            System.out.println("La persona es mayor de edad.");
        } else {
            System.out.println("La persona es menor de edad.");
        }
    }
}
