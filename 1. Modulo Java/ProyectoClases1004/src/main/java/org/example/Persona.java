package org.example;

public class Persona {
    String nombre;
    int edad;
    String dni;
    double peso; //debe ser expresado en kg
    double altura; //debe ser expresado en mts

    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public Persona() {

    }

    public int calcularIMC() {
        try{
            if(this.peso==0 || this.altura==0){
                throw new RuntimeException("No se puede calcular IMC esta persona no tiene declaradas la altura o el peso");
            }
            double imc = this.peso / (Math.pow(this.altura, 2));
            if (imc < 20) {
                return -1;
            }
            return (imc > 25) ? 0 : 1;
        }catch(RuntimeException e){
            e.printStackTrace();
            throw new Error(e);
        }
    }

    public boolean esMayorEdad() {
        if (this.edad < 18) {
            return false;
        }
        return true;
    }


    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public void mostrarPesoyEdad() {
        switch (this.calcularIMC()) {
            case -1:
                System.out.println("La persona " + this.nombre + " tiene un nivel de peso bajo");
                break;
            case 0:
                System.out.println("La persona " + this.nombre + " tiene un peso acorde.");
                break;
            case 1:
                System.out.println("La persona " + this.nombre + " tiene sobre peso.");
                break;
        }
        if (this.esMayorEdad() == true) {
            System.out.println("ademas, " + this.nombre + " es mayor de edad.");
        } else {
            System.out.println("ademas, " + this.nombre + " es menor de edad.");
        }
    }
}
