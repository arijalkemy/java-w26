package org.example;

import org.example.classes.Cliente;
import org.example.classes.Localizador;
import org.example.classes.Reserva;
import org.example.repository.LocalizadorRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        LocalizadorRepository localizadorRepository = new LocalizadorRepository();
        Cliente cliente = new Cliente("123", "Matias", "Pinto");
        // Se ha optado por usar un repositorio de Localizadores, cuya KEY será el DNI del usuario.
        // Value: Lista de Localizadores

        // Parte 1 ------ Todos los costos van a $ 10.0 para su mejor verificacion
        // a)
        Localizador localizadorCompleto = new Localizador(cliente);

        Reserva reservaViaje = new Reserva("Vuelo", 10.0);
        Reserva reservaComida = new Reserva("Comida", 10.0);
        Reserva reservaHotel = new Reserva("Hotel", 10.0);
        Reserva reservaTransporte = new Reserva("Transporte", 10.0);
        localizadorCompleto.agregarReserva(reservaViaje);
        localizadorCompleto.agregarReserva(reservaComida);
        localizadorCompleto.agregarReserva(reservaHotel);
        localizadorCompleto.agregarReserva(reservaTransporte);

        // b)
        Reserva reservaHotel1 = new Reserva("Hotel", 10.0);
        Reserva reservaTransporte1 = new Reserva("Transporte", 10.0);
        Localizador localizadorSemi = new Localizador(cliente);
        localizadorSemi.agregarReserva(reservaHotel);
        localizadorSemi.agregarReserva(reservaHotel1);
        localizadorSemi.agregarReserva(reservaTransporte);
        localizadorSemi.agregarReserva(reservaTransporte1);

        // c)
        Localizador localizadorUnItem = new Localizador(cliente);
        localizadorUnItem.agregarReserva(reservaHotel);

        localizadorRepository.agregarLocalizador(localizadorCompleto);
        localizadorRepository.agregarLocalizador(localizadorSemi);
        localizadorRepository.agregarLocalizador(localizadorUnItem);

        // d) Verificando valores
        List<Localizador> localizaresCliente = localizadorRepository.getLocalizadores("123");
        System.out.println("El precio del localizador completo del cliente es: $ " + localizaresCliente.get(0).getCostoTotal());
        System.out.println("El precio del localizador semi del cliente es: $ " + localizaresCliente.get(1).getCostoTotal());
        System.out.println("El precio del localizador un item del cliente es: $ " + localizaresCliente.get(2).getCostoTotal());
        System.out.println();
        // Parte 2
        System.out.println("Cantidad de localizadores vendidos: " + localizadorRepository.getTotalLocalizadores());
        System.out.println("Cantidad de reservas totales: " + localizadorRepository.getTotalReservas());
        System.out.println("Valor ventas totales: $ " + localizadorRepository.getTotalVentas());
        System.out.println("Valor promedio de ventas: $ " + localizadorRepository.getPromedioVentas());
    }
}