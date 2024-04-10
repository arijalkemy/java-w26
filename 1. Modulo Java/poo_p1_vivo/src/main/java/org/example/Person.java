package org.example;

public class Person {
    private String name;
    private int age;
    private String dni;
    private int weight;
    private float height;

    public Person() {
    }

    public Person(String name, int age, String dni) {
        this.name = name;
        this.age = age;
        this.dni = dni;
    }

    public Person(String name, int age, String dni, int weight, float height) {
        this.name = name;
        this.age = age;
        this.dni = dni;
        this.weight = weight;
        this.height = height;
    }

    public short calcularIMC() {
        double imc = this.weight/(Math.pow(this.height, 2));
        if (imc < 20) return -1;
        if (imc <= 25) return 0;
        return 1;
    }

    public boolean esMayorDeEdad() {
        return this.age >= 18;
    }

    @Override
    public String toString() {
        return "Nombre: " + name + " | " +
                "Edad: " + age + " | " +
                "DNI: " + dni + " | " +
                "Peso: " + weight + " | " +
                "Altura: " + height;
    }
}
