package org.example;
/*
 * Clase Persona creada como parte del ejercicio número 1
 * */

public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

    /*
     * Constructor sin parametros creado como parte del ejercicio 2
     * */
    public Persona(){

    }

    /*
     * Constructor que cuenta solo con tres parametros nombre, edad y dni, creado como parte del ejercicio 2
     * */
    public Persona(String nombre, int edad, String dni){
        this.nombre=nombre;
        this.edad=edad;
        this.dni=dni;
    }
    /*
     * Constructor que cuenta con todos los atributos de la clase, creado como parte del ejercicio 2
     * */
    public Persona(String nombre,int edad,String dni, double peso, double altura){
        this.nombre=nombre;
        this.edad=edad;
        this.dni=dni;
        this.peso=peso;
        this.altura=altura;
    }

    public int calcularIMC(){
        try {
            if (this.altura <= 0 || this.peso <= 0) {
                throw new Error("La altura o el peso de la persona es menor o igual que 0, no es posible calcular el IMC");
            }
            double imc = this.peso / (Math.pow(this.altura, 2));
            return (imc < 20) ? -1 : (imc > 25) ? 1 : 0;
        } catch (Exception e) {
            return -2;
        }
    }

    public boolean esMayorDeEdad(){
        return (this.edad>=18);
    }
    @Override
    public String toString(){
        return "Nombre: "+this.nombre+" , Edad: "+this.edad+", Dni: "+this.dni+", Peso: "+this.peso+", Altura: "+this.altura;
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

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
}
