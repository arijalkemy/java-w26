package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona();
        Persona persona2 = new Persona("Dixon",29,"24538231");
        Persona persona3 = new Persona("Dixon",29,"24538234",64, 1.70);
        System.out.println(persona3.toString());
        System.out.println(persona3.getNombreIMC(persona3.calcularIMC()));
        System.out.println(persona3.getNombre() + " es: " + (persona3.esMayorDeEdad()? "Mayor de Edad":"Menor de Edad"));
    }
}