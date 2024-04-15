package burbuja;
public class Ejercicio1 {

    public static int[] burbuja(int[] array) {
        int n = array.length;
        boolean intercambio;
        // Realiza hasta n-1 pasadas sobre el arreglo
        for (int paso = 0; paso < n - 1; paso++) {
            intercambio = false;
            // Compara elementos adyacentes y los intercambia si están en el orden incorrecto
            for (int i = 0; i < n - paso - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    intercambio = true;
                }
            }
            // Si no se hizo ningún intercambio, el arreglo ya está ordenado
            if (!intercambio) {
                break;
            }
        }

        return array;
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 9, 1, 5, 6};
        burbuja(array);
        imprimirArreglo(array);
    }
    // Imprime todos los elementos del arreglo en una sola línea
    public static void imprimirArreglo(int[] array) {
        for (int elemento : array) {
            System.out.print(elemento + " ");
        }
    }
}
