package org.example;

import org.example.entity.Cliente;
import org.example.entity.Factura;
import org.example.entity.Item;
import org.example.repository.RepositoryClienteImpl;
import org.example.repository.RepositoryFacturaImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        int opcion=1;
        RepositoryClienteImpl clienteImpl=new RepositoryClienteImpl();
        RepositoryFacturaImpl facturaImpl=new RepositoryFacturaImpl();

        Cliente cliente1=new Cliente(1234567,"Manu","Malacara");
        Cliente  cliente2=new Cliente(2341233,"Pepe","Perez");
        Cliente  cliente3=new Cliente(4562938,"David","Contreras");

        clienteImpl.guaradar(cliente1);
        clienteImpl.guaradar(cliente2);
        clienteImpl.guaradar(cliente3);

        List<Factura> facturas=new ArrayList<Factura>();

        Scanner sc= new Scanner(System.in);

        do{
            System.out.println("\n1)Imprimir clientes." +
                    "\n2)Borrar Cliente." +
                    "\n3)Buscar cliente." +
                    "\n4)CrearFactura" +
                    "\n0)Salir.");
            System.out.println("Elige una opcion:");
            opcion=sc.nextInt();
            switch(opcion){
                case 0:
                    opcion=0;
                    break;
                case 1:
                    clienteImpl.mostrar();
                    break;
                case 2:
                    clienteImpl.eliminar();
                    clienteImpl.mostrar();
                    break;
                case 3:
                    System.out.println("Inserte un DNI a buscar:");
                    opcion=sc.nextInt();
                    clienteImpl.buscar(opcion);
                    break;
                case 4:
                    System.out.println("Inserte un DNI del cliente:");
                    opcion=sc.nextInt();
                    Cliente cliente=clienteImpl.buscarClienteParaFactura(opcion);
                    if (cliente==null){
                        System.out.println("El cliente no existe");
                        break;
                    }
                    List<Item> items=new ArrayList<Item>();

                    System.out.println("Inserte cuantos items diferentes hay en la factura:");
                    int i=sc.nextInt();
                    for(int j = 0; j < i; j++) {
                        items.add(itemParaFactura());
                    }
                    System.out.println("Inserte el codigo de la factura:");
                    int codigo=sc.nextInt();
                    Factura factura = new Factura(clienteImpl.buscarClienteParaFactura(opcion),items,calcularTotal(items),codigo);
                    facturaImpl.guaradar(factura);
                    break;
                default:
                    System.out.printf("Opcion no valida.");
            }
        }while(opcion!=0);
    }
    public static double calcularTotal(List<Item> items){
        double total=0;
        for (Item item : items) {
            total+=item.getCostoUnitario()*item.getCantidadComprada();
        }
        return total;
    }
    public static Item itemParaFactura(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Escribe el codigo del item");
        int codigo=sc.nextInt();
        System.out.println("Escribe el nombre del item");
        String nombre=sc.next();
        System.out.println("Escribe el precio unitario del item");
        double precio=sc.nextDouble();
        System.out.println("Escribe la cantidad del item");
        int cantidad=sc.nextInt();
        return new Item(codigo, nombre,cantidad,precio);
    }
}
