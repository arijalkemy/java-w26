import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Item> listaItems;
    private double costoTotalCompra;

    public Factura(Cliente cliente, List<Item> listaItems) {
        this.cliente = cliente;
        this.listaItems = listaItems;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getListaItems() {
        return listaItems;
    }

    public void setListaItems(List<Item> listaItems) {
        this.listaItems = listaItems;
    }

    public double getCostoTotalCompra() {
        return costoTotalCompra;
    }

    public void setCostoTotalCompra(double costoTotalCompra) {
        this.costoTotalCompra = costoTotalCompra;
    }

    public void calcularCostoTotalCompra() {
        double costoTotalVenta = 0;
        for (Item item : listaItems) {
            costoTotalVenta += item.getCantidad() * item.getCostoUnitario();
        }
        this.costoTotalCompra = costoTotalVenta;
    }
}
