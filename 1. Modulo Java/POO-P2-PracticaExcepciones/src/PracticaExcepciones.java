public class PracticaExcepciones {
    private int a = 300;
    private int b = 0;

    public double calcularCociente(){
        if(b == 0) throw  new IllegalArgumentException("No se puede dividir por cero");
        return a/b;
    }
}
