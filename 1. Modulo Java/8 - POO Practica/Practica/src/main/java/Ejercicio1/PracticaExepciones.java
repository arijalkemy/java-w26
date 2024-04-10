package Ejercicio1;

public class PracticaExepciones {
    int a = 0;
    int b = 300;

    /*Ejercicio 1 - 1
    public void calcular(){
        try{
            int resultado = b / a;
        } catch ( ArithmeticException e){
            System.out.println("Se ha producido un error");
        }finally {
            System.out.println("Programa finalizado");
        }
    }*/

    //Ejercicio 1 - 2
    public double calcular() throws Exception{
        if( a == 0){
            throw new IllegalArgumentException("No se puede dividir por cero");
        }
        return b / a;

    }

}
