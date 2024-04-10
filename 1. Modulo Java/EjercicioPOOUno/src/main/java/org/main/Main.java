package org.main;

import org.entities.Persona;

public class Main
{
    public static void main( String[] args )
    {
        Persona personaUno = new Persona();
        Persona personaDos = new Persona("Pepito",21,"123678459");
        Persona personaTres = new Persona("Juanito",25,"234561789",65,1.70);

        int pesoIMC = personaTres.cacularIMC();
        switch (pesoIMC){
            case -1:
                System.out.println("Bajo peso");
                break;
            case 0:
                System.out.println("Peso saludable");
                break;
            case 1:
                System.out.println("Sobrepeso");
                break;
            default:
                System.out.println("Ups! parece que ha ocurrido algo inesperado @-@");
        }

        if(personaTres.esMayorDeEdad()){
            System.out.println("Es mayor de edad");
        }else {
            System.out.println("Es menor de edad");
        }

        System.out.println("Imprimiendo datos de la persona...");
        System.out.println(personaTres.toString());
    }
}
