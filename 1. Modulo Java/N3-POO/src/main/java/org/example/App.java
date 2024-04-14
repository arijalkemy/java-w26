package org.example;

public class App {
    public static void main(String[] args) {
        Persona personaNull = new Persona();
        Persona personaALaMitad = new Persona("Esteban Quito", 22, "12345678");
        Persona personaCompleta = new Persona("Armando Casas", 100, "87654321", 60, 1.50);

        switch(personaCompleta.calcularIMC()){
            case 1:
                System.out.println("La persona " + personaCompleta.getNombre() + " tiene sobrepeso");
                break;
            case 0:
                System.out.println("La persona " + personaCompleta.getNombre() +" tiene peso saludable");
                break;
            case -1:
                System.out.println("La persona " + personaCompleta.getNombre() + " tiene bajo peso.");
                break;
        }
        System.out.println("La persona " + personaCompleta.getNombre() + " es " + (personaCompleta.esMayorDeEdad() ? "mayor" : "menor") + " de edad.");
        System.out.println("Los datos de la persona son los siguientes: "+ personaCompleta);

    }
}