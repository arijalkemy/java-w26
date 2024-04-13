// Clase principal que simula el escenario
public class Main {
    public static void main(String[] args) {
        // Crear un cliente
        Cliente cliente = new Cliente("Juan","adress 1");

        // Crear un paquete completo para el cliente
        Localizador localizador1 = new Localizador(cliente);
        localizador1.agregarReserva(new Reserva("Hotel", 1000.0));
        localizador1.agregarReserva(new Reserva("Comida", 200.0));
        localizador1.agregarReserva(new Reserva("Boleto de Viaje", 500.0));
        localizador1.agregarReserva(new Reserva("Transporte", 300.0));

        // Imprimir detalles del localizador
        System.out.println("Localizador con paquete completo:");
        imprimirDetallesLocalizador(localizador1);

        // Crear un localizador con 2 reservas de hotel y 2 de boletos para el mismo cliente
        Localizador localizador2 = new Localizador(cliente);
        localizador2.agregarReserva(new Reserva("Hotel", 800.0));
        localizador2.agregarReserva(new Reserva("Hotel", 800.0));
        localizador2.agregarReserva(new Reserva("Boleto de Viaje", 600.0));
        localizador2.agregarReserva(new Reserva("Boleto de Viaje", 600.0));

        // Imprimir detalles del localizador
        System.out.println("\nLocalizador con 2 reservas de hotel y 2 de boletos:");
        imprimirDetallesLocalizador(localizador2);

        // Crear un localizador con una sola reserva para el mismo cliente
        Localizador localizador3 = new Localizador(cliente);
        localizador3.agregarReserva(new Reserva("Comida", 150.0));

        // Imprimir detalles del localizador
        System.out.println("\nLocalizador con una sola reserva:");
        imprimirDetallesLocalizador(localizador3);

        // Verificar que los descuentos fueron aplicados
        System.out.println("\nDescuentos aplicados:");
        System.out.println("Localizador 1: " + localizador1.getTotal());
        System.out.println("Localizador 2: " + localizador2.getTotal());
        System.out.println("Localizador 3: " + localizador3.getTotal());
    }

    // Método para imprimir detalles de un localizador
    public static void imprimirDetallesLocalizador(Localizador localizador) {
        System.out.println("Cliente: " + localizador.getCliente().getNombre());
        System.out.println("Total: " + localizador.getTotal());

        System.out.println("Reservas:");
        for (Reserva reserva : localizador.getReservas()) {
            System.out.println(reserva.getTipo() + ": " + reserva.getCosto());
        }
    }
}
