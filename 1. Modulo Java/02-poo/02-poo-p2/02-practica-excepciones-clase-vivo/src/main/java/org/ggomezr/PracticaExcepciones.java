package org.ggomezr;

public class PracticaExcepciones {
    public static void main(String[] args) {
//      Inicializa las variables para la operacion del programa
        int a = 0;
        int b = 300;

        try{

//          Si alguna de los divisores es 0 lanza una excepcion
            if(a == 0 || b == 0) throw new IllegalArgumentException("No se puede dividir por cero");

//          Realiza la division
            double cociente = b/a;

//          Imprime el resultado de la division;
            System.out.println("El cociente de la division es " + cociente);
        }catch (ArithmeticException e){

//          Captura la excepcion e imprime el mensaje
            System.out.println(e.getMessage());
        }finally {

//          Finaliza el programa
            System.out.println("Programa finalizado");
        }
    }
}
