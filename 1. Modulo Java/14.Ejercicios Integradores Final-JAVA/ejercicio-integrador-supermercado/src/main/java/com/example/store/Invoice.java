package com.example.store;

import java.util.List;

public class Invoice {

    private String invoiceId;
    private Client client;
    private List<Product> items;
    private double total;

    public Invoice() {

    }

    public Invoice(String invoiceId, Client client, List<Product> items) {
        this.invoiceId = invoiceId;
        this.client = client;
        this.items = items;
    }

    public void setTotal(List<Product> items) {
        this.total = 0;
        for (Product product : items) {
            this.total += (product.getCost() * product.getQuantity());
        }
        
    }

    public double getTotal() {
        return total;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setItems(List<Product> items) {
        this.items = items;
    }

    public List<Product> getItems() {
        return items;
    }

    public String productsString(List<Product> products) {
        String str = "";
        for (Product product : products) {
            str = str + product.toString();
        }
        return str;
    }

    @Override
    public String toString() {

        return "\n"+ "----------------------------------" + "\n"+
                "ID Factura: " + this.getInvoiceId() + "\n"+
                "----------------------------------" + "\n"+
                "Cliente:" + "\n"+
                this.getClient().toString() + "\n" +
                "----------------------------------" + "\n"+
                "Productos: " + "\n" + 
                productsString(this.getItems()) + "\n"+
                "----------------------------------" + "\n"+
                "Total factura:" + this.getTotal()
                ;

    }
 

}
