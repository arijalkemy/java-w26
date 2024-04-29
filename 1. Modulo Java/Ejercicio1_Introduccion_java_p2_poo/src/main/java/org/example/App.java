package org.example;

/**
 * Hello world!
 * Manejo de excepciones
 */
public class App 
{
    public static void main( String[] args )
    {
        int[] numeros = new int[5];
        try{
            //Código que arroja excepción
            numeros[5] = 10;
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Se intentó acceder a un índice fuera del rango del array.");
        }finally {
            //Mensaje final
            String mensajeFinal = "Este es el último mensaje";
            System.out.println(mensajeFinal);
        }

    }
}
