package org.example;

public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double alto;

    public Persona(String nombre, int edad, String dni, int peso, double alto) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.alto = alto;
    }

    public Persona()
    {

    }

    public Persona(String nombre, int edad, String dni)
    {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

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

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAlto() {
        return alto;
    }

    public void setAlto(double alto) {
        this.alto = alto;
    }

    public int calcularImc(){
        double imc = this.peso/Math.pow(this.alto,2);
        if(imc < 20)
        {
            return -1;
        }
        if(imc >= 20 && imc <= 25)
        {
            return 0;
        }
        return 1;
    }

    public boolean esMayorDeEdad(){
        if(this.edad>=18){
            return true;
        }
        return false;
    }

    public String toString()
    {
        return "Nombre: " + this.nombre + "\nEdad: " + this.edad + "\nDNI: " + this.dni + "\nPeso: " + this.peso + "\nAltura: " + this.alto;
    }
}
