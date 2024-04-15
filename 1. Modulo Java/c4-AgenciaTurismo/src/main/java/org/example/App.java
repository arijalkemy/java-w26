package org.example;

import org.example.Productos.Boleto;
import org.example.Productos.Comida;
import org.example.Productos.Hotel;
import org.example.Productos.Transporte;

/**
 * Hello world!
 *
 */
public class App
{
    private RepositorioCliente repositorioCliente = new RepositorioCliente();
    private Repositorio reservaciones = new Repositorio();

    public static void main( String[] args )
    {

        App app = new App();
        Hotel hotel1 = new Hotel("hotel1", 100);
        Boleto boleto = new Boleto("boleto1", 50);
        Comida Comida1 = new Comida("comida1", 10);
        Transporte transporte1 = new Transporte("transporte1", 40);

        Cliente cliente1 = new Cliente("cliente1", "apellido","121212");

        Hotel hotel2 = new Hotel("hotel2", 100);
        Hotel hotel3 = new Hotel("hotel3", 100);


        Paquete paquete1 = new Paquete();
        Paquete paquete2 = new Paquete();

        paquete1.getBoletos().add(boleto);
        paquete1.getHotels().add(hotel1);
        paquete1.getComidas().add(Comida1);
        paquete1.getTransportes().add(transporte1);

        app.agregarReserva(paquete1, cliente1);

        app.mostrarReservas();

        paquete2.getHotels().add(hotel2);
        paquete2.getHotels().add(hotel3);
        paquete2.getBoletos().add(boleto);
        paquete2.getBoletos().add(boleto);

        app.agregarReserva(paquete2, cliente1);
        app.agregarReserva(paquete2, cliente1);
        app.mostrarReservas();
        app.mostrarCliente();

        System.out.println(cliente1.getCantidad());
    }

    public Cliente verificarCliente(Cliente cliente){
        boolean clienteEncontrado = false;
        for(Cliente resp :  repositorioCliente.getClientes()){
                if(resp.getDni().equals(cliente.getDni())){
                    System.out.println("Cliente encontrado");
                    clienteEncontrado = true;
                    return resp;
            }
        }

        System.out.println("cliente añadido");
        repositorioCliente.addCliente(cliente);

        return cliente;

    }

    public void agregarReserva(Paquete paquete, Cliente cliente){
        Cliente clienteEncontrado = this.verificarCliente(cliente);
        Reserva reserva = new Reserva(clienteEncontrado, paquete);
        reservaciones.addReserva(reserva);
        clienteEncontrado.setCantidad();
    }

    public void mostrarReservas(){
        for(Reserva reservacione : reservaciones.getListaReserva()){
            System.out.println(reservacione.toString());
        }
    }
    public void mostrarCliente(){
        for(Cliente reservacione : repositorioCliente.getClientes()){
            System.out.println(reservacione.toString());
        }
    }
}
