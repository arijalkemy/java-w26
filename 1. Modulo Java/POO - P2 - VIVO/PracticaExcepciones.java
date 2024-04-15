public class PracticaExcepciones {
    public static void main(String[] args) {
        int a =0;
        int b=300;

        try {
            System.out.println(b/a);
        } catch (Exception e) {
//            System.out.println("se ha producido un error");
            throw new IllegalArgumentException("No se puede dividir por cero");
        }finally{
            System.out.println("Programa finalizado");
        }
    }
}
