package bootcamp.agenciaTurismo.localizador;

import java.util.List;
import java.util.stream.Collectors;

import bootcamp.agenciaTurismo.cliente.Cliente;

public class Localizador {

    private int id;
    private Cliente cliente;
    private List<Reserva> reservas;
    private double total;



    public Localizador(Integer id, Cliente cliente, List<Reserva> reservas) {
        this.id = id;
        this.cliente = cliente;
        this.reservas = reservas;
        this.total = getTotal();
    }

    public void applyDiscounts(double fidelityDiscount) {

        if (cliente.tieneDescuento()) this.total *= fidelityDiscount;
        if(isCompleto()) this.total *= 0.90;

        if(descuentoPorTipo(TiposProducto.HOTEL, 2) || descuentoPorTipo(TiposProducto.VUELOS, 2)) this.total *= 0.95;

    }

    private boolean isCompleto() {
        List<TiposProducto> tiposAsList = TiposProducto.asList();
        return this.reservas
                .stream()
                .map(Reserva::getProducto)
                .map(Producto::getTipo)
                .distinct()
                .filter(tiposAsList::contains)
                .count() == tiposAsList.size();
    }

    private boolean descuentoPorTipo(TiposProducto tipo, int cantidad) {
        return this.reservas
                .stream()
                .filter(reserva -> reserva.getProducto().getTipo().equals(tipo))
                .count() >= cantidad;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public double getTotal() {
        return reservas
                .stream()
                .mapToDouble(Reserva::calcularTotal)
                .sum();
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Localizador other = (Localizador) obj;
        return id != other.id &&
                cliente.getNombre().equals(other.cliente.getNombre()) &&
                reservas.equals(other.reservas);
    }

    @Override
    public String toString() {
        return String.format("Localizador: %d%nCliente: %s %s%n%s", this.id, this.cliente.getNombre(), this.cliente.getApellido(),reservasToString());
    }

    private String reservasToString() {
        return this.reservas.stream().map(Reserva::toString).collect(Collectors.joining("%n"));
    }
}