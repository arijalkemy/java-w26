package org.ggomezr;

public class Main {
    public static void main(String[] args) {
        int serviciosCli[] = {1,1,2,2,2,1,2}; //vector de 7 posiciones con tipos de servicios
        double[] totalFacturas = new double[serviciosCli.length];

        for (int i = 0; i < serviciosCli.length; i++) {
            if (serviciosCli[i] == 1) {
                totalFacturas[i] = 1500;
                System.out.println ("El tipo de servicio es: " + serviciosCli[i]);
                System.out.println ("El monto de la factura es de: " + totalFacturas[i]);
            }
            else {
                totalFacturas[i] = 1500 + 700;
                System.out.println ("El tipo de servicio es: " + serviciosCli[i]);
                System.out.println ("El monto de la factura es de: " + totalFacturas[i]);
            }
        }
    }
}