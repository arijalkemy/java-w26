package org.example;

public class AlgoritmoOrdenamiento {

    public static int[] burbuja(int[] arreglo) {
        int n = arreglo.length;
        boolean intercambiado;

        do {
            intercambiado = false;
            for (int i = 1; i < n; i++) {
                if (arreglo[i - 1] > arreglo[i]) {
                    // Intercambio de elementos
                    int temp = arreglo[i - 1];
                    arreglo[i - 1] = arreglo[i];
                    arreglo[i] = temp;
                    intercambiado = true;
                }
            }
            n--;
        } while (intercambiado);

        return arreglo;
    }

    // Método main para probar la implementación
    public static void main(String[] args) {
        int[] miArreglo = {1, 79, 38, 11, 26};

        System.out.println("Arreglo original:");
        for (int num : miArreglo) {
            System.out.print(num + " ");
        }

        int[] arregloOrdenado = burbuja(miArreglo);

        System.out.println("\nArreglo ordenado:");
        for (int num : arregloOrdenado) {
            System.out.print(num + " ");
        }
    }
}
