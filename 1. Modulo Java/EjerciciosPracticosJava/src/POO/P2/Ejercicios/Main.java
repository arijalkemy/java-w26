package POO.P2.Ejercicios;

public class Main {
    public static void main(String[] args) {
        //Mensaje final
        String mensajeFinal = "Este es el último mensaje";

        try{
            //Código que arroja excepción
            int[] numeros = new int[5];
            numeros[5] = 10;
        }catch (Exception e){
            System.out.println("Mensaje del la excepcion: " + e.getMessage());
        }

        System.out.println(mensajeFinal);
    }
}
