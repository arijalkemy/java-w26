public class PracticaExcepciones {
    private static int a = 0;
    private static int b = 300;

    public static void probarManejoExcepcion1() {
        try {
            System.out.println(b/a);
        } catch (Exception expecion) {
            System.out.println("Se ha producido un error");
        } finally {
            System.out.println("Programa finalizado");
        }
    }

    public static void probarManejoExcepcion2() {
        try {
            if (a == 0) {
                throw new IllegalArgumentException ("No se puede dividir por cero");
            }
            System.out.println(b/a);
        } catch (IllegalArgumentException excepcion) {
            excepcion.printStackTrace();
        }
    }
}


