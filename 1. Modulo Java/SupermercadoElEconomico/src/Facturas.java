import java.util.List;

public class Facturas {
    private Cliente cliente;
    private List<Item> lista ;
    protected double precioTotal;

    public Facturas(Cliente cliente, List<Item> lista) {
        this.cliente = cliente;
        this.lista = lista;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getLista() {
        return lista;
    }

    public void setLista(List<Item> lista) {
        this.lista = lista;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    @Override
    public String toString() {
        return "Facturas {" +
                "cliente=" + cliente +
                ", lista=" + lista +
                ", precioTotal=" + precioTotal +
                '}';
    }
}
