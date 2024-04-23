package org.example;

import org.example.productos.ReservaHotel;
import org.example.repositories.ClienteRepository;
import org.example.repositories.LocalizadorRepository;
import org.example.services.ConsultasService;
import org.example.services.ReservaService;

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ConsultasService consultaService = new ConsultasService();
        ReservaService reservaService = new ReservaService();
        inicializarDatos();
        int opcion;
        do {
            System.out.println("Menú");
            System.out.println("1. Hacer Reserva");
            System.out.println("2. Consultar datos");
            System.out.println("3. Salir");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    reservaService.crearReservacion();
                    break;
                case 2:
                    consultaService.hacerConsultas();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }
        } while (opcion != 3);
    }

    /*
    Creación de datos por defecto
    */
    public static void inicializarDatos() {
        System.out.println("Probar datos con el usuario con dni: 123456 y nombre: Cristian");
        //Creación cliente
        Cliente cliente = new Cliente("123456", "Cristian");
        ClienteRepository clienteRepository = new ClienteRepository();
        LocalizadorRepository localizadorRepository = new LocalizadorRepository();
        cliente = clienteRepository.agregar(cliente);
        Localizador localizador = new Localizador(cliente);
        localizador.agregarPaqueteCompleto();
        localizadorRepository.agregar(localizador);
        clienteRepository.actualizar(cliente);
        System.out.println("Total: " + localizador.getTotal());
        System.out.println(clienteRepository.agregar(cliente).getCantLocalizadores());

        cliente = new Cliente("123456", "Cristian");
        cliente = clienteRepository.agregar(cliente);
        localizador = new Localizador(cliente);
        localizador.agregarPaqueteDosBoletos();
        localizador.agregarPaqueteDosHoteles();
        localizadorRepository.agregar(localizador);
        clienteRepository.actualizar(cliente);
        System.out.println("Total: " + localizador.getTotal());
        System.out.println(cliente.getCantLocalizadores());

        cliente = new Cliente("123456", "Cristian");
        cliente = clienteRepository.agregar(cliente);
        localizador = new Localizador(cliente);
        localizador.agregarProducto(new ReservaHotel());
        localizadorRepository.agregar(localizador);
        clienteRepository.actualizar(cliente);
        System.out.println("Total: " + localizador.getTotal());
        System.out.println(cliente.getCantLocalizadores());
        System.out.println("Fin de la prueba, inicio del programa");
    }
}