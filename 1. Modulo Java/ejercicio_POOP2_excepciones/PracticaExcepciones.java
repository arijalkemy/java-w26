public class PracticaExcepciones {
    private int a = 0;
    private int b = 300;

    public void calcularCociente() {
        try {
            if (a == 0){
                throw new IllegalArgumentException("No se puede dividir por cero");
            }
            int cociente = b / a;
            System.out.println("El cociente es: " + cociente);
        } catch (IllegalArgumentException e) {
            System.out.println("Se ha producido un error: " + e.getMessage());
        } finally {
            System.out.println("Programa finalizado");
        }
    }

    public static void main(String[] args) {
        PracticaExcepciones instancia = new PracticaExcepciones();
        instancia.calcularCociente();
    }
}
