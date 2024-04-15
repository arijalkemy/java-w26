package org.example;

public class PracticaExcepciones {
    public static void main( String[] args )
    {
        int a = 0;
        int b = 300;
        try{
            if(a==0) {
                throw new IllegalArgumentException();
            }
        }catch (IllegalArgumentException iae){
        System.out.print("No se puede dividir por 0");
        }finally {
        System.out.print("\nPrograma Finalizado");
        }
    }


}
