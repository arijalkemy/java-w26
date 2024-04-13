import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion;

        //Ejecuto el menu hasta que el usuario presione 3 que indica salir
        do {
            System.out.println("\n- MENU DE OPCIONES -");
            System.out.println("1. Ejercicio 1 (Calculo de sueldo de empleados)");
            System.out.println("2. Ejercicio 2 (Calculo de cuotas de clientes del servicio de seguridad");
            System.out.println("3. Salir");
            System.out.print("Ingrese una opcion: ");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    calcularSueldo();
                    break;
                case 2:
                    calcularCoutas();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        }
        while (opcion != 3);
    }

        public static void calcularSueldo() {
            /*EJERCICO 1
            Una empresa de paquetería desea realizar una actualización de los sueldos de sus empleados.
            Para ello, desean la creación de un programa que al asignar un dni y un monto determine si al
            empleado en cuestión le corresponde o no un aumento. Para ello tiene en cuenta las siguientes condiciones:

            a) Si el sueldo es menor o igual a $20.000 le corresponde un 20% de aumento.
            b) Si el sueldo es mayor a $20.000 pero menor o igual a $45.000 le corresponde un 10% de aumento.
            c) Si el sueldo es mayor a $45.000 le corresponde un 5% de aumento.

            Un programador comenzó con el planteo, pero necesita un poco de ayuda para determinar las condiciones p
            ara cada uno de los casos y qué acciones deberían hacerse... ¿Podrías ayudarlo a terminar?
            */

            double sueldoBase = 21000.4; //monto de ejemplo
            String dni = "12345678"; //dni de ejemplo
            double sueldoConAumento;

            if (sueldoBase <= 20000) {
                sueldoConAumento = sueldoBase * 1.2;
            }
            else {
                if (sueldoBase <= 45000) {
                    sueldoConAumento = sueldoBase * 1.1;
                }
                else {
                    sueldoConAumento = sueldoBase * 1.05;
                }
            }
            //Le doy formato de dos decimales al sueldo calculado
            DecimalFormat formato = new DecimalFormat("#.##");
            String sueldoConAumentoTruncado = formato.format(sueldoConAumento);

            //Muestro los resultados
            System.out.println ("\nEJERCICIO 1");
            System.out.println ("El nuevo sueldo del empleado es de: " + sueldoConAumentoTruncado);
        }

        public static void calcularCoutas() {
            /*EJERCICIO 2
            Una empresa de servicios de seguridad tiene 7 clientes que todos los meses abonan la cuota de
            dos posibles tipos de servicio:
                Servicio 1: Seguridad con cámaras - Precio Fijo de $1500 al mes
                Servicio 2: Seguridad con cámaras + patrullaje - Precio de $1500 + $700 por el servicio de patrullaje
            Dependiendo del tipo de servicio, se desea poder calcular el monto final de la factura para cada uno
            de los clientes. Tener en cuenta, que existe un vector en donde se almacena el tipo de servicio
            que cada cliente adquirió
             */

            int[] serviciosCli = {1,1,2,2,2,1,2}; //vector de 7 posiciones con tipos de servicios
            double totalFactura = 1500;

            System.out.println("\nEJERCICIO 2");

            for (int i = 0; i < serviciosCli.length; i++) {
                System.out.println("Para el cliente " + (i+1) + ":");
                if (serviciosCli[i] == 1) {
                    System.out.println ("    El tipo de servicio es: " + serviciosCli[i]);
                    System.out.println ("    El monto de la factura es de: " + totalFactura);
                }
                else {
                    System.out.println ("    El tipo de servicio es: " + serviciosCli[i]);
                    System.out.println ("    El monto de la factura es de: " + (totalFactura + 700));
                }
            }
        }
    }