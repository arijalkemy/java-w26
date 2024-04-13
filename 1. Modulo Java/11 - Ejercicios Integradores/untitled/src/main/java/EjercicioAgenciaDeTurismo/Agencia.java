package EjercicioAgenciaDeTurismo;

/**
 * Hello world!
 *
 */
public class Agencia
{
    public static void main( String[] args )
    {
        Cliente clienteUno = new Cliente(1,"Gomez","Gonzalo");
        Reserva reservaHotel = new Reserva(10.0,"hotel");
        Reserva reservaTransporte = new Reserva(10.0,"Transporte");
        Reserva reservaComida = new Reserva(10.0,"Comida");
        Reserva reservaViaje = new Reserva(10.0,"viaje");


        Localizador localizadorUno = new Localizador(clienteUno);
        localizadorUno.agregarReserva(reservaHotel);
        localizadorUno.agregarReserva(reservaTransporte);

        Localizador localizadorDos = new Localizador(clienteUno);
        Localizador localizadorTres= new Localizador(clienteUno);

        localizadorDos.agregarReserva(reservaHotel);
        localizadorDos.agregarReserva(reservaTransporte);
        localizadorDos.agregarReserva(reservaComida);
        localizadorDos.agregarReserva(reservaViaje);
        localizadorDos.agregarReserva(reservaViaje);

        localizadorTres.agregarReserva(reservaHotel);
        localizadorTres.agregarReserva(reservaTransporte);


        Repositorio repositorio = new Repositorio();
        repositorio.agregarLocalizador(localizadorUno);
        repositorio.agregarLocalizador(localizadorDos);
        repositorio.agregarLocalizador(localizadorDos);
        repositorio.agregarLocalizador(localizadorTres);


        System.out.println(localizadorUno.toString());
        System.out.println(localizadorDos.toString());
        System.out.println(localizadorTres.toString());


    }
}
