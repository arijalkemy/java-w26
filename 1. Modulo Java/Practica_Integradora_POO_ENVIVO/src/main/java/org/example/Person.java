package org.example;
public class Person {
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

    public Person() {
    }

    public Person(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Person(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }
    public double calcularIMC(){
        double IMC =peso/Math.pow(altura,2);
        if(IMC<20){
            return -1;
        }else if(IMC<=25){
            return 0;
        }else {
            return 1;
        }
    }
    public boolean esMayorDeEdad(){
        return edad>=18;
    }
    @Override
    public String toString() {
        return "Person{" + "nombre='" + nombre + '\'' + ", edad=" + edad + ", dni='" + dni + '\'' + ", peso=" + peso + ", altura=" + altura + '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}