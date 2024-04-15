package IntroJavaP2.Ejercicios;

public class Main {
    public static void main(String[] args) {
        //1)
        double sueldoBase = 21000; //monto de ejemplo
        String dni = "12345678"; //dni de ejemplo
        double sueldoConAumento;

        if (sueldoBase <= 20000) {
            sueldoConAumento = sueldoBase * 1.2;
        }
        else {
            if (sueldoBase <= 45000){
                sueldoConAumento = sueldoBase * 1.1;
            }
            else {
                sueldoConAumento = sueldoBase * 1.05;
            }
        }

        System.out.println ("El nuevo sueldo del empleado es de: " + sueldoConAumento);

        //2)
        int[] serviciosCli = {1,1,2,2,2,1,2}; //vector de 7 posiciones con tipos de servicios
        double[] precioServicios = { 1500, 2200 };
        double totalFactura;

        for (int servicio : serviciosCli) {
            System.out.println ("El tipo de servicio es: " + servicio);
            System.out.println ("El monto de la factura es de: " + precioServicios[servicio - 1]);
        }

    }
}
