import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cliente primerCliente = new Cliente("Emiliano","Corvalan", 12345678L);
        Cliente segundoCliente = new Cliente("Segundo","Claient",543239342L);
        Cliente tercerCliente = new Cliente("Tercero","Gonzalez",123435234L);

        List<Cliente> clientela = new ArrayList<>();
        clientela.add(primerCliente);
        clientela.add(segundoCliente);
        clientela.add(tercerCliente);
        System.out.println("//Parte 1 - Crear clientes y mostrarlos");
        for(Cliente client:clientela){
            System.out.println(client.toString());
        }
        System.out.println("// Parte 1 - Remover cliente");
        clientela.remove(tercerCliente);
        for(Cliente client:clientela){
            System.out.println(client.toString());
        }
        System.out.println("---------------");
        System.out.println("// Parte 1 - Buscar Cliente por DNI.");
        System.out.println("Ingrese DNI del cliente: ");
        Scanner teclado = new Scanner(System.in);
        Long dniCliente = teclado.nextLong();

        boolean bandera = false;
        for(Cliente client:clientela){
            if (client.getDni().equals(dniCliente)){
                System.out.println("Cliente encontrado: ");
                System.out.println("Nombre: " + client.getNombre());
                System.out.println("Apellido: " + client.getApellido());
                System.out.println("DNI: " +  client.getDni());
                bandera = true;
                break;
            }
        }
        if (bandera == false){
            System.out.println("Cliente no encontrado.");
        }

        System.out.println("-----------");
        System.out.println("// Parte 2 - Creacion de nueva factura");
        List<Item> itemsFactura1 = new ArrayList<>();
        Item arroz = new Item(1,"Arroz",2,1500);
        Item fideos = new Item(2,"Fideos A", 1, 1200);
        Item gaseosa = new Item(3,"Coca-Cola", 1, 2400);

        itemsFactura1.add(arroz);
        itemsFactura1.add(fideos);
        itemsFactura1.add(gaseosa);
        System.out.println("-- Productos agregados a la factura actual --");
        double calcularFactura = itemsFactura1.stream()
                .mapToDouble(Item::getTotal)
                .sum();

        Facturas factura1 = new Facturas(primerCliente,itemsFactura1);
        factura1.precioTotal = calcularFactura;
        System.out.println("El total de la factura actual es: " + factura1.getPrecioTotal());

        //Creacion de objeto Supermercado donde se encuentra la lista de facturas
        List<Facturas> listaFacturas = new ArrayList<>();
        Supermercado superElEconomico = new Supermercado("Super El Económico","20-2325345-4",listaFacturas);
        listaFacturas.add(factura1);
        System.out.println("------ Listado de facturas del supermercado -------");
        for (Facturas f : listaFacturas){
            System.out.println(f.toString());
        }

    }
}