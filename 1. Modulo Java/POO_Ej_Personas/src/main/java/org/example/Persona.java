package org.example;

import java.util.Map;

//Ejercicio 1
public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private float peso;
    private float altura;

    private final Map<Boolean,String> CONDICION_EDAD = Map.of(
            true,"Es mayor de edad",
            false,"Es menor de edad"
    );

    private final Map<Integer,String> CONDICION_FISICA = Map.of(
            -1,"Bajo peso",
            0,"Peso saludable",
            1,"Sobrepeso"
    );

    //Ejercicio 2
    public Persona(){}

    public Persona(String nombre, int edad, String dni){
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

    //Ejercicio 5
    public int calcularIMC(){
        try{
            double imc = this.peso / (Math.pow(this.altura,2));
            if(imc < 20) return -1;
            return (imc > 25) ?  1 : 0;
        }
        catch (ArithmeticException e){
            e.printStackTrace();
            throw new ArithmeticException();
        }
    }

    public boolean esMayorDeEdad(){
        return (this.edad >= 18);
    }

    public String getMensajeEdad(){
        return CONDICION_EDAD.get(this.esMayorDeEdad());
    }

    public String getMensajePeso(){
        return CONDICION_FISICA.get(this.calcularIMC());
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
}
