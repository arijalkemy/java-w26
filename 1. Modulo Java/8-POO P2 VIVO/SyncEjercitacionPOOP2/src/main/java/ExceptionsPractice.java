public class ExceptionsPractice {
    int a = 0;
    int b = 300;

    public void calculate() {
        try {
            if (a == 0) {
                throw new IllegalArgumentException("No se puede dividir por cero");
            }
            int result = b / a;
            System.out.println("Se ha producido un error");
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

}
