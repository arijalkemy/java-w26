package org.example;

public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

    public Persona() {

    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC() {
        if (peso <= 0) {
            throw new IllegalArgumentException("El peso de la persona no es correcto");
        }
        double resultado = this.peso / (this.altura * this.altura);
        if (resultado < 20) {
            return -1;
        } else if (resultado > 25) {
            return 1;
        } else {
            return 0;
        }
    }

    public boolean esMayorDeEdad() {
        return (this.edad >= 18);
    }

    @Override
    public String toString() {
        return " - Datos de la persona - \n" +
                "nombre: " + nombre + '\n' +
                "edad: " + edad + '\n' +
                "dni: " + dni + '\n' +
                "peso: " + peso + '\n' +
                "altura: " + altura;
    }
}
