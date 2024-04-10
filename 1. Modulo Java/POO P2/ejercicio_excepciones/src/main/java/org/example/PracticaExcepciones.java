package org.example;

public class PracticaExcepciones {
    private static int a = 0;
    private static int b = 300;


    public int cociente(){
        try {
            return b / a;
        } catch (Exception e) {
            throw new RuntimeException("Se ha producido un error”");
        } finally {
            System.out.println("Programa finalizado");
        }
    }

    public int cocienteModificado(){
        try {
            return b / a;
        } catch (Exception e) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }
    }


}
