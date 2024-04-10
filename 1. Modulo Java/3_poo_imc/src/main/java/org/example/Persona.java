package org.example;

// Item 1) --------
public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private float peso;
    private float altura;

    // Item 2) --------
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

    // Item 5) --------
    public int calcularIMC(){
        float imc = (float) (this.peso/(Math.pow(this.altura, 2)));
        if(imc < 20){
            return -1;
        }
        return (imc >= 20 && imc <= 25) ? 0 : 1;
    }

    public boolean esMayorDeEdad(){
        return this.edad >= 18;
    }

    public String getNombre() {
        return this.nombre;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", peso=" + peso + " Kg." +
                ", altura=" + altura + " m."+
                '}';
    }
}
