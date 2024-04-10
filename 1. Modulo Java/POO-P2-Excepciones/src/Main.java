public class Main {
    public static void main(String[] args) {
        PracticaExcepciones practica1 = new PracticaExcepciones();
        try{
            double cociente = practica1.b / practica1.a;
        } catch(ArithmeticException e){
            throw new IllegalArgumentException("No se puede dividir por cero.");
        }
        finally {
            System.out.println("Programa finalizado.");
        }
    }
}