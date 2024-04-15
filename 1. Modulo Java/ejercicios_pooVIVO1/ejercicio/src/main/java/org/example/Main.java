package org.example;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        /*
         * Se crean los objetos de tipo persona correspondientes
         * personaSinAtributos: objeto del tipo persona que usará el constructor sin atributos
         * personaConAlgunosAtributos: objeto del tipo persona que usará el constructor con los atributos de nombre, edad y dni
         * personaCompleta: objeto del tipo persona que usará el constructor con todos los atributos de la clase
         * personaIncompleta: objeto del tipo persona que solo pasará los atributos de nombre y edad
         * Objetos creados como parte del ejercicio 4
         * */
        Persona personaNull = new Persona();
        Persona personaALaMitad = new Persona("Esteban Quito", 22, "12345678");
        Persona personaCompleta = new Persona("Armando Casas", 100, "87654321", 60, 1.50);
        /*
         * Constructor de persona incompleta, al no existir un constructor del tipo persona que solo tome estos dos, ejercicio 4
         * */
        /*
         *    personaIncompleta = new Persona("Daniel",26);
         **/
        /*
         * Calculamos el imc del objeto persona que creamos completa, como parte del ejercicio 5, dependiendo del resultado imprimimos por consola el  mensaje
         * correspondiente
         * */
        switch (personaCompleta.calcularIMC()){
            case -1:
                System.out.println("La persona "+personaCompleta.getNombre()+" se encuentra en bajo peso");
                break;
            case 0:
                System.out.println("La persona "+personaCompleta.getNombre()+" se encuentra en peso saludable");
                break;
            case 1:
                System.out.println("La persona "+personaCompleta.getNombre()+" se encuentra en sobre peso");
                break;
            default:
                System.out.println("No fue posible calcular ");
                break;
        }
        /*
         * Imprimimos por pantalla si la persona es mayor o menor de edad
         * */
        System.out.println("La persona "+personaCompleta.getNombre()+", es "+(personaCompleta.esMayorDeEdad()?" mayor":" menor")+"de edad.");

        /*
         * Imprimimos por pantalla los datos de la persona
         * */
        System.out.println("Los datos de la persona son los siguientes: "+personaCompleta.toString());
    }
}
