package org.example;

// Ejercicio 1
public class Persona {
    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;

    // Constructor sin parametros ejercicio 2
    public Persona() {
    }

    // ejercicio 2
    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    // Constructor con todos los parametros ejercicio 2
    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    // Ejercicio 5
    public int calcularIMC()
    {
        try{
            double resultado = peso/(Math.pow(this.altura,2));
            if(resultado<20)
            {
                return -1;
            }
            else if(resultado>=20&& resultado<=25)
            {
                return 0;
            }
            else
            {
                return 1;
            }
        }
        catch (ArithmeticException e)
        {
            throw new Error(e.getMessage());
        }
    }
    // Ejercicio 5

    public boolean esMayorDeEdad()
    {
        if(this.edad>=18)
        {
            return true;
        }
        return false;
    }
    // Ejercicio 5

    public String toString()
    {
        return "Nombre: " + this.nombre + " Edad: " + this.edad + " Dni: " + this.dni + " Peso: " + this.peso + " Altura: " + this.altura;
    }



}
