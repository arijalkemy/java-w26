package org.example;

public class Persona {
    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;
    public Persona(){
    }
    public Persona(String nombre, int edad, String dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }
    public Persona(String nombre, int edad, String dni, double peso, double altura){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }
    public int calcularIMC(){
        double imc = this.peso / (this.altura * this.altura);
        if (imc < 20){
            return -1;
        }
        if (imc >= 20 && imc <= 25)
        {
            return 0;
        }
        return 1;
    }
    public boolean esMayorDeEdad(){
        if (this.edad >= 18){
            return true;
        }
        return false;
    }
    public String toString(){
        return "Nombre: " + this.nombre +
                ", edad: " + this.edad +
                ", DNI: " + this.dni +
                ", peso: " + this.peso + "Kg. " +
                ", altura: " + this.altura + "Mtrs.";
    }
}
