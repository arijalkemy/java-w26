package Empresa_servicios;

public class Servicio {
    public static void main(String[] args) {
        int serviciosCli [] = {1,1,2,2,2,1,2}; //vector de 7 posiciones con tipos de servicios
        double baseCamaras = 1500;
        double patrullaje = 700;
        double totalFactura;

        for (int i=0;i<serviciosCli.length; i++) {
            if (serviciosCli[i]==1) {
                totalFactura=baseCamaras;
                System.out.println ("El tipo de servicio es: " + serviciosCli[i]);
                System.out.println ("El monto de la factura es de: " + totalFactura);
            }
            else {
                totalFactura=baseCamaras+patrullaje;
                System.out.println ("El tipo de servicio es: " + serviciosCli[i]);
                System.out.println ("El monto de la factura es de: " + totalFactura);
            }
        }
    }
}
