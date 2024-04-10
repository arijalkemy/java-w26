import ejericicio1.PracticaExcepciones;

public class Main {
    public static void main(String[] args) {
        PracticaExcepciones practicaExcepciones = new PracticaExcepciones();

        // EJERCICIO 1

        // ITEM 1
        practicaExcepciones.calcularCociente();

        // ITEM 2

        try{
            practicaExcepciones.calcularCocienteVariante2();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
