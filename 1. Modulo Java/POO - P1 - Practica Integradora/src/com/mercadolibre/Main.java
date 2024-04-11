package com.mercadolibre;

public class Main {
    public static void main(String[] args) {
        Persona p1 = new Persona();
        Persona p2 = new Persona("Joaquin", "54321", 23);
        Persona p3 = new Persona("Jonathan", "12345", 24, 62.4, 1.68);

        switch (p3.calcularIMC()) {
            case -1:
                System.out.println("Bajo peso");
                break;
            case 0:
                System.out.println("Peso saludable");
                break;
            case 1:
                System.out.println("Sobrepeso");
                break;

            default:
                System.out.println("Valor de IMC incorrecto");
        }

        System.out.println("¿Es mayor de edad? " + (p3.esMayorDeEdad() ? "Sí" : "No"));
        System.out.println(p3.toString());
    }
}
