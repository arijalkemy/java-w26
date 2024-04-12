package org.example;

public class OrdenadorDeArray {

    public static int[] burbuja(int[] array) {
        int n = array.length;
        boolean intercambio;

        for (int paso = 0; paso < n - 1; paso++) {
            intercambio = false;
            for (int i = 0; i < n - paso - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    intercambio = true;
                }
            }
            if (!intercambio) {
                break;
            }
        }

        return array;
    }
}
