import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] arreglo = {4,6,7,8,9,3,56,2,46,7,8};
        int[] arregloOrdenado = Ordenamiento.burbuja(arreglo);

        for( int i = 0 ; i < arregloOrdenado.length; i++){
            System.out.println(arregloOrdenado[i]);
        }
    }
}