package org.example.services;

import org.example.Cliente;
import org.example.Localizador;
import org.example.productos.BoletosDeViaje;
import org.example.productos.Comida;
import org.example.productos.ReservaHotel;
import org.example.productos.Transporte;
import org.example.repositories.ClienteRepository;
import org.example.repositories.LocalizadorRepository;

import java.util.Scanner;

public class ReservaService {

    private Scanner scanner = new Scanner(System.in);
    ClienteRepository clienteRepository = new ClienteRepository();
    LocalizadorRepository localizadorRepository = new LocalizadorRepository();
    Cliente cliente;
    Localizador factura;

    public void crearReservacion() {

        String nombre;
        String dni;

        System.out.println("Ingrese su DNI");
        dni = scanner.nextLine();
        dni = scanner.nextLine();
        System.out.println("Ingrese su nombre");
        nombre = scanner.nextLine();
        cliente = new Cliente(dni, nombre);
        cliente = clienteRepository.agregar(cliente);
        factura = new Localizador(cliente);
        System.out.println("localizadores: " + cliente.getCantLocalizadores());
        boolean continuar = true;
        while(continuar) {
            continuar = ejecutarOpcion(mostrarMenu());
        }
        if (factura.getTotal() != 0) {
            localizadorRepository.agregar(factura);
            clienteRepository.actualizar(cliente);
        } else {
            System.out.println("No realizo ninguna compra");
        }
    }

    public int mostrarMenu() {
        System.out.println("Selección de paquete");
        System.out.println("1. Paquete Completo - 10% de descuento a la compra");
        System.out.println("2. Paquete 2 reservaciones de hotel - 5% al paquete");
        System.out.println("3. Paquete 2 reservaciones de boletos de viaje - 5% al paquete");
        System.out.println("4. Boleto de viaje");
        System.out.println("5. Comida");
        System.out.println("6. Reserva de hotel");
        System.out.println("7. Transporte");
        System.out.println("8. Terminar compra");
        int opcion = scanner.nextInt();
        return opcion;
    }

    public boolean ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                factura.agregarPaqueteCompleto();
                break;
            case 2:
                factura.agregarPaqueteDosHoteles();
                break;
            case 3:
                factura.agregarPaqueteDosBoletos();
                break;
            case 4:
                factura.agregarProducto(new BoletosDeViaje());
            case 5:
                factura.agregarProducto(new Comida());
            case 6:
                factura.agregarProducto(new ReservaHotel());
                break;
            case 7:
                factura.agregarProducto(new Transporte());
                break;
            case 8:
                System.out.println("El total de la compra es: " + factura.getTotal());
                return false;
            default:
                System.out.println("Opción incorrecta");
                break;
        }
        return true;
    }

}
