package com.bootcamp.excepcion;

public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private float peso;
    private float altura;

    public Persona() {
        this.nombre = "";
        this.edad = 0;
        this.dni = "";
        this.peso = 0;
        this.altura = 0;
    }

    public Persona(String nombre, int edad, String dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = 0;
        this.altura = 0;
    }

    public Persona(String nombre, int edad, String dni, float peso, float altura){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }
    
    public int calcularIMC(){
        float imc = this.peso / (this.altura * this.altura);
        if (imc < 20) {
            return -1;
        } else if (imc >= 20 && imc <= 25) {
            return 0;
        } else {
            return 1;
        }
    }

    public boolean esMayorDeEdad(){
        if (this.edad >= 18){
            return true;
        }
        return false;
    }

    public String toString(){
        return "Nombre: " + this.nombre + "\nEdad: " + this.edad + "\nDNI: " + this.dni + "\nPeso: " + this.peso + "\nAltura: " + this.altura;
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }
}
