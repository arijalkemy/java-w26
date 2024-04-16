package Supermercado;

import java.util.ArrayList;
import java.util.List;

public class Supermercado {
    List<Cliente> listaClientes = new ArrayList<>();
    List<Factura> listaFacturas = new ArrayList<>();

    //Crear 3 clientes y guardarlos en una collection.
    // this.listaVehiculos.add(new Vehiculo("Ford", "Fiesta", 1000));

    public void agregarClientes(){
        this.listaClientes.add(new Cliente("123456","Laion","uran"));
        this.listaClientes.add(new Cliente("654321","eymi","uran"));
        this.listaClientes.add(new Cliente("987654","shailo","uran"));
    }

    //Recorrer la collection de clientes y mostrar por pantalla los datos de cada uno de ellos.

    public void mostrarListaClientes(){
       for( Cliente cliente : listaClientes){
           System.out.println( "Cliente:" +cliente.getNombre() + cliente.getApellido() +
                   "DNI: " + cliente.getDni());
        }
    }
    //Eliminar uno de los clientes de la lista y volver a consultar e imprimir todos los clientes restantes.

    public void eliminarUnCliente(){
        listaClientes.remove(3);
    }
    //Solicitar por teclado un número de dni de un cliente para buscarlo. En caso de que el cliente se
    // encuentre en la lista, mostrar sus datos, caso contrario, mostrar un mensaje que informe dicha situación.

    public void buscarCliente(String dni){
        for(Cliente cliente : listaClientes){
            if(cliente.getDni().equals(dni)){
                System.out.println("Cliente encontrado: " + cliente.getNombre() + cliente.getApellido());
            }else{
                System.out.println("Cliente no encontrado");
            }
        }
    }
    //Antes de querer agregar una factura a una collection de facturas tener en cuenta que:
    //Será necesario validar si el cliente asociado a la factura se encuentra registrado en la collection de clientes.
    // En caso de que no, el mismo deberá ser creado.

    public void agregarFactura(Factura factura){
        for(Cliente cliente : listaClientes){
            if(cliente.getDni().equals(factura.getCliente().getDni())){
                listaFacturas.add(factura);
            }else{
                listaClientes.add(factura.getCliente());
                listaFacturas.add(factura);
            }
        }
    }




    //Crear o utilizar las correspondientes clases que sean capaz de implementar los métodos de la interfaz creada en el punto anterior.
    //Modificar el método main para que, en lugar de realizar todo el código de manera secuencial, se pueda modularizar mediante el llamado de métodos.

    public static void main(String[] args) {

        Supermercado supermercado = new Supermercado();

        supermercado.agregarClientes();
        supermercado.mostrarListaClientes();
        supermercado.eliminarUnCliente();
        supermercado.mostrarListaClientes();
        supermercado.buscarCliente("123456");

        Cliente cliente = new Cliente("123456","Laion","uran");
        List<Item> listaItems = new ArrayList<>();
        listaItems.add(new Item(1,"pan",2,10));
        listaItems.add(new Item(2,"leche",1,20));

        Factura factura = new Factura(cliente,listaItems);
        supermercado.agregarFactura(factura);

    }
}
