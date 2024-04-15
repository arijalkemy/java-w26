import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class Localizador {
    //destinado a guardar los datos de cada reserva por tipo (hotel, boletos, etc)
    private Map<String, List<Double>> totalReserva = new HashMap<>();
    private int paquete = 0;
    private double total= 0;

    public void reservar(){
        System.out.println("Ingrese los productos a contratar.");
        Scanner teclado = new Scanner(System.in);
        System.out.println("Desea reservar hotel/es? (1) Si (2) No");
        int choice = teclado.nextInt();
        if(choice == 1){
            paquete += 1;
            String clave = "Hotel";
            cargarDatosReserva(clave);
        }
        System.out.println("Desea reservar comida/s? (1) Si (2) No");
        choice = teclado.nextInt();
        if(choice == 1){
            paquete += 1;
            String clave = "Comida";
            cargarDatosReserva(clave);
        }
        System.out.println("Desea reservar boleto/s? (1) Si (2) No");
        choice = teclado.nextInt();
        if(choice == 1){
            paquete += 1;
            String clave = "Boleto";
            cargarDatosReserva(clave);
        }
        System.out.println("Desea reservar transporte/s? (1) Si (2) No");
        choice = teclado.nextInt();
        if(choice == 1){
            paquete += 1;
            String clave = "Transporte";
            cargarDatosReserva(clave);
        }
    }

    private void cargarDatosReserva(String clave){
        Scanner teclado = new Scanner(System.in);
        List<Double> datosReserva = new ArrayList<>();
        System.out.println("Ingrese la cantidad de reservas de " + clave + ":");
        double cantidad = teclado.nextDouble();
        datosReserva.add(cantidad);
        System.out.println("Ingrese precio: ");
        double precio = teclado.nextDouble();
        if (cantidad >= 2 && (clave.equals("Boleto") || clave.equals("Hotel"))){
            //si la cantidad de reservas de productos especificados es dos o mas, se aplica automaticamente el descuento del 5%
            precio *= 0.95;
        }
        datosReserva.add(precio);
        total += (cantidad * precio);
        totalReserva.put(clave, datosReserva);
    }

    public double getTotalReserva(){
        return total;
    }

    public boolean paqueteCompleto(){
        if (paquete == 4){
            return true;
        }
        return false;
    }
}
