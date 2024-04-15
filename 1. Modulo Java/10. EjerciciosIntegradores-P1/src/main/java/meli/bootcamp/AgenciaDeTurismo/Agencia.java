package meli.bootcamp.AgenciaDeTurismo;

public class Agencia {

    public static void main(String[] args) {
        Cliente cliente = new Cliente(1, "Pedro", "Gonzales");
        Reserva viaje = new Reserva(TipoReserva.VIAJE);
        Reserva hotel = new Reserva(TipoReserva.HOTEL);
        Reserva comida = new Reserva(TipoReserva.COMIDA);
        Reserva paquete = new Reserva(TipoReserva.PAQUETE);


        Localizador localizadorUno = new Localizador(cliente);
        localizadorUno.agregarReserva(viaje);
        localizadorUno.agregarReserva(hotel);

        Localizador localizadorDos = new Localizador(cliente);
        Localizador localizadorTres = new Localizador(cliente);

        localizadorDos.agregarReserva(viaje);
        localizadorDos.agregarReserva(hotel);
        localizadorDos.agregarReserva(comida);
        localizadorDos.agregarReserva(paquete);
        localizadorDos.agregarReserva(paquete);

        localizadorTres.agregarReserva(viaje);
        localizadorTres.agregarReserva(hotel);
        localizadorTres.agregarReserva(viaje);


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
