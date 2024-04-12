package meli.bootcamp;

import java.util.List;

public class Main {
  public static void main(String[] args) {
    // El sistema al iniciar debería instanciar los repositorios y cargarlos en memoria
    RepositorioClientes repositorioClientes = new RepositorioClientes();
    RepositorioLocalizadores repositorioLocalizadores = new RepositorioLocalizadores();

    // En algún momento se inicia el caso de uso de comprar un paquete turístico
    // Por ejemplo desde un controlador / servicio

    // El cliente se obtendría de la sesion
    Cliente cliente = new Cliente("Juan", "Perez", "juan@gmail.com", "1234567890");

    // El cliente seleccionaría las reservas que desee hacer
    Reserva reservaHotel = new Reserva(TipoReserva.HOTEL, 1000);
    Reserva reservaComida = new Reserva(TipoReserva.COMIDA, 500);
    Reserva reservaViaje = new Reserva(TipoReserva.VIAJE, 2000);
    Reserva reservaTransporte = new Reserva(TipoReserva.TRANSPORTE, 300);

    // Se crearía un localizador con las reservas seleccionadas por el cliente que se guardaría en el repositorio
    Localizador localizador = new Localizador(
        List.of(reservaHotel, reservaComida, reservaViaje, reservaTransporte), cliente
    );

    repositorioLocalizadores.agregarLocalizador(localizador);

    // En algun momento se calcula el precio final del paquete y se llama a los siguientes metodos
    // Quien tenga esta responsabilidad debe conocer al repositorio de localizadores
    // y saber cual es el descuento por haber adquirido dos localizadores antes
    double precioSinDescuentos = localizador.calcularTotalSinDescuento(); // para mostrar el total
    double descuento = localizador.calcularTotalDeDescuentos(); // para obtener el descuento total

    double porcentajeDeDescuentoMasDeDosLocalizadores = 0.1;
    if(repositorioLocalizadores.adquirioMasDeDosLocalizadores(cliente)) {
      descuento += precioSinDescuentos * porcentajeDeDescuentoMasDeDosLocalizadores;
    }

    System.out.println("Precio sin descuentos: " + precioSinDescuentos);
    System.out.println("Descuento de:          " + descuento);
    System.out.println("Precio final:          " + (precioSinDescuentos - descuento));
  }
}