import java.util.ArrayList;
import java.util.List;

public class Factura {
    private int idFactura;
    private Cliente cliente;
    private List<Item> items;

    private Factura(int idFactura, Cliente cliente, List<Item> items){
        this.idFactura = idFactura;
        this.cliente = cliente;
        this.items = new ArrayList<>();
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItems (Item item){
        items.add(item);
    }
}
