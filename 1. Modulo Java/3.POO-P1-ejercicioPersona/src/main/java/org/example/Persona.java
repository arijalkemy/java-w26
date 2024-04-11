package org.example;

public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

    public Persona(String nombre, int edad, String dni, int peso, double alto) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = alto;
    }

    public Persona() {

    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    // EJERCICIO 5
    public int calcularImc() {
        //validacion de valores de peso  y altura
        if (this.peso <= 0 || this.altura <= 0) {
            throw new IllegalArgumentException("El peso y la altura deben ser mayores que cero");
        }

        double imc = this.peso / Math.pow(this.altura, 2);
        if (imc < 20) {
            return -1;
        }
        if (imc >= 20 && imc <= 25) {
            return 0;
        }
        System.out.println(imc);
        return 1;
    }

    public boolean esMayorDeEdad() {
        return this.edad >= 18;
    }

    public String toString() {
        return "Nombre: " + this.nombre + "\nEdad: " + this.edad + "\nDNI: " + this.dni + "\nPeso: " + this.peso + "\nAltura: " + this.altura;
    }
}
