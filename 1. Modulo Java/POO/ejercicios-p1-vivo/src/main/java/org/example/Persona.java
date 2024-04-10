package org.example;

public class Persona {
    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;


    public Persona(){
    }
    public Persona(String nombre, int edad, String dni){
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

    public int calcularIMC(){
        try {
            if(altura == 0) throw new Exception("No es posible dividir por 0");

            double imc = (peso / Math.pow(altura, 2));
            if (imc < 20)
                return -1;
            else {
                if (imc > 25)
                    return 1;
                else
                    return 0;
            }
        } catch (Exception e) {
            return -2;
        }
    }

    public boolean esMayorDeEdad(){
        return edad >= 18;
    }

    @Override
    public String toString() {
        return "La persona con los datos: \n" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", peso=" + peso +
                ", altura=" + altura
                ;
    }
}
