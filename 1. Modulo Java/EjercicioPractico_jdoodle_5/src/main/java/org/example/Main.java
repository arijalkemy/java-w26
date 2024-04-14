package org.example;

public class Main {
    public static void main(String[] args) {
        int[] serviciosCli = {1, 1, 2, 2, 2, 1, 2}; //vector de 7 posiciones con tipos de servicios
        double totalFactura;


        for (int i = 0; i < serviciosCli.length; i++) {
            totalFactura = 1500;
            if (serviciosCli[i] == 1) {
                System.out.println("El tipo de servicio es: " + serviciosCli[i]);
                System.out.println("El monto de la factura es de: " + totalFactura);
            } else {
                totalFactura += 700;
                System.out.println("El tipo de servicio es: " + serviciosCli[i]);
                System.out.println("El monto de la factura es de: " + totalFactura);
            }
        }
    }
}