package org.example;

public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

    public int cacularIMC(){
        double resultado = this.peso/(Math.pow(altura,2));
        if (resultado <20){
            return -1;
        }else{
            if(resultado <25){
                return 1;
            }
        }
        return 0;
    }
    public boolean esMayorDeEdad(){
        return this.edad >= 18;
    }

    public String toString(){
        return "Nombre: "+this.nombre+" Edad: "+this.edad+" DNI: "+this.dni+" Peso: "+this.peso+" Altura: "+this.altura;

    }
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

    public String getNombre() {
        return nombre;
    }

    public Persona setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public int getEdad() {
        return edad;
    }

    public Persona setEdad(int edad) {
        this.edad = edad;
        return this;
    }

    public String getDni() {
        return dni;
    }

    public Persona setDni(String dni) {
        this.dni = dni;
        return this;
    }

    public double getPeso() {
        return peso;
    }

    public Persona setPeso(double peso) {
        this.peso = peso;
        return this;
    }

    public double getAltura() {
        return altura;
    }

    public Persona setAltura(double altura) {
        this.altura = altura;
        return this;
    }
}
