package org.bootcamp;

public class PracticaExcepciones {

    private int a;
    private int b;

    public PracticaExcepciones() {
        this.a = 0;
        this.b = 300;
    }

    public void calcularCociente(){
        try{
            System.out.println("Cociente de " + b + " / " + " a : " + b/a);
        }catch (Exception e){
            throw new IllegalArgumentException("\nNo se puede dividir por cero");
        }finally {
            System.out.println("\nPrograma finalizado.");
        }
    }
}
