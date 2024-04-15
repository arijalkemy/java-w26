import java.util.List;

public class Factura {

    private Cliente cliente;
    private List<Item> listaItems;
    private double total;

    public Factura(Cliente cliente, List<Item> listaItems, double total) {
        this.cliente = cliente;
        this.listaItems = listaItems;
        this.total = total;
    }
}
