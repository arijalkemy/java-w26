package com.mercadolibre;

public class Persona {
    String nombre;
    String dni;
    int edad;
    double peso;
    double altura;

    public Persona() {
    }

    public Persona(String nombre, String dni, int edad) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
    }

    public Persona(String nombre, String dni, int edad, double peso, double altura) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC() {
        double imc = peso / (altura * altura);
        if (imc < 20)
            return -1;
        else if (imc >= 20 && imc <= 25)
            return 0;

        return 1;
    }

    public boolean esMayorDeEdad() {
        if (edad < 18)
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", edad=" + edad +
                ", peso=" + peso +
                ", altura=" + altura;
    }
}
