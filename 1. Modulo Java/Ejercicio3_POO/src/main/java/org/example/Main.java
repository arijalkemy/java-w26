package org.example;

public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Cristopher", 27, "666");
        Persona persona3 = new Persona("Paula", 24, "12345", 45, 0);
        System.out.println(persona3.toString());
        System.out.printf("IMC: ");
        if (persona3.calcularIMC() == -1) {
            System.out.println("Bajo de peso");
        } else if (persona3.calcularIMC() == 0) {
            System.out.println("Peso saludable");
        } else {
            System.out.println("Sobrepeso");
        }
        if (persona3.esMayorDeEdad()) {
            System.out.println("Mayor de edad");
        } else {
            System.out.println("Menor de edad");
        }
    }
}