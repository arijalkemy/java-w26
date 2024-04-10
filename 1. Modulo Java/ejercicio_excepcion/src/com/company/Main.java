package com.company;

public class Main {

    public static void main(String[] args) {
        String mensajeFinal = "Este es el último mensaje";

        try {
            int[] numeros = new int[5];
            numeros[5] = 10;
        }
	    catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
	    finally {
            System.out.println(mensajeFinal);
        }
    }
}
