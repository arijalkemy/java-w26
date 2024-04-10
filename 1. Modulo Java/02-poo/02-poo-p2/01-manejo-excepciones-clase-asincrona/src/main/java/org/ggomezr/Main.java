package org.ggomezr;

public class Main {
    public static void main(String[] args) {
        //Mensaje final
        String mensajeFinal = "Este es el último mensaje";

        try{
            //Código que arroja excepción
            int[] numeros = new int[5];
            numeros[5] = 10;

        }catch (ArrayIndexOutOfBoundsException e){
            // Catch de la excepcion
            System.out.println("Se ha producido una excepcion: " + e.getMessage());
        } finally {
            // Mostrar mensaje final
            System.out.println("Mensaje final: " + mensajeFinal);
        }
    }
}