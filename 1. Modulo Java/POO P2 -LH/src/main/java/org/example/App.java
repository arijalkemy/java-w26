package org.example;



/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {


        //Mensaje final
        String mensajeFinal = "Este es el último mensaje";


        try{
            int[] numeros = new int[5];
            numeros[5] = 10;
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Capturando Excepcion");
            e.printStackTrace();

        }
        finally {
            System.out.println(mensajeFinal);
        }



    }
}
