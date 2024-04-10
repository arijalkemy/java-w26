package com.company;

public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private float peso;
    private float altura;

    public Persona() {
    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, float peso, float altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC() {
        float imc = (float) (peso/(Math.pow(altura, 2)));
        if (imc < 20) {
            return -1;
        }
        if (imc >= 20 && imc <= 25) {
            return 0;
        }
        return 1;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getDni() {
        return dni;
    }

    public float getPeso() {
        return peso;
    }

    public float getAltura() {
        return altura;
    }

    public boolean esMayorDeEdad() {
        if (edad >= 18) return true;
        return false;
    }

    @Override
    public String toString() {
        return "Datos persona -" +
                " nombre: " + nombre +
                ", edad: " + edad +
                ", dni: " + dni +
                ", peso: " + peso +
                ", altura: " + altura;
    }
}
