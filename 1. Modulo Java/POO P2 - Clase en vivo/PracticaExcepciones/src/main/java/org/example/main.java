package org.example;

public class main {

    public static void main(String[] args)  {
        PracticaExcepciones practicaExcepciones = new PracticaExcepciones();

        try{
            System.out.println(practicaExcepciones.dividir(0,300))  ;
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Programa finalizado");
        }


        System.out.println("Programa sigue en ejecución");


    }
}
