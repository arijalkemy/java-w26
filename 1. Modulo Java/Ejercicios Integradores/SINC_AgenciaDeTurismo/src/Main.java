import java.util.List;

public class Main {
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente("Marcos", "Ditta", "42052682");
        Reserva reservaHotel = new Reserva("Reserva hotel", 1200);
        Reserva reservaBoleto = new Reserva("Boleto", 500);
        Reserva reservaComida = new Reserva("Comida", 400);
        Reserva reservaTransporte = new Reserva("Transporte", 120);

        Reserva reservaHotel2 = new Reserva("Reserva hotel 2", 1000);
        Reserva reservaBoleto2 = new Reserva("Boleto 2", 700);

        //Punto 1a: crear un localizador con un paquete completo
        Localizador localizador = new Localizador(cliente1, List.of(reservaTransporte, reservaBoleto,
                                                                        reservaComida, reservaHotel));
        RepositorioLocalizador repoLocalizador = new RepositorioLocalizador();

        repoLocalizador.agregarLocalizadorARepositorio(localizador);

        System.out.println(localizador.imprimirDatosLocalizador());

        //Punto 1b: crear un localizador con 2 reserva de hotel y 2 boletos para el mismo cliente
        Localizador localizador2 = new Localizador(cliente1, List.of(reservaHotel, reservaHotel2,
                                                                        reservaBoleto, reservaBoleto2));
        repoLocalizador.agregarLocalizadorARepositorio(localizador2);
        System.out.println("\n" + localizador2.imprimirDatosLocalizador());

        //Punto 1c: crear un localizador con una sola reserva para el mismo cliente
        Localizador localizador3 = new Localizador(cliente1, List.of(reservaComida));
        repoLocalizador.agregarLocalizadorARepositorio(localizador3);
        System.out.println("\n" + localizador3.imprimirDatosLocalizador());

        //Resolucion parte dos
        System.out.println("\nParte 2: Opcional");
        System.out.println("Cantidad de localizadores vendidos: " +
                repoLocalizador.getListaLocalizadores().stream().count());

        long contadorCantReservas = 0;
        for (Localizador loc : repoLocalizador.getListaLocalizadores()) {
            contadorCantReservas = contadorCantReservas + loc.getReservas().stream().count();
        }
        System.out.println("Cantidad total de reservas: " + contadorCantReservas);

        System.out.println("Cantidad total de ventas en pesos: " +
                repoLocalizador.getListaLocalizadores().stream().mapToDouble(x -> x.getMontoConDescuento()).sum());

        System.out.println("Promedio total de ventas en pesos: " +
                repoLocalizador.getListaLocalizadores().stream().mapToDouble(x -> x.getMontoConDescuento())
                                                                                    .average().orElseThrow());
    }
}