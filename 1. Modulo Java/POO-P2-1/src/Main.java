public class Main {
    public static void main(String[] args) {
        PracticaExcepciones practica = new PracticaExcepciones();

        //PUNTO 1
        try {
            System.out.println("Calculo de cociente de la division 300/0: " + practica.calcularCociente());
        } catch (ArithmeticException e){
            System.out.println("Se ha producido un error" + e.getMessage());
        } finally {
            System.out.println("Programa finalizado");
        }

        //PUNTO 2
        try {
            System.out.println("Calculo de cociente de la division 300/0: " + practica.calcularCociente());
        } catch (ArithmeticException e){
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }

    }
}