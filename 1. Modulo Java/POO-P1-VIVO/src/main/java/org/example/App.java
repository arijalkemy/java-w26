package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Maria",44,23456567);
        Persona persona3 = new Persona("Pedro",44,23456780,80,1.80);


        if(persona3.esMayorDeEdad()){
            System.out.println("Es mayor de edad");
        }
        else{
            System.out.println("No es mayor de edad");
        }

        if(persona3.calcularIMC() == -1)
        {
            System.out.println("Tiene nivel bajo de peso.");
        } else if (persona3.calcularIMC() == 0) {
            System.out.println("Tiene nivel peso saludable.");
        }else{
            System.out.println("Tiene sobrepeso.");
        }


        System.out.println("La persona: " + persona3 + " tiene ");



    }
}
