package org.example;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        //Mensaje final
        String mensajeFinal = "Este es el último mensaje";
        try{
            int[] numeros = new int[5];
            numeros[5] = 10;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        //Código que arroja excepción
        finally{
            System.out.println(mensajeFinal);
        }
    }
}
