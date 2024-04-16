public class PracticaExcepciones {
     private static int a = 0;
     private static int b = 300;

    public static void main(String[] args) {
        try {
            if (a == 0) {
                throw new IllegalArgumentException("No se puede dividir por cero.");
            }
            double result = a/b;
            System.out.println("Resultado: " + result);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
