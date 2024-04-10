package org.example;

import org.example.model.Persona;

public class Main {
    public static void main(String[] args) {
        Persona personaVacia = new Persona();
        Persona personaAlgunos = new Persona("Juan Carlos", 21,"344555");
        Persona personaCompleta = new Persona("Maria Gonzalez", 32, "10002322", 55.7, 0 );

        switch (personaCompleta.calculaIMC()){
            case -1: System.out.println("Según tu IMC: Bajo peso");
            break;
            case 0: System.out.println("Según tu IMC: Peso saludable");
            break;
            case 1: System.out.println("Según tu IMC: Sobrepeso");
            break;
            default: System.out.println("Valores de peso y/o altura son incorrectos");
        }
        System.out.println("¿Eres mayor de edad? : "+personaCompleta.esMayorDeEdad());
        System.out.println(personaCompleta);
    }
}