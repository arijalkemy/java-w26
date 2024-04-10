package meli.bootcamp;

/**
 * Hello world!
 *
 */
public class PracticaExcepciones
{
    public static void main( String[] args )
    {
        int a = 0;
        int b = 300;

        String mensajeFinal = "Programa finalizado";

        try {
           int result = b/a;
        } catch (Exception e) {
            System.out.println("Se ha producido un error");
        } finally {
            System.out.println(mensajeFinal);
        }

        try {
            int result = b/a;
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println(mensajeFinal);
        }
    }
}
