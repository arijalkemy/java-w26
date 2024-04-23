//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Se inicializan las variables del programa
        int a = 0;
        int b = 300;
        int c = 1;

        //Se realiza la division de los valores controlando la excepcion de division por 0
        try {
            if (a == 0) {
                throw new IllegalArgumentException("No se puede dividir por cero");
            }
            c = b / a;
            System.out.println("Resultado: "+c);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Programa finalizado");
        }

        //Se realiza la division de los valores controlando la excepcion de division por 0
        try {
            c = b / a;
            System.out.println("Resultado: "+c);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        }
    }
}