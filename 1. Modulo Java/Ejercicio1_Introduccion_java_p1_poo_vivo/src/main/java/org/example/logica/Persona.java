package org.example.logica;

public class Persona {
    //Atributos
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

    //Constructores
    public Persona() {
    }
    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    //Permite calcular el IMC
    public int calcularIMC(){
        double imc = peso/(altura*altura);
        if(imc<20){
            return -1;
        }else if(imc>=20 && imc<=25){
            return 0;
        }else{
            return 1;
        }

    }
    //Permite saber si una persona es mayor de edad
    public boolean esMayorDeEdad(){
        if(edad>=18){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "Usuario: " +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", peso=" + peso +
                ", altura=" + altura;
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
