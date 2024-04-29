package org.example;

/**
 * Ejercicio practico estructuras de control
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        int serviciosCli [] = {1,1,2,2,2,1,2}; //vector de 7 posiciones con tipos de servicios
        double totalFactura = 1500;
        //Cantidad de clientes
        System.out.println("_____________________________________");
        for (int j = 0; j < serviciosCli.length; j++) {
            //Para servicio tipo 1
            System.out.println ("Para el cliente numero: "+(j+1));
            if (serviciosCli[j] == 1) {
                System.out.println ("El tipo de servicio es: " + serviciosCli[j]);
                System.out.println ("El monto de la factura es de: " + totalFactura);
            }//Para servicio tipo2
            else {
                System.out.println ("El tipo de servicio es: " + serviciosCli[j]);
                System.out.println ("El monto de la factura es de: " + (totalFactura+400));
            }
            System.out.println("_____________________________________");
        }
    }
}
