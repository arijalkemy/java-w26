package org.example.viajes;

public class Main {
    public static void main(String[] args) {
        RepositorioClientes repositorio = new RepositorioClientes();

        Cliente cliente1 = new Cliente("001", "Juan Perez");

        // localizador con paquete completo
        Localizador localizador1 = new Localizador(cliente1);
        localizador1.agregarReserva(new Reserva("hotel", 200));
        localizador1.agregarReserva(new Reserva("comida", 100));
        localizador1.agregarReserva(new Reserva("boletos", 300));
        localizador1.agregarReserva(new Reserva("transporte", 50));
        localizador1.aplicarDescuento(10); // 10% descuento por paquete completo
        repositorio.agregarCliente(cliente1);
        cliente1.agregarLocalizador(localizador1);
        localizador1.imprimir();

        // localizador con 2 reservas de hotel y 2 de boletos
        Localizador localizador2 = new Localizador(cliente1);
        localizador2.agregarReserva(new Reserva("hotel", 200));
        localizador2.agregarReserva(new Reserva("hotel", 200));
        localizador2.agregarReserva(new Reserva("boletos", 300));
        localizador2.agregarReserva(new Reserva("boletos", 300));
        localizador2.aplicarDescuento(5); // 5% descuento por 2 reservas de hotel y 2 de boletos
        cliente1.agregarLocalizador(localizador2);
        localizador2.imprimir();

        // localizador con una sola reserva
        Localizador localizador3 = new Localizador(cliente1);
        localizador3.agregarReserva(new Reserva("comida", 100));
        if (cliente1.getLocalizadores().size() >= 2) {
            localizador3.aplicarDescuento(5); // 5% descuento por cliente frecuente
        }
        cliente1.agregarLocalizador(localizador3);
        localizador3.imprimir();
    }
}
