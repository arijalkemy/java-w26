package org.example;

public class Persona {
    String nombre;
    int edad;
    String dni;
    int peso;
    double altura;

    public Persona(){
    }

    public Persona( String nombre, int edad, String dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona( String nombre, int edad, String dni, int peso, double altura){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularMC(){
        //Calculo mc peso/(altura^2) - (peso expresado en kg y altura en mts)
        //TODO: posible division por 0
        double mc = ( peso / ( altura * altura ) );

        if( mc < 20 ){
            return -1;
        }else if( mc >= 20 || mc <= 25){
            return 0;
        }
        return 1;

    }

    public boolean esMayorEdad(){
        return edad >= 18;
    }

    public String toString(){
        return "Nombre: " + nombre + ", edad: " + edad + ", dni: " + dni + ", peso: " + peso + ", altura:" + altura;
    }
}
