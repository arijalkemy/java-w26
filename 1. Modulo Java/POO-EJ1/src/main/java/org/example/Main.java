package org.example;

public class Main
{
    public static void main( String[] args )
    {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("persona2", 25, "1234567");
        Persona persona3 = new Persona("persona3", 25, "123456789", 90, 1.50);

        int imcPersona3 = persona3.calcularIMC();
        boolean esMayorDeEdadPersona3 = persona3.esMayordeEdad();

        System.out.println("Datos de la persona: " + persona3);

        if(imcPersona3 == -1) {
            System.out.println("Bajo peso");
        } else if(imcPersona3 == 0){
            System.out.println("Peso saludable");
        }else {
            System.out.println("Sobrepeso");
        }
    }
}
