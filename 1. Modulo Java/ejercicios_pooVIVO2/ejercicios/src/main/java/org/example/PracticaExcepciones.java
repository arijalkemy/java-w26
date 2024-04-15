package org.example;

public class PracticaExcepciones {
    private int a=0,b=300;
    /*
    * Manejo de la excepción con el tipo ArithmeticException
    * */
    public int cociente(){
        try{
            return b/a;
        }catch (ArithmeticException e){
            throw new ArithmeticException("Se ha produccido un error");
        }
        finally {
            System.out.println("Programa finalizado");
        }
    }
    /*
    * Manejo de la excepción con el tipo de excepción IllegalArgumentException
    * */
    public int cociente2(){
        try{
            return b/a;
        }catch (Exception e){
            throw new IllegalArgumentException("No es posible dividir por cero");
        }
        finally {
            System.out.println("Programa finalizado");
        }
    }
}
