package org.bootcamp.domain;

public class Persona {

    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

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

    /**
     * Metodo que realiza el calculo del IMC de una persona
     * @return el imc al que pertenece la persona
     */
    public int calcularIMC() {
        if (altura == 0)
            throw new ArithmeticException("El valor de altura no puede ser 0, valide e intente de nuevo.");

        double imc = this.peso / Math.pow(this.altura, 2);
        if (imc < 20) {
            return -1;
        }
        if (imc <= 25) {
            return 0;
        }
        return 1;
    }

    /**
     * Metodo que valida si la persona es mayor de edad
     * @return valor booleano
     */
    public boolean esMayorDeEdad() {
        return this.edad >= 18;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("\n--- Persona ---\n");
        sb.append("\nnombre: ").append(nombre);
        sb.append("\nedad: ").append(edad);
        sb.append("\ndni: ").append(dni);
        sb.append("\npeso: ").append(peso);
        sb.append("\naltura: ").append(altura);
        return sb.toString();
    }
}
