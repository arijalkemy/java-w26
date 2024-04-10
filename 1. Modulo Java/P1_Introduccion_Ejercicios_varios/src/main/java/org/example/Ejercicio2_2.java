package org.example;

/**
 * Una empresa de servicios de seguridad tiene 7 clientes que todos los meses abonan la cuota
 * de dos posibles tipos de servicio:
 * <p>
 * Servicio 1: Seguridad con cámaras - Precio Fijo de $1500 al mes
 * <p>
 * Servicio 2: Seguridad con cámaras + patrullaje - Precio de $1500 + $700 por el servicio de patrullaje
 * <p>
 * Dependiendo del tipo de servicio, se desea poder calcular el monto final de la factura para cada uno de los clientes.
 * Tener en cuenta, que existe un vector en donde se almacena el tipo de servicio que cada cliente adquirió.
 */
public class Ejercicio2_2 {

    public static void main(String[] args) {

        int[] serviciosCli = {1, 1, 2, 2, 2, 1, 2}; //vector de 7 posiciones con tipos de servicios
        double totalFactura = 0;

        for (int servicio : serviciosCli) {
            if (servicio == 1) {
                totalFactura = 1500;

                System.out.println("El tipo de servicio es: " + servicio);
                System.out.println("El monto de la factura es de: " + totalFactura);
            }
            else {
                totalFactura = 1500 + 700;

                System.out.println("El tipo de servicio es: " + servicio);
                System.out.println("El monto de la factura es de: " + totalFactura);
            }
        }

    }

}
