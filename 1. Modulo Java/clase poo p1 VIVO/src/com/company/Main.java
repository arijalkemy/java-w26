package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Persona personaVacia = new Persona();
        Persona personaIncompleta = new Persona("Carlitos", 24,"44449999");
        Persona personaCompleta = new Persona("Sebastian",99,"00000001",99.00,1.90);
        System.out.println(personaCompleta.calcularMC());
        System.out.println(personaCompleta.esMayorDeEdad());
        Utils.output(personaCompleta.calcularMC());
    }
}
