package com.bootcamp;

public class Main {

    public static void main(String[] args) {

        //Mensaje final
        String mensajeFinal = "Este es el último mensaje";

        //Código que arroja excepción
        try{
            int[] numeros = new int[5];
            numeros[5] = 10;
        }catch (IndexOutOfBoundsException exception){
            System.out.println(exception.getMessage());
        }finally {
            System.out.println(mensajeFinal);
        }
    }
}
