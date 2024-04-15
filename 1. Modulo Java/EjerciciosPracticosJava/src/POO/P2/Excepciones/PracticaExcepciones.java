package POO.P2.Excepciones;

public class PracticaExcepciones {
    private int a = 300;
    private int b = 300;
    //Ejercicio 1
    public void division() {
        try {
            int c = a / b;
            System.out.println("Resultado: " + c);
        } catch (ArithmeticException e) {
            //System.out.println("Se ha producido el siguiente error: " + e.getMessage());
            //B)
            throw new IllegalArgumentException("No se puede dividir por cero");
        }finally{
            System.out.println("Programa finalizado");
        }
    }

}
