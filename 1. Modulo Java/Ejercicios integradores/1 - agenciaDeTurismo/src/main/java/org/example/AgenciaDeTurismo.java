package org.example;
import java.util.*;

public class AgenciaDeTurismo{

    public static void main(String[] args) {
        RepositorioClienteImpl repositorioCliente = new RepositorioClienteImpl();
        RepositorioLocalizador repositorioLocalizador = new RepositorioLocalizador();

        // Crear y agregar un cliente
        Cliente cliente1 = new Cliente(1, "Juan Pérez", new ArrayList<>());
        repositorioCliente.agregarCliente(cliente1);

        // Crear un localizador con un paquete completo
        Localizador localizador1 = new Localizador(1, cliente1);
        localizador1.getDetallesReserva().add(new DetalleReserva("hotel", 200.00));
        localizador1.getDetallesReserva().add(new DetalleReserva("comida", 100.00));
        localizador1.getDetallesReserva().add(new DetalleReserva("boleto", 150.00));
        localizador1.getDetallesReserva().add(new DetalleReserva("transporte", 80.00));
        repositorioLocalizador.agregarLocalizador(localizador1);

        // Aplicar descuentos y guardar
        repositorioLocalizador.aplicarDescuentos(localizador1);

        // Imprimir detalles del localizador
        System.out.println("Total con descuentos: $" + localizador1.getTotal());

        // Simular otras operaciones como agregar más localizadores y aplicar descuentos
    }
}
