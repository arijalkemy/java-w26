package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        List<Localizador> localizadores = new ArrayList<>();
        Localizador localizador;

        while (!salir) {
            // Mostrar menú

            System.out.println("Agencia de Viajes:");
            System.out.println("---------------------------");
            System.out.println("Menú de opciones:");
            System.out.println("1. Crear localizador");
            System.out.println("2. Mostrar la cantidad de localizadores vendidos");
            System.out.println("3. Salir");
            System.out.println("Seleccione una opción:");

            // Leer opción seleccionada
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea pendiente

            switch (opcion) {
                case 1:
                    // Opción para crear localizador
                    System.out.println("Introduce el ID del cliente:");
                    long id = scanner.nextLong();
                    System.out.println("Introduce el nombre del cliente:");
                    String nombre = scanner.nextLine();

                    Cliente cliente = new Cliente(id, nombre);
                    List<Reserva> reservas = new ArrayList<>();
                    boolean salir2 = false;

                    while (!salir2) {
                        // Mostrar menú
                        System.out.println("Seleccione el tipo de paquete a agregar:");
                        System.out.println("1. Cargar paquete con todas las reservas");
                        System.out.println("2. Elegir tipo de reserva a cargar");
                        System.out.println("3. Salir");
                        System.out.println("Seleccione una opción:");

                        // Leer opción seleccionada
                        int opcionReserva = scanner.nextInt();
                        scanner.nextLine(); // Consumir el salto de línea pendiente

                        switch (opcionReserva) {
                            case 1:
                                int cantidad = 0;
                                do {
                                    System.out.println("Ingrese la cantidad de paquetes completos a agregar");
                                    cantidad = scanner.nextInt();
                                    if (cantidad <= 0) {
                                        System.out.println("Ingrese una cantidad mayor a 0");
                                    }
                                } while (cantidad <= 0);
                                reservas = cargarPaqueteCompleto(cantidad);
                                salir = true;
                                // Crear localizador
                                localizador = new Localizador(cliente, reservas);
                                localizadores.add(localizador);
                                break;
                            case 2:
                                while (!salir) {
                                    System.out.println("Elija el tipo de reserva a cargar");
                                    System.out.println("1. Hotel");
                                    System.out.println("2. Comida");
                                    System.out.println("3. Viajes");
                                    System.out.println("4. Transporte");
                                    System.out.println("5. Salir");
                                    int opcionReservaTipo = scanner.nextInt();
                                    scanner.nextLine(); // Consumir el salto de línea pendiente

                                    switch (opcionReservaTipo) {
                                        case 1:
                                            reservas = cargarPaqueteParcial(tipoReserva.HOTEL);
                                            salir = true;
                                            break;
                                        case 2:
                                            reservas = cargarPaqueteParcial(tipoReserva.COMIDA);
                                            salir = true;
                                            break;
                                        case 3:
                                            reservas = cargarPaqueteParcial(tipoReserva.VIAJES);
                                            salir = true;
                                            break;
                                        case 4:
                                            reservas = cargarPaqueteParcial(tipoReserva.TRANSPORTE);
                                            salir = true;
                                            break;
                                        case 5:
                                            salir = true;
                                            System.out.println("Saliendo...");
                                            break;
                                        default:
                                            // Opción no válida
                                            System.out.println("Opción no válida. Intente de nuevo.");
                                    }
                                }
                                // Crear localizador
                                localizador = new Localizador(cliente, reservas);
                                localizadores.add(localizador);
                                break;
                            case 3:
                                // Opción para salir del programa
                                salir = true;
                                System.out.println("Saliendo...");
                                break;
                            default:
                                // Opción no válida
                                System.out.println("Opción no válida. Intente de nuevo.");
                        }
                    }

                    // Cerrar scanner
                    scanner.close();
                    break;
                case 2:
                    // Opción para salir del programa
                    System.out.println("La cantidad de localizadores vendidos fueron " + localizadores.size());
                    break;
                case 3:
                    // Opción para salir del programa
                    salir = true;
                    System.out.println("Saliendo...");
                    break;
                default:
                    // Opción no válida
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }

        // Cerrar scanner
        scanner.close();
    }

    public static List<Reserva> cargarPaqueteCompleto(Integer cantidad) {
        List<Reserva> reservas = new ArrayList<>();
        Reserva hotel= new Reserva("Reserva Hotel",tipoReserva.HOTEL,3000);
        Reserva comida= new Reserva("Reserva comida",tipoReserva.COMIDA,1000);
        Reserva viaje= new Reserva("Reserva viaje",tipoReserva.VIAJES,10000);
        Reserva transporte= new Reserva("Reserva transporte",tipoReserva.TRANSPORTE,10000);
        for (int i = 0; i < cantidad; i++) {
            reservas.add(hotel);
            reservas.add(comida);
            reservas.add(viaje);
            reservas.add(transporte);
        }return reservas;
    }

    public static List<Reserva> cargarPaqueteParcial(tipoReserva tipoReserva) {
        Scanner scanner = new Scanner(System.in);
        List<Reserva> reservas = new ArrayList<>();
        System.out.println("ingrese la cantidad de reservas del tipo "+ tipoReserva + " a cargar:");
        int cantidad = scanner.nextInt();
        Reserva hotel= new Reserva("Reserva Hotel",tipoReserva.HOTEL,3000);
        Reserva comida= new Reserva("Reserva comida",tipoReserva.COMIDA,1000);
        Reserva viaje= new Reserva("Reserva viaje",tipoReserva.VIAJES,10000);
        Reserva transporte= new Reserva("Reserva transporte",tipoReserva.TRANSPORTE,10000);
        for(int i=0;i<cantidad;i++) {
            if(hotel.getTipoReserva().equals(tipoReserva)) {
                reservas.add(hotel);
            }else if(comida.getTipoReserva().equals(tipoReserva)) {
                reservas.add(comida);
            }else if(viaje.getTipoReserva().equals(tipoReserva)) {
                reservas.add(viaje);
            }else if(transporte.getTipoReserva().equals(tipoReserva)) {
                reservas.add(transporte);
            }
        }
        return reservas;
    }

}





