package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.example.interfaces.ClientCRUD;
import com.example.interfaces.InvoiceCRUD;
import com.example.interfaces.ProductCRUD;
import com.example.store.Client;
import com.example.store.Invoice;
import com.example.store.Product;

public class App {

    public static void main(String[] args) {

        ClientCRUD clientCRUD = new ClientCRUD();
        InvoiceCRUD invoiceCRUD = new InvoiceCRUD();
        ProductCRUD productCRUD = new ProductCRUD();

        Scanner scn = new Scanner(System.in);

        boolean boolMenu = true;
        int opMenu = 0;

        boolean boolProduct = true;
        int opProduct = 0;

        while (boolMenu) {

            System.out.println("------------- Bienvenido al Sistema de Facturas Meli ---------------- ");
            System.out.println("1. Facturar" + "\n" +
                    "2. Revisar clientes actuales" + "\n" +
                    "3. Revisar histórico de facturas" + "\n" +
                    "4. Revisar registro de productos" + "\n" +
                    "5. Salir");
            System.out.println(">_ ");

            opMenu = scn.nextInt();
            scn.nextLine();

            switch (opMenu) {
                case 1:
                    String clientNumber = "";
                    Optional<Client> currentClient;
                    Client newClient = new Client();

                    Invoice invoice = new Invoice();
                    String invoiceId = "";

                    System.out.println("------------------------- Facturación ---------------------------- ");
                    System.out.print("Numero de client: ");
                    clientNumber = scn.nextLine();

                    currentClient = clientCRUD.get(clientNumber);

                    if (!currentClient.isPresent()) {

                        System.out.println("El cliente no existe, a continuación, procederá a añadir un cliente");
                        System.out.println();

                        System.out.print("Nombre: ");
                        newClient.setName(scn.nextLine());

                        System.out.print("Apellido: ");
                        newClient.setLastName(scn.nextLine());

                        System.out.print("DNI: ");
                        newClient.setDni(scn.nextLine());

                        clientCRUD.save(newClient);
                        System.out.println("El cliente se ha añadido!");
                        System.out.println();

                        invoice.setClient(newClient);

                    } else {
                        invoice.setClient(currentClient.get());
                    }

                    List<Product> products = new ArrayList<>();

                    while (boolProduct) {
                        Product newProduct = new Product();
                        System.out.println("A continuación, añada la información de los productos por favor");

                        System.out.print("Código del producto: ");
                        newProduct.setProductCode(scn.nextLine());

                        System.out.print("Nombre del producto: ");
                        newProduct.setName(scn.nextLine());

                        System.out.print("Valor unitario del producto: ");
                        newProduct.setCost(scn.nextDouble());
                        scn.nextLine();

                        System.out.print("Cantidad del producto:");
                        newProduct.setQuantity(scn.nextInt());
                        System.out.println();

                        products.add(newProduct);
                        productCRUD.save(newProduct);

                        System.out.println("¿Desea agregar un nuevo producto a la factura?");
                        System.out.println("1. Sí" + "\n" + "2. No");
                        System.out.print(">_ ");
                        opProduct = scn.nextInt();
                        scn.nextLine();

                        if (opProduct == 2) {
                            boolProduct = false;
                        }

                    }

                    System.out.println("Agregando factura....");
                    System.out.print("Identificador de factura: ");
                    invoiceId = scn.nextLine();

                    invoice.setInvoiceId(invoiceId);
                    invoice.setItems(products);
                    invoice.setTotal(products);

                    invoiceCRUD.save(invoice);
                    System.out.println("Facturación con éxito!");

                    boolProduct = true;
                    break;

                case 2:
                    System.out.println("------------------------- Clientes ---------------------------- ");
                    for (Client clients : clientCRUD.getAll()) {
                        System.out.println(clients.toString());
                    }
                    break;

                case 3:
                    System.out.println("---------------------- Facturas ------------------------------- ");
                    for (Invoice invoices : invoiceCRUD.getAll()) {
                        System.out.println(invoices.toString());
                    }
                    break;
                case 4:
                    System.out.println("---------------------- Productos ------------------------------- ");
                    for (Product items : productCRUD.getAll()) {
                        System.out.println(items.toString());
                    }

                    break;
                case 5:
                    System.out.println("Saliendo del programa");
                    boolMenu = false;
                    break;

                default:

                    System.out.println("Opción Incorrecta, saliendo del programa..");
                    boolMenu = false;
                    break;
            }

        }

        scn.close();
    }

}
