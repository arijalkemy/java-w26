package EjerciciosIntegradores.Supermercado;

import java.util.ArrayList;
import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Item> items;
    private double total;

    public Factura(Cliente cliente, List<Item> items) {
        this.cliente = cliente;
        this.items = items;
        this.total = 0;
        calcularTotal();
    }

    private void calcularTotal(){
        for (Item item : items) {
            this.total += item.getPrecio() * item.getCantidad();
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Factura{");
        sb.append("cliente=").append(cliente);
        sb.append(", items=").append(items);
        sb.append(", total=").append(total);
        sb.append('}');
        return sb.toString();
    }
}
