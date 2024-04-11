package org.entities.ejeruno;


public class PracticaExcepciones {
    private int a = 0;
    private int b = 300;

    public void calcularCociente(){
        try{
            if(this.a == 0) throw new IllegalArgumentException("No se puede dividir por cero");
            System.out.println(this.b/this.a);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }catch(Exception e){
            System.out.println("Se ha producido un error");
        }finally {
            System.out.println("Programa finalizado");
        }
    }
}
