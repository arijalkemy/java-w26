package org.example;

public class Persona {
    private String nombre;
    private Integer edad;
    private String dni;
    private Double pesoKg;
    private Double alturaMts;

    //Constructor vacio
    public Persona() {
    }

    //Constructor de parámetros básicos.
    public Persona(String nombre, Integer edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    //Constructor con todos los parametros

    public Persona(String nombre, Integer edad, String dni, Double pesoKg, Double alturaMts) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.pesoKg = pesoKg;
        this.alturaMts = alturaMts;
    }

    public int calcularIMC(){
        double IMC;
        if (this.alturaMts>0){ //Evitando MathError;
         IMC = this.pesoKg/(Math.pow(this.alturaMts,2));

        }
        else {return -2;}
        if (IMC<20){ return -1;}
        if (IMC>20&&IMC<25){return 0;}
        return 1;
    }

    public boolean esMayorDeEdad(){
        if(this.edad.equals(null)){
            System.out.println("Sin edad registrada");
            return false;
        }
        else if(this.edad<18){
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", pesoKg=" + pesoKg +
                ", alturaMts=" + alturaMts +
                '}';
    }
}
