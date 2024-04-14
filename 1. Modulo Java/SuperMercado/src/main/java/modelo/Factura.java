package modelo;

import java.util.List;

public class Factura {

    private int id;
    private static int counterId = 0;
    private Cliente cliente;
    private List<ItemFactura> itemFacturaList;
    private double totalDeLaCompra;

    public Factura(Cliente cliente, List<ItemFactura> itemFacturaList) {
        this.id = ++id;
        this.cliente = cliente;
        this.itemFacturaList = itemFacturaList;
        this.totalDeLaCompra = this.calcularTotal();
    }

    @Override
    public String toString() {

        return "FACTURA: " + this.getId() + ", del cliente: " + cliente.getDni() + ", de nombre: " + cliente.getNombre() +
                "\n TOTAL: " + this.getTotalDeLaCompra() + "\n ITEMS: \n" +
                itemFacturaList.toString();

    }

    private double calcularTotal(){
        return itemFacturaList.stream().mapToDouble(i -> i.cantidadComprada * i.costoUnitario).sum();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemFactura> getItemFacturaList() {
        return itemFacturaList;
    }

    public void setItemFacturaList(List<ItemFactura> itemFacturaList) {
        this.itemFacturaList = itemFacturaList;
    }

    public double getTotalDeLaCompra() {
        return totalDeLaCompra;
    }

    public void setTotalDeLaCompra(double totalDeLaCompra) {
        this.totalDeLaCompra = totalDeLaCompra;
    }
}
