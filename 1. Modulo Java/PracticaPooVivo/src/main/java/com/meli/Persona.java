package com.meli;
import java.lang.Math;

/**
 * Clase Persona que representa a una persona con atributos como nombre, edad, DNI, peso y altura.
 */
public class Persona {

    private String Nombre;
    private int Edad;
    private String DNI;
    private int Peso;
    private double Altura;

    /**
     * Constructor de la clase Persona con todos los atributos.
     * @param nombre El nombre de la persona.
     * @param edad La edad de la persona.
     * @param dni El DNI de la persona.
     * @param peso El peso de la persona.
     * @param altura La altura de la persona.
     */
    public Persona(String nombre, int edad, String dni, int peso, double altura) {
        this.Nombre = nombre;
        this.Edad = edad;
        this.DNI = dni;
        this.Peso = peso;
        this.Altura = altura;
    }

    /**
     * Constructor por defecto de la clase Persona.
     */
    public Persona() {}

    /**
     * Constructor de la clase Persona con nombre, edad y DNI.
     * @param nombre El nombre de la persona.
     * @param edad La edad de la persona.
     * @param dni El DNI de la persona.
     */
    public Persona(String nombre, int edad, String dni) {
        this.Nombre = nombre;
        this.Edad = edad;
        this.DNI = dni;
    }

    // Getters y setters para los atributos de la clase Persona...

    /**
     * Método para calcular el Índice de Masa Corporal (IMC) de la persona.
     * @return Un entero que representa el estado del IMC: -1 si está por debajo del peso ideal, 0 si está en el peso ideal, 1 si está por encima del peso ideal.
     */
    public int calcularIMC() {
        double imc = this.Peso / (Math.pow(this.Altura,2));
        if(imc < 20) {
            return -1;
        }
        if(imc >= 20 && imc <= 25) {
            return 0;
        }
        return 1;
    }

    /**
     * Método para determinar si la persona es mayor de edad.
     * @return Un booleano que es verdadero si la persona es mayor de edad y falso en caso contrario.
     */
    public boolean esMayorDeEdad() {
        return this.Edad >= 18;
    }

    /**
     * Método para obtener una representación en cadena de la persona.
     * @return Una cadena que representa a la persona.
     */
    public String toString() {
        return "Nombre: " + this.Nombre + "\nEdad: " + this.Edad + "\nDNI: " + this.DNI + "\nPeso: " + this.Peso + "\nAltura: " + this.Altura;
    }
}