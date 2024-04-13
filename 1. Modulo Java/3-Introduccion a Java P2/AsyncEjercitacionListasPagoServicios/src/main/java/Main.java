public class Main {
    public static void main(String[] args) {
        int[] servicesClientList = new int[]{1, 1, 2, 2, 2, 1, 2}; //vector de 7 posiciones con tipos de servicios
        double totalToPay;

        for (int i = 0; i <= 6; i++) {
            if (servicesClientList[i] == 1) {
                totalToPay = 1500;
                System.out.println ("El tipo de servicio es: " + servicesClientList[i]);
                System.out.println ("El monto de la factura es de: " + totalToPay);
            }
            else {
                totalToPay = 2200;
                System.out.println ("El tipo de servicio es: " + servicesClientList[i]);
                System.out.println ("El monto de la factura es de: " + totalToPay);
            }
        }

    }
}
