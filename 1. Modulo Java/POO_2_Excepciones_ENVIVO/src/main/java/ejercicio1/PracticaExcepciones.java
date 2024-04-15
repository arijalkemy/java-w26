package ejercicio1;

import org.w3c.dom.ls.LSOutput;

public class PracticaExcepciones {
    int a=0;
    int b=300;
    public void calcularCociente() {
        try {
            int cociente = b / a;
            System.out.println("El resultado es: " + cociente);
        /*}catch (ArithmeticException e){*/
        }catch(IllegalArgumentException e){
            System.out.println("Se ha producido el error " + e.getMessage());
        }finally {
            System.out.println("Fin programa");
        }
    }

    public static void main(String[] args) {
        PracticaExcepciones obj = new PracticaExcepciones();
        obj.calcularCociente();
    }
}
