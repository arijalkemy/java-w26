package org.ggomezr;

public class AgenciaViajes {
    public static void main(String[] args) {
        // Crear reservas
        Reserva reservaHotel = new Reserva("hotel", 1000);
        Reserva reservaComida = new Reserva("comida", 500);
        Reserva reservaBoleto = new Reserva("boleto", 300);
        Reserva reservaTransporte = new Reserva("transporte", 200);

        // Cliente
        String cliente = "Juan";

        // Crear localizador con paquete completo
        Localizador localizadorCompleto = new Localizador(cliente);
        localizadorCompleto.agregarReserva(reservaHotel);
        localizadorCompleto.agregarReserva(reservaComida);
        localizadorCompleto.agregarReserva(reservaBoleto);
        localizadorCompleto.agregarReserva(reservaTransporte);

        // Imprimir el localizador completo
        System.out.println("Localizador con paquete completo para " + cliente + ":");
        System.out.println(localizadorCompleto);

        // Crear localizador con 2 reservas de hotel y 2 de boletos
        Localizador localizadorDescuento = new Localizador(cliente);
        localizadorDescuento.agregarReserva(reservaHotel);
        localizadorDescuento.agregarReserva(reservaHotel);
        localizadorDescuento.agregarReserva(reservaBoleto);
        localizadorDescuento.agregarReserva(reservaTransporte);

        // Imprimir el localizador con descuento por repetición de reservas
        System.out.println("\nLocalizador con descuento por repetición de reservas para " + cliente + ":");
        System.out.println(localizadorDescuento);

        // Crear localizador con una sola reserva
        Localizador localizadorSimple = new Localizador(cliente);
        localizadorSimple.agregarReserva(reservaHotel);

        // Imprimir el localizador con una sola reserva
        System.out.println("\nLocalizador con una sola reserva para " + cliente + ":");
        System.out.println(localizadorSimple);

        // Repositorio de clientes
        RepositorioClientes repositorio = new RepositorioClientes();

        repositorio.agregarLocalizador(cliente, localizadorSimple);
        repositorio.agregarLocalizador(cliente, localizadorDescuento);
        repositorio.agregarLocalizador(cliente, localizadorCompleto);
    }
}