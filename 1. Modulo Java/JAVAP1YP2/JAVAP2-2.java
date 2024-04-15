public class Main {
    
  public static void main (String[] args){

    int[] serviciosCli = {1,1,2,2,2,1,2}; //vector de 7 posiciones con tipos de servicios

    for (int i=0; i<7; i++) {
        if (serviciosCli[i]==1) {
            
            System.out.println ("Para el cliente con id: "+(i+1)+" El tipo de servicio contratado es: Seguridad con camaras");
            System.out.println ("El monto de la factura es de: " + 1500);
        }
        else {
            System.out.println ("Para el cliente con id: "+(i+1)+" El tipo de servicio contratado es: Seguridad con camaras + Patrullaje");
            System.out.println ("El monto de la factura es de: " + 2200);
        }
    }

  }
}
