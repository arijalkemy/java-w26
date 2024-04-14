import modelo.Cliente;
import modelo.Factura;
import modelo.ItemFactura;
import modelo.Producto;
import repositorios.RepositorioCliente;

import java.util.*;

public class MenuInteractivo {

    private Scanner teclado = new Scanner(System.in);

    private RepositorioCliente repositorioCliente = new RepositorioCliente();


    public void interactuar() {

        while (true) {
            System.out.println("Seleccione una opción");
            System.out.println("SALIR: 0");
            System.out.println("BUSCAR CLIENTE X DNI: 1");
            System.out.println("CREAR COMPRA CON FACTURA: 2");
            System.out.println("CREAR CUENTA: 3");
            System.out.println("MOSTRAR CLIENTES: 4");

            int opcion = teclado.nextInt();

            switch (opcion) {
                case 0 -> {
                    return;
                }
                case 1 -> {
                    this.buscarCliente();
                }
                case 2 -> {
                    this.comprar();
                }
                case 3 -> {
                    this.crearCliente();
                }
                case 4 -> {
                    this.mostrarClientes();
                }
            }
        }
    }

    private void buscarCliente() {
        System.out.println("INGRESE EL DNI");
        String dniBuscado = teclado.next();

        List<Cliente> clientes = repositorioCliente.obtenerTodos();

        Optional<Cliente> cliente = clientes.stream().filter(cl -> cl.getDni().equals(dniBuscado)).findAny();

        if (cliente.isPresent()) {
            System.out.println("Cliente encontrado: ");
            System.out.println(cliente.get().toString());
            System.out.println();
        } else {
            System.out.println("Cliente no encontrado.");
            System.out.println();
        }
    }

    private void crearCliente(){
        System.out.println("CREAR CUENTA: ");
        System.out.println("INGRESE SU NOMBRE");
        teclado.nextLine();

        String nombre = teclado.nextLine();

        System.out.println("NOMBRE: " + nombre);

        System.out.println("INGRESE SU APELLIDO");
        String apellido = teclado.nextLine();

        System.out.println("INGRESE SU DNI");
        String dni = teclado.nextLine();

        Cliente cliente = new Cliente(nombre, apellido, dni);

        repositorioCliente.guardar(cliente);

        System.out.println("GUARDADO CON EXITO");
    }

    public void setRepositorioCliente(RepositorioCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    private void comprar() {

        System.out.println("INGRESE EL DNI");

        String dniIngresado = teclado.next();

        Optional<Cliente> clienteOptional = repositorioCliente.buscarPorId(dniIngresado);

        if (clienteOptional.isPresent()) {
            List<ItemFactura> itemFacturaList = new ArrayList<>();

            Producto cocaCola = new Producto("Coca Cola", 10);
            Producto pepsi = new Producto("Pepsi", 8);
            Producto fanta = new Producto("Fanta", 5);
            Producto aquarius = new Producto("Aquarius", 6);
            List<Producto> productos = new ArrayList<>(Arrays.asList(cocaCola, pepsi, fanta, aquarius));

            while (true) {
                System.out.println("INGRESE QUE QUIERE COMPRAR: ");
                System.out.println("APRIETE 0 CUANDO HAYA TERMINADO DE ELEGIR LOS ITEMS");


                for (int i = 0; i < productos.size(); i++) {
                    System.out.println("OPCION: " + (i + 1) + " | " + productos.get(i).toString());
                }

                Integer opcionSeleccionada = teclado.nextInt();

                if (opcionSeleccionada == 0) {
                    if (itemFacturaList.isEmpty()) {
                        System.out.println("Debe seleccionar al menos un producto");
                        continue;
                    }

                    System.out.println("ITEMS: ");
                    for (ItemFactura itemFactura : itemFacturaList) {
                        System.out.println(itemFactura.producto.nombre + " | " + itemFactura.costoUnitario + " | " + itemFactura.cantidadComprada);
                    }


                    Factura factura = new Factura(clienteOptional.get(),itemFacturaList);

                    System.out.println("TOTAL: " + factura.getTotalDeLaCompra());

                    System.out.println(factura.toString());

                    System.out.println("FACTURA CREADA Y GUARDADA CON EXITO");

                    break;
                }

                if (0 < opcionSeleccionada && opcionSeleccionada < 5) {
                    System.out.println("CANTIDAD QUE QUIERE COMPRAR: ");
                    Integer cantidadSeleccionada = teclado.nextInt();

                    Producto producto = productos.get(opcionSeleccionada - 1);

                    itemFacturaList.add(new ItemFactura(producto, cantidadSeleccionada, producto.costoUnitario));

                } else {
                    System.out.println("Opcion inexistente");
                }

            }

        } else {
            System.out.println("Cliente no encontrado, quiere crearlo?");
            System.out.println("OPCION 1: SI");
            System.out.println("OPCION 2: NO");

            int opcionSeleccionada = teclado.nextInt();

            if(opcionSeleccionada==1){
                this.crearCliente();
            }
        }
    }

    private void mostrarClientes(){
        System.out.println("Clientes: ");
        List<Cliente> clientes = repositorioCliente.obtenerTodos();

        clientes = repositorioCliente.obtenerTodos();
        for (Cliente cliente : clientes)
            System.out.println(cliente.toString());
    }
}
