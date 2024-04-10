public class PracticaExcepciones {
    private int a = 0;
    private int b = 300;

    public void calcularCociente(){
        try{
            double cociente = b/a;
            System.out.println("El resultado de la división es de: " + cociente);
        } catch (ArithmeticException e){
            throw new IllegalArgumentException("No se puede dividir por 0");
        } finally {
            System.out.println("Fin del programa.");
        }
    }
}
