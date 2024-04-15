public class Main {
    public static void main(String[] args) {

        //Ejercicio1
        PracticaExcepciones practicaExcepciones = new PracticaExcepciones();
        try{

            practicaExcepciones.calcularCociente();

        }catch (Exception ex){
            System.out.println("Se ha producido un error");
        }finally {
            System.out.println("Programa finalizado.");
        }

        //Ejercicio2

        practicaExcepciones.calcularCociente();

    }
}