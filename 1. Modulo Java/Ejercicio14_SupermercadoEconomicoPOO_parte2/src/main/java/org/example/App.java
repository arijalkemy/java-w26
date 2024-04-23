package org.example;

import org.example.model.Cliente;
import org.example.model.Factura;
import org.example.model.Item;
import org.example.repository.ClienteImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ClienteImp cImplement = new ClienteImp();
        Scanner teclado = new Scanner(System.in);

        //Crear clientes
        Cliente cliente1 = new Cliente(123455L,"Jose","Guzman");
        Cliente cliente2 = new Cliente(103344L,"Andres","Quevedo");
        Cliente cliente3 = new Cliente(155653L,"Johan","Munoz");
        //Agregar clientes a una lista - agrupación
        cImplement.save(cliente1);
        cImplement.save(cliente2);
        cImplement.save(cliente3);
        //Mostrar todos los clientes en la lista
        cImplement.mostrarPantalla();
        //Borrar un cliente
        Long dniBorrar = teclado.nextLong();
        cImplement.eliminar(dniBorrar);
        //Buscar un cliente mediante su Dni
        System.out.println("Digite el dni del cliente a buscar");
        Long dniBuscar = teclado.nextLong();
        cImplement.buscar(dniBuscar);
        //Crear factura
        List<Factura> facturas = new ArrayList<>();
        boolean facturaCompleta = false;
        do{
            //Busqueda y validacion de la existencia del cliente
            Cliente clienteFactura = null;
            System.out.println("Digite el dni del cliente");
            dniBuscar = teclado.nextLong();
            for(Cliente c : clienteList){
                if (c.getDni().equals(dniBuscar)){
                    clienteFactura = c;
                }
            }
            //Creacion y almacenamiento de la lista de items
            List<Item> itemList = new ArrayList<>();
            System.out.println("Digite la cantidad de items a facturar");
            int cantItem = teclado.nextInt();
            for (int i = 0; i < cantItem ; i++) {
                System.out.println("digite dni del item #"+(i+1));
                Long dniItem = teclado.nextLong();
                System.out.println("digite nombre del item #"+(i+1));
                String nameItem = teclado.next();
                System.out.println("digite cantidad del item #"+(i+1));
                int cantidadItem = teclado.nextInt();
                System.out.println("digite costo unitario del item #"+(i+1));
                Double costItem = teclado.nextDouble();
                Item item = new Item(dniItem,nameItem,cantidadItem,costItem);
                itemList.add(item);
            }
            //Calcular el total de la factura
            double totalFactura = 0.0;
            for (Item i : itemList){
                totalFactura += (i.getCant() * i.getCostoUnitario());
            }
            //validar que este completo y Creando la factura
            if(clienteFactura != null){
                if (!itemList.isEmpty()){
                    if (totalFactura != 0.0){
                        System.out.println("Digite el codigo de la factura");
                        Long codfactura = teclado.nextLong();
                        System.out.println("Creando la factura...");
                        Factura factura = new Factura(codfactura,clienteFactura,itemList,totalFactura);
                        facturas.add(factura);
                        facturaCompleta = true;
                    }else {
                        System.out.println("No se pudo realizar el calculo de la factura, verifique que los datos se hayan ingresado correctamente y vuelva a intentarlo.");
                    }
                }else {
                    System.out.println("No se pudo realizar el cargue de los items, verifique que los datos se hayan ingresado correctamente y vuelva a intentarlo.");
                }
            }else {
                System.out.println("No se pudo encontrar el usuario, verifique que los datos se hayan ingresado correctamente y vuelva a intentarlo.");
            }

        }while (!facturaCompleta);
        for (Factura factura : facturas){
            System.out.println("Datos de la factura");
            System.out.println(factura.getCodigo());
            System.out.println(factura.getCliente().getDni());
            System.out.println(factura.getCliente().getNombre()+" "+factura.getCliente().getApellido());
            System.out.println(factura.getListaItems().toString());
            System.out.println(factura.getTotalFactura());
        }
    }
}
