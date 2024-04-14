import modelo.Cliente;
import modelo.Factura;
import modelo.ItemFactura;
import modelo.Producto;
import repositorios.RepositorioCliente;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Cliente nacho = new Cliente("Nacho", "Ruiz Diaz", "44080739");
        Cliente julieta = new Cliente("Julieta", "Ruiz Diaz", "44080740");
        Cliente felipe = new Cliente("Felipe", "Ruiz Diaz", "44080741");


        List<Cliente> clientes = new ArrayList<>(Arrays.asList(nacho,julieta,felipe));

        System.out.println("CLIENTES");
        for(Cliente cliente : clientes)
            System.out.println(cliente.toString());

        System.out.println();

        System.out.println("CLIENTES SIN FELIPE");
        clientes.remove(felipe);

        for(Cliente cliente : clientes)
            System.out.println(cliente.toString());

        Scanner teclado = new Scanner(System.in);

        System.out.println();
        System.out.println();

        RepositorioCliente repositorioCliente = new RepositorioCliente();

        repositorioCliente.guardar(nacho);
        repositorioCliente.guardar(julieta);

        MenuInteractivo menuInteractivo = new MenuInteractivo();

        menuInteractivo.setRepositorioCliente(repositorioCliente);

        menuInteractivo.interactuar();
    }


}
