package org.example;

public class PracticaExcepciones {
    public static void main(String[] args) {
        int a = 0;
        int b = 300;

        try{
            int cociente = b / a;
        }
        //Version 1:
        // catch (Exception e){
        //     System.out.println("Se ha producido un error");
        // }
        //Version 2:
        catch(ArithmeticException e){
            throw new IllegalArgumentException("No se puede divir por cero");
        }
        finally{
            System.out.println("Programa finalizado");
        }
    }
}
