package org.example;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        Persona personaVacio = new Persona();
        Persona personaAMedias = new Persona("Camila", 25, "4034567");
        Persona personaCompleta = new Persona("Nicolas", 30, "3500983", 87.5, 160);

        //Persona personaCuatro = new Persona("Juan", 35);

        if (personaCompleta.esMayorDeEdad()) {
            System.out.println("La persona es mayor de 18");
        }

        int imc = personaCompleta.calcularIMC();
        switch(imc) {
            case 0: System.out.println("El peso de la persona es saludable");
                break;
            case 1: System.out.println("La persona tiene bajo peso");
                break;
            case -1: System.out.println("La persona tiene sobrepeso");
                break;
            default: System.out.println("No hay datos ingresados o son igual a 0");
                break;
        }

        System.out.println("Los datos de la persona son: " + personaCompleta.toString());
    }
}
