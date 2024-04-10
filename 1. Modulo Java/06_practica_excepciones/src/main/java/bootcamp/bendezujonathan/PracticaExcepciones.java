package bootcamp.bendezujonathan;

public class PracticaExcepciones {

    public static void dividirSout(int a, int b) {
       
        try {
            double result = a / b;
        } catch (ArithmeticException e) {
            System.out.println("[ERROR]: Se a producido un error al intentar dividir por cero.");
        } finally {

        }
    }

    public static void dividirEx(int a, int b) {
        try {
           double result = a / b;
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}

