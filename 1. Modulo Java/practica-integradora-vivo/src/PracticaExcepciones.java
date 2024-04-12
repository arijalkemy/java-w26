public class PracticaExcepciones {
    static int a = 0;
    static int b = 300;

    public static void main(String[] args) {
        int calcular;
        try{
            calcular = b / a;
        }catch (ArithmeticException e){
            throw new IllegalArgumentException("No se puede vivir por 0");
        }
        finally {
            System.out.println("Programa finalizado");
        }
    }

}
