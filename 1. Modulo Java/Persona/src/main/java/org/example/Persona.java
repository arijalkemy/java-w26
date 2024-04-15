package org.example;

import org.w3c.dom.ls.LSOutput;

public class Persona {
    String nombre;
    int edad;
    String dni;
    int peso;
    double altura;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public Persona(String nombre, int edad, String dni, int peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }



    public Persona() {
    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public int calcularIMC(){
        double imc = peso/(Math.pow(altura,2));
        if(imc<20){
            return -1;
        }
        else if(imc >= 20 && imc <=25){
            return 0;
        }
        else{
            return 1;
        }
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }

    public String evaluarIMC(int i){
        if(i==-1){
            return "Bajo peso";
        }
        else if(i==0){
            return "Peso saludable";
        }
        else{
            return "Sobrepeso";
        }
    }
    public String mayorEdad(){
        if(edad<18){
            return "no es mayor de edad";
        }
        else{
            return "es mayor de edad";
        }
    }
}
