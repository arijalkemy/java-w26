import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Cliente cliente = new Cliente("Raul", "Rodriguez", 22223334);
        Reserva reserva = new Reserva(20000.00, "hotel");
        Reserva reserva3 = new Reserva(20000.00, "comida");
        Reserva reserva4 = new Reserva(20000.00, "boletos");
        Reserva reserva5 = new Reserva(20000.00, "transporte");


        Localizador localizador = new Localizador(cliente);

        /*Aplicar descuento paquete completo*/
        localizador.agregarReserva(reserva);
        localizador.agregarReserva(reserva3);
        localizador.agregarReserva(reserva4);
        localizador.agregarReserva(reserva5);

        System.out.println(localizador);

        Repositorio repositorio = new Repositorio();

        repositorio.agregarLocalizador(localizador);
        System.out.println(repositorio);

         /*Si reservo dos hoteles o dos boletos*/

        Cliente cliente2 = new Cliente("Maria", "Rodriguez", 9988774);
        Reserva reserva6 = new Reserva(40000.00, "hotel");
        Reserva reserva7 = new Reserva(40000.00, "hotel");

        Localizador localizador1 = new Localizador(cliente2);
        localizador1.agregarReserva(reserva6);
        localizador1.agregarReserva(reserva7);
        repositorio.agregarLocalizador(localizador1);

        System.out.println(repositorio);

        System.out.println("Localizadores vendidos: " + repositorio.obtenerTotalLocalizadores());

        System.out.println("Total de reservas: " + repositorio.obtenerTotalReservas());

        Map<String, List<Reserva>> reservaMap = repositorio.obtenerReservasClasificadasPorTipo();

        reservaMap.forEach((tipo, listaReservas) -> {
            System.out.println("Tipo de reserva: " + tipo);
            listaReservas.forEach(r -> System.out.println("Reserva: " + r));
        });


        System.out.println("Total de ventas :$"+repositorio.obtenerTotalVentas());
        System.out.println("Promedio de ventas: " + repositorio.obtenerPromedioVentas());





    }
}
