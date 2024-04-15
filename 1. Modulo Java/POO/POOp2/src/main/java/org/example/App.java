package org.example;

public class App 
{
    public static void main( String[] args )
    {
        String mensajeFinal = "Este es el último mensaje";

        //Código que arroja excepción
        int[] numeros = new int[5];
        try{
            numeros[4] = 10;
        }
        catch (ArrayIndexOutOfBoundsException err) {
            System.out.println(err.getMessage());
        }
        finally {
            System.out.println(mensajeFinal);
        }

    }
}
