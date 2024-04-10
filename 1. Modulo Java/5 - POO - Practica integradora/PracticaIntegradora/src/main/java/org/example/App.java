package org.example;

public class App 
{
    public static void main( String[] args )
    {
        //Inicializo las diferentes tipos de personas
        Persona personaSinDatos = new Persona();
        Persona personaCasiCompleta = new Persona("Carlos", 24, "42145654");
        Persona personaCompleta = new Persona("Jose", 21, "46782123",  70, 1.72);

        //Calcular el IMC
        switch (personaCompleta.calcularMC()){
            case -1:
                System.out.println("El imc calculado es de -1, lo que significa un Bajo Peso");
                break;
            case 0:
                System.out.println("El imc calculado es de 0, lo que significa un Peso saludable");
                break;
            case 1:
                System.out.println("El imc calculado es de 1, lo que significa un Sobrepeso");
                break;
        }

        System.out.println("La persona es mayor de edad: " + personaCompleta.esMayorEdad());
        System.out.println("Los datos de la persona son:" + personaCompleta.toString());
    }
}
