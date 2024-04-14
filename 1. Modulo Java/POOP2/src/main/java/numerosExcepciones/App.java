package numerosExcepciones;

public class App {
    public static void main(String[] args) {
        int a = 0;
        int b = 300;

        try {
            double division = b / a;
        } catch (Exception e) {
            System.out.println("Se ha producido un error" + e.getMessage());
        } finally {
            System.out.println("Se ha finalizado la ejecución");
        }

        //segunda manejo execcion
        try{
            int res = b/a;
        }
        catch (ArithmeticException e){
            throw new IllegalArgumentException("No se permite el 0 como divisor");
        }
        finally {
            System.out.println("Programa finalizado 2da excepcion");
        }
    }
}
