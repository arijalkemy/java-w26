public class PracticaExcepciones {

    public static int a;
    public static int b;

    public PracticaExcepciones() {
        this.a = 0;
        this.b = 300;
    }

    public void calcularCociente() {

        try {
           int result=  b/a;
        }
        catch (Exception e)
        {
            throw new IllegalArgumentException("No se puede dividir por cero");
        }
        finally {
            System.out.println("Programa finalizado");
        }

    }
}
