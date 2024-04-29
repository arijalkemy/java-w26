package org.decodificador.servicio;

import org.decodificador.modelo.Cliente;
import org.decodificador.modelo.Factura;
import org.decodificador.modelo.Item;
import org.decodificador.repositorio.RepositorioProducto;

import java.util.ArrayList;
import java.util.List;

public class ServicioFactura {
    private ServicioCliente servicioCliente;
    private RepositorioProducto repositorioProducto;
    private List<Item> lista_Item;


    public ServicioFactura(ServicioCliente servicioCliente) {
        this.servicioCliente = servicioCliente;
        lista_Item = new ArrayList<Item>();
        repositorioProducto = new RepositorioProducto();
    }
    // 1) Será necesario validar si el cliente asociado a la factura se encuentra registrado en la collection de clientes.
    // En caso de que no, el mismo deberá ser creado.
    public void asignarClienteAFactura(Integer idCliente){
        Cliente miCliente = servicioCliente.mostrarCliente(idCliente);
        //Valida si el cliente esta registrado
        if(miCliente != null){
            //Generar una lista de productos
            //Lista escolar
            //2 Se crea una lista de items y asociarla a la factura creada.
            lista_Item.add(new Item(12,repositorioProducto.getProducto(1)));
            lista_Item.add(new Item(1,repositorioProducto.getProducto(2)));
            lista_Item.add(new Item(1,repositorioProducto.getProducto(4)));
            lista_Item.add(new Item(2,repositorioProducto.getProducto(3)));
            Double totalCompra = calcularTotalLista(lista_Item);
            Factura miFactura = new Factura(miCliente, lista_Item, totalCompra);
            this.detallesFactura(miFactura);
        }else{
            System.out.println("Se requiere registrar cliente...");
        }
    }
    //3
    //Calcular total de la lista de items
    private Double calcularTotalLista(List<Item> lista_Items){
        return lista_Item.stream().mapToDouble(i -> i.getCantidad()*i.getProducto().getCostoUnitario()).sum();
    }

    //Generar factura
    private void detallesFactura(Factura miFactura){
        System.out.println("--------------------------------");
        System.out.println("Factura.........................");
        System.out.println("Cliente: "+miFactura.getCliente().getNombre());
        System.out.println("ID: "+miFactura.getCliente().getDni());
        System.out.println("--------------------------------");
        for(Item item : miFactura.getListaItemsCompra()){
            System.out.println("Producto: "+item.getProducto().getNombre()+", cantidad: "+item.getCantidad() + ", Precio: "+item.getProducto().getCostoUnitario());
        }
        System.out.println("---------------------------------");
        System.out.println("Total. "+miFactura.getValorTotal());

    }
}
