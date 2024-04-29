package org.example;

import org.example.logica.Persona;

/**
 * Práctica integradora - Programación orientada a Objetos
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Persona miPersona = new Persona("Cristian", 25, "1013", 78, 1.70);
        //Mostrar datos de la persona
        System.out.println("_____________________________________");
        System.out.println("Datos del usuario");
        System.out.println(miPersona.toString());
        //Definir si la persona es mayor o menor de edad
        definirMayorEdad(miPersona);
        System.out.println("_________Historial Medico__________");
        definirEstadoSalud(miPersona);
    }

    //Permite  establecer si la persona es mayor o menor de edad
    public static void definirMayorEdad(Persona persona) {
        if(persona.esMayorDeEdad()) {
            System.out.println("La persona es mayor de edad y tiene:"+persona.getEdad()+" agnos");
        }else{
            System.out.println("La persona es menor de edad y tiene:"+persona.getEdad()+" agnos");

        }
    }

    public static void definirEstadoSalud(Persona persona) {
        switch (persona.calcularIMC()){
            case -1:
                System.out.println("Nivel de peso: Bajo peso");
                break;
            case 0:
                System.out.println("Nivel de peso: Peso saludable");
                break;
            case 1:
                System.out.println("Nivel de peso: Sobrepeso");
                break;
        }
    }
}
