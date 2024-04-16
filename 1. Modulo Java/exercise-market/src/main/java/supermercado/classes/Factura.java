package supermercado.classes;

import java.util.ArrayList;
import java.util.List;

public class Factura {
    private List<Item> items;

    public void setItems(List<Item> items) {
        this.items = items;
    }

    private Cliente cliente;

    public Factura(Cliente cliente) {
        this.cliente = cliente;
    }

    public void agregarItem(Item item) {
        this.items.add(item);
    }

    public double totalCompra() {
        double totalCompra = items.stream().mapToDouble(Item::costoTotal).sum();
        return totalCompra;
    }

    @Override
    public String toString() {
        return "Factura { " +
                "items = " + items + + '\n' +
                ", cliente = " + cliente + + '\n' +
                '}' + '\n' + "COSTO TOTAL : " + this.totalCompra();
    }
}
