package ejercicio1;

public class PracticaExcepciones {

    int a = 0;
    int b = 300;

    public double calcularCociente(){
        double resultado = b/a;
        return resultado;
    }

    public static void main(String[] args) {
        PracticaExcepciones practicaExcepciones = new PracticaExcepciones();

        try {
            practicaExcepciones.calcularCociente();
        }catch (ArithmeticException e){
           throw new IllegalArgumentException("No se puede dividir por cero");
        }
        System.out.println("programa finalizado");
    }
}
