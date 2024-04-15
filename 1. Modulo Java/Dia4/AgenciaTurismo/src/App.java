import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        RepositorioCliente repositorioCliente = new RepositorioCliente();
        Cliente cliente = new Cliente("123456");

        // Crear localizador con un paquete completo para el cliente
        Localizador localizador1 = new Localizador("123456", "hotel, comida, boletos, transporte", 1000);
        cliente.agregarReserva(localizador1);
        repositorioCliente.agregarCliente(cliente);

        // Imprimir localizador y el descuento aplicado
        imprimirLocalizadorConDescuento(localizador1, cliente);

        // Crear localizador con 2 reservas de hotel y 2 de boletos para el mismo cliente
        Localizador localizador2 = new Localizador("123456", "hotel, hotel, boletos, boletos", 800);
        cliente.agregarReserva(localizador2);

        // Imprimir el localizador y el descuento aplicado
        imprimirLocalizadorConDescuento(localizador2, cliente);

        // Crear localizador con una sola reserva para el mismo cliente
        Localizador localizador3 = new Localizador("123456", "hotel", 200);
        cliente.agregarReserva(localizador3);

        // Imprimir el localizador y el descuento aplicado
        imprimirLocalizadorConDescuento(localizador3, cliente);

        System.out.println("A partir de acá parte opcional");

        List<Localizador> localizadores = new ArrayList<>();
        localizadores.add(localizador1);
        localizadores.add(localizador2);
        localizadores.add(localizador3);

        // Crear instancia de ConsultasLocalizadores
        ConsultasLocalizadores consultas = new ConsultasLocalizadores(localizadores);

        // Probar los métodos
        System.out.println("Cantidad de localizadores vendidos: " + consultas.cantidadLocalizadoresVendidos());
        System.out.println("Cantidad total de reservas: " + consultas.cantidadTotalReservas());
        System.out.println("Reservas por tipo: " + consultas.obtenerReservasPorTipo());
        System.out.println("Total de ventas: " + consultas.totalVentas());
        System.out.println("Promedio de ventas por localizador: " + consultas.promedioVentas());
    }

    private static void imprimirLocalizadorConDescuento(Localizador localizador, Cliente cliente) {
        double descuento = Descuentos.aplicarDescuento(localizador, cliente);
        double totalConDescuento = localizador.getTotal() - descuento;
        System.out.println("Detalles de la reserva: " + localizador.getDetalles());
        System.out.println("Total: " + localizador.getTotal());
        System.out.println("Descuento aplicado: " + descuento);
        System.out.println("Total con descuento: " + totalConDescuento);
        System.out.println();
    }
}
