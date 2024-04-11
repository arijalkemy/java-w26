package org.example;

public class Main {
    public static void main(String[] args) {
        Persona personaSinParametros = new Persona();
        Persona personaMitadParametros = new Persona("Pepe", 18, "111111");
        Persona personaFullParametros = new Persona("Ramon", 50, "222222", 70, 1.7);

        //Ejercicio 4
        //Como no existe un constructor que admita solo 2 parametros no podemos instanciar la clase
        //Persona personaDosParametros = new Persona("Error", 50);

        int IMC = personaFullParametros.calcularIMC();
        boolean esMayorEdad = personaFullParametros.esMayorDeEdad();

        System.out.println(personaFullParametros);

        if (esMayorEdad) {
            System.out.println("Es mayor de edad");
        }
        else {
            System.out.println("No es mayor de edad");
        }

        if (IMC == -1) {
            System.out.println("Bajo peso");
        }
        else if (IMC == 0) {
            System.out.println("Peso saludable");
        }
        else {
            System.out.println("Sobrepeso");
        }
    }
}